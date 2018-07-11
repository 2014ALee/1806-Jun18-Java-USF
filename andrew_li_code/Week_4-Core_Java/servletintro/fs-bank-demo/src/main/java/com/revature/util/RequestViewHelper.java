package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] Request sent to front controller, LoadViewServlet"
				+ ".process(HttpServletRequest, HttpServletResponse)");
		String uri = req.getRequestURI();
		switch(uri) {
		
		case "/fs-bank-demo/login.view":
			return "partials/login.html";
		case "/fs-bank-demo/register.view":
			return "partials/register.html";
		default:
			System.out.println("NULL EXCEPTION");
			System.out.println(uri);
			return null;
		}
		
	}
}
