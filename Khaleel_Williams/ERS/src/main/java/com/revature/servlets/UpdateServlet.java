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
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.services.BankDaoServices;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to RegistrationServlet.doPost()");



		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";

		if(br != null) {
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();
		//Users temp = new Users();
		Reimbursement[] s = mapper.readValue(json, Reimbursement[].class);

		HttpSession session = req.getSession();
		Users currentUser = (Users) session.getAttribute("user");

		for (Reimbursement reimb: s) {
			BankDaoServices bankService = new BankDaoServices();

			if ((reimb.getAct().equals("DENY")) || (reimb.getAct().equals("APPROVE"))) {
				//System.out.println("id = "+ reimb.getReimbId() + " act = " + reimb.getAct());}
				
				if (reimb.getAct().equals("DENY") ) {
					bankService.updateReimb(reimb.getReimbId(), currentUser.getUserId(),  3);
				} else {
					bankService.updateReimb(reimb.getReimbId(), currentUser.getUserId(),  2);
				}
				//bankService.updateReimb(reimb, currentUser.getUserId(),  )
			}
		}


		//boolean bool = service.addUser(temp);
		//System.out.println("bool = " + bool);


		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");

		String userJSON = mapper.writeValueAsString(1);
		pw.write(userJSON);
	}

}