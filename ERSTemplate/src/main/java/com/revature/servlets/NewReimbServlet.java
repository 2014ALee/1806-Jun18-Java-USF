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
import com.revature.models.EmployeeReimbursementSystem;
import com.revature.models.Reimbursement;
import com.revature.models.User;


@WebServlet("/newReimb")
public class NewReimbServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to NewReimbServlet.doPost()");
		EmployeeReimbursementSystem ERS = new EmployeeReimbursementSystem();
		User sessionUser = (User) req.getSession().getAttribute("user");
		Reimbursement newReimb;
		
		if(sessionUser == null) {
			System.out.println("in newReimbServlet - our session user is null!");
			newReimb = null;
		}

		// 1) Get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

		String json = "";
		if(br != null) {
			json = br.readLine();
		}

		System.out.println("OUR JSON STRING IS " + json);
		// 2) Initiate the Jackson object mapper (allow for conversion to and from Java objects to JSON)
		ObjectMapper mapper = new ObjectMapper();

		// 3) Convert received JSON to String array
		String[] reimbInfo = mapper.readValue(json, String[].class);

		String type = reimbInfo[2];
		String description = reimbInfo[1];
		Double amount = Double.parseDouble(reimbInfo[0]);
		int userID = sessionUser.getUserID();

		newReimb = ERS.addReimbursement(type, description, amount, userID);

		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");

		System.out.println("Our new reimb is " + newReimb);
		System.out.println("Our new reimb amount is " + newReimb.getReimbursementAmount());

		//we write boolean of true or false
		String userJSON = mapper.writeValueAsString(newReimb);
		
		System.out.println("Our new reimb JSON is " + userJSON);
		
		pw.write(userJSON);
	}
}
