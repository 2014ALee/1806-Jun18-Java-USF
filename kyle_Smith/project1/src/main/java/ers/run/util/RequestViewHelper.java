package ers.run.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] - Processing request with RequestViewHelper.process(): " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		
		case "/project1/login.view":
			return "partials/login.html";
			
		case "/project1/register.view":
			return "partials/register.html";
			
		case "/project1/home.view":
			return "partials/home.html";
			
		case "/project1/adminHome.view":
			return "partials/adminHome.html";
			
		case "/project1/managerHome.view":
			return "partials/managerHome.html";
		default:
			return null;
		}
	}

}
