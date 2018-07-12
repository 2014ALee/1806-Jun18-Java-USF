package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {
	public String process(HttpServletRequest req, HttpServletResponse reps) {
		System.out.println("[LOG] - Processing request with RequestViewHelper.process()");
		
		switch(req.getRequestURI()) {
		case "/project_1_with_ajax/login.view":
			return "partials/login.html";
		default:
			return null;
		}
	}
}
