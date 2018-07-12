package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] - Processing request with RequestViewHelper.process(): " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/fs-bank-demo/login.view":
			return "partials/login.html";
		case "/fs-bank-demo/register.view":
			return "partials/register.html";
<<<<<<< HEAD:kyle_Smith/fs-bank-demo/src/main/java/com/revature/util/RequestViewHelper.java
=======
			
		case "/fs-bank-demo/home.view":
			return "partials/home.html";
		
>>>>>>> 03f188ee313ad1286669256e221f716f946ee075:Week_4-Servlets_Angular/fs-bank-demo/src/main/java/com/revature/util/RequestViewHelper.java
		default:
			return null;
		}
	}

}
