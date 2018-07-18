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


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	EmployeeReimbursementSystem ERS = new EmployeeReimbursementSystem();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to LoginRegister.doPost()");
		
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
		String[] registerInfo = mapper.readValue(json, String[].class);
		
		String userName = registerInfo[0];
		String password = registerInfo[1];
		String firstName = registerInfo[2];
		String lastName = registerInfo[3];
		String email = registerInfo[4];
		String accountType = registerInfo[5];
		
		User newUser = new User(userName, password, firstName, lastName, email, accountType);
		boolean successfulRegister = false;
		
		if(ERS.registrationValid(newUser)) {
			ERS.registerUser(newUser);
			successfulRegister = true;
		} else {
			successfulRegister = false;
		}
		
		//User temp = (service.getUserByUsername(username).getId() != 0) ? service.getUserByUsername(username) : null;
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(successfulRegister);
		pw.write(userJSON);
	}

}
