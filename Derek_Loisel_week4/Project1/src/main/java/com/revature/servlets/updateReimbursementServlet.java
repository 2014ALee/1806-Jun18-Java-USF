package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ErsService;

@WebServlet("/updatereimbursement")
public class updateReimbursementServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to updateReimbursementServlet.doPost()");

		ErsService service = new ErsService();

		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

		String json = "";
		if(br != null) {
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();
		Reimbursement temp = mapper.readValue(json, Reimbursement.class);

		//		System.out.println("date resolved from servlet: " +temp.getReimbursementResolved());
		//		System.out.println("resolver from servlet: " +temp.getReimbursementResolver());
		//		System.out.println("status id from servlet: " +temp.getReimbursementStatusID());

		//get user id from current session user to make sure manager doesnt approve his own reimbursements
		HttpSession sessionUser = req.getSession(false);		
		User u = (User)sessionUser.getAttribute("user");	

		boolean updateSuccessful = false;
		if (temp != null) {
			//check if your updating by author or reimbursement id
			
			//checking by reimb id
			if(!(temp.getReimbursementAuthor() > 0)) {
				//check the database to return all of this session user's reimbursements
				ArrayList<Reimbursement> rl = service.getReimbursementsByUserID(u.getUserID());
				//make sure none of the returned reimbursement id's match the temp.getReimbursementID
				boolean tempBool = true;
				for(Reimbursement reimb : rl) {
					if(reimb.getReimbursementID() == temp.getReimbursementID()) {
						//if any of the reimb ids match the current reimb id then dont update
						tempBool = false;
					}				
				}
				if(tempBool) {
					//update the reimbursement by id if no ids matched
					updateSuccessful = service.updateReimbursementByReimbursementID(temp);
				}
			}
			
			//checking by author
			if(!(temp.getReimbursementID() > 0)) {
				// check that the author doesn't match the current session user's id
				if(u.getUserID() != temp.getReimbursementAuthor()) {
					//update the reimbursements by author
					updateSuccessful = service.updateReimbursementsByAuthor(temp);
				}

			}
		}

		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");

		String reimbJSON = mapper.writeValueAsString(updateSuccessful);
		pw.write(reimbJSON);
	}

}