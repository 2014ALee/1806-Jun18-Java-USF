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
import com.revature.models.User;


@WebServlet("/reimbursements")
public class ReimbursementServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to ReimbursementServlet.doPost()");
		EmployeeReimbursementSystem ERS = new EmployeeReimbursementSystem();
		
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
		
		User[] users;
		
		users = mapper.readValue(json, User[].class);
	
		User user = ERS.getReimbursements(users[0]);
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(user);
		pw.write(userJSON);
	}

}
