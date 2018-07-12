package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("[LOG] - Processing request with RequestViewHelper.process(); " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/fullstack-bank-demo/login.view":
			return "partials/login.html";
		case "/fullstack-bank-demo/register.view":
			return "partials/register.html";
		default:
			return null;
		}
	}

}
