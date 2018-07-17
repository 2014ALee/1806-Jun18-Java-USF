package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {

	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] - Processing request with RequestVewHelp.processs(): " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/EmployeeReimbursementSystem/login.view":
			return "partials/login.html";
		case "/EmployeeReimbursementSystem/register.view":
			return "partials/register.html";
		case "/EmployeeReimbursementSystem/home.view":
			return "partials/home.html";
		case "/EmployeeReimbursementSystem/create.view":
			return "partials/create.html";
		case "/EmployeeReimbursementSystem/profile.view":
			return "partials/profile.html";
		case "/EmployeeReimbursementSystem/logout.view":
			return "partials/logout.html";
		default:
			return null;
		}
	}
}