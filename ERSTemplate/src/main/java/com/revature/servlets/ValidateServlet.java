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
import com.revature.models.EmployeeReimbursementSystem;


@WebServlet("*.validate")
public class ValidateServlet extends HttpServlet {

	EmployeeReimbursementSystem test = new EmployeeReimbursementSystem();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to front controller, LoadViewServlet.doGet()");

		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

		String json = "";
		if(br != null) {
			json = br.readLine();
		}

		System.out.println("OUR JSON STRING IS " + json);
		
		ObjectMapper mapper = new ObjectMapper();
		
		// 3) Convert received JSON to String array
		String[] validationInfo = mapper.readValue(json, String[].class);
		String validationType = validationInfo[0];
		String toValidate = validationInfo[1];
		
		boolean isValid = checkValidation(validationType, toValidate);
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(isValid);
		pw.write(userJSON);	
	}


	public boolean checkValidation(String validationType, String toValidate) {
		
		System.out.println(validationType + "is the validation type");
		
		if(validationType.equals("email")) {	
			return test.checkEmail(toValidate);

		} else if(validationType.equals("userName")) {
			System.out.println(toValidate + "is the username we are checking out");
			return test.checkUserName(toValidate);

		} else {
			return false;
		}
	}
}
