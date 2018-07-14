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
		default:
			return null;
		}
	}
}
