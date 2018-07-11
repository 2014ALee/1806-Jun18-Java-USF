package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {

	
	//just a helper to process our request and see what kind of request we want
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] - Processing request with RequestViewHelper.process(): " + req.getRequestURI()); //can tell where request came from with getrequesturi
	
		switch(req.getRequestURI()) {
		case "/fs-bank-demo-1/login.view":
			return "partials/login.html";
		case "/fs-bank-demo-1/register.view":
			return "partials/register.html";
			default:
				return null;
		
		}
	}
}
