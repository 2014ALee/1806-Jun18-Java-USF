package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {
	
	private final String uri = "/ERS_project/";

	public String process(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("[LOG] - Request sent to RequestViewHelper.process()");
		switch(req.getRequestURI()) {
		case uri + "login.view":
			return "partials/login.html";
		case uri + "register.view":
			return "partials/register.html";
		case uri + "reimbursements.view":
			return "partials/reimbursements.html";
		default:
			return null;
		}
	}
}
