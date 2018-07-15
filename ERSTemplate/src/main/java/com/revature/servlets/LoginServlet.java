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


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to LoginServlet.doPost()");
	//	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
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
		String[] userInfo = mapper.readValue(json, String[].class);
		String userName = userInfo[0];
		String password = userInfo[1];
		
		//User temp = (service.getUserByUsername(username).getId() != 0) ? service.getUserByUsername(username) : null;
	
		User newUser = null;
		Boolean userInDB = false;
		
		if(ERS.userInDatabase(userName, password)) {
			userInDB = true;
			newUser = ERS.logIn(userName, password);
		}
		
		if(newUser == null) {
			System.out.println("[LOG] - Variable 'temp' in LoginServlet is null");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", newUser); // persists this user to the session
			System.out.println("our user is: " + newUser);
		}
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(newUser);
		pw.write(userJSON);
	}

}
