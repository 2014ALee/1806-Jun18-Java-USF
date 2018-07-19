package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] - Processing request with RequestViewHelper.process(): " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		
		case "/ERS/login.view":
			return "partials/login.html";
			
		case "/ERS/register.view":
			return "partials/register.html";
			
		case "/ERS/home.view":
			return "partials/home.html";
		
		default:
			return null;
		}
	}

}