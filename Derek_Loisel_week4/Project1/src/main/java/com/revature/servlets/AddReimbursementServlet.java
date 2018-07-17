package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ErsService;

@WebServlet("/addreimbursement")
public class AddReimbursementServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to AddReimbursementServlet.doPost()");

		ErsService service = new ErsService();

		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

		String json = "";
		if(br != null) {
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();
		Reimbursement temp = mapper.readValue(json, Reimbursement.class);

		
		
		System.out.println("amount from servlet: " +  temp.getReimbursementAmount());
		System.out.println("date submitted from servlet: " +temp.getReimbursementSubmitted());
		System.out.println("date resolved from servlet: " +temp.getReimbursementResolved());
		System.out.println("description from servlet: " +temp.getReimbursementDescription());
		System.out.println("author from servlet: " +temp.getReimbursementAuthor());
		System.out.println("resolver from servlet: " +temp.getReimbursementResolver());
		System.out.println("status id from servlet: " +temp.getReimbursementStatusID());
		System.out.println("type id from servlet: " +temp.getReimbursementTypeID());

		//check for null or default values from user input in temp to make sure its a full reimbursem	ent
		if(!(temp.getReimbursementAmount() > 0) ||
				temp.getReimbursementDescription() == "" || temp.getReimbursementDescription() == null ||
				(temp.getReimbursementTypeID() != 1 && temp.getReimbursementTypeID() != 2 && temp.getReimbursementTypeID() != 3 )){
			temp = null;			
		}

		if (temp != null) {
			//call service method to add reimbursement
			temp = service.addReimbursement(temp);
		}

		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");

		String reimbJSON = mapper.writeValueAsString(temp);
		pw.write(reimbJSON);
	}

}