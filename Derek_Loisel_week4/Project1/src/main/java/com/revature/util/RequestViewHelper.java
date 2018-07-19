package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] - Processing request with RequestViewHelper.process(): " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		
		case "/Project1/login.view":
			return "partials/login.html";
			
		case "/Project1/register.view":
			return "partials/register.html";
		
		case "/Project1/home.view":
			return "partials/home.html";
			
		case "/Project1/managerhome.view":
			return "partials/managerhome.html";
			
		case "/Project1/adminhome.view":
			return "partials/adminhome.html";
			
		case "/Project1/profile.view":
			return "partials/profile.html";
		default:
			return null;
		} 
	}

}
