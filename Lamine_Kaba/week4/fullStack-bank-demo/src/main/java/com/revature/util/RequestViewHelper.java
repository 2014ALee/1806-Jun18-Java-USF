package com.revature.util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("LOG  Processing request with requestViewHelper.process(): " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/fullStack-bank-demo/login.view":
			return "partials/login.html";
		case "/fullStack-bank-demo/register.view":
			return "partials/register.html";
		default:
				return null;
		}
	}

}
