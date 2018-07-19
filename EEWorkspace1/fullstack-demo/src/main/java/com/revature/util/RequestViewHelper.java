package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("RequestViewHelper.process() called: " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		
		case "/fullstack-demo/login.view":
			return "partials/login.html";
			
		case "/fullstack-demo/register.view":
			return "partials/register.html";
			
		case "/fullstack-demo/home.view":
			return "/partials/home.html";
		default:
			return null;
		}
	}
}
