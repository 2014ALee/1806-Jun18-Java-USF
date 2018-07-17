package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {
	public String process(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("[LOG] - Processing reauest with RequestViewHelper.process(): " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/bank-full-stack/login.view":
			return "/partials/login.html";
		case "/bank-full-stack/register.view":
			return "/partials/register.html";
		default:
			return null;
		}
	}
}
