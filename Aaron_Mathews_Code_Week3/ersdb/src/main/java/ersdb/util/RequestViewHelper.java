package ersdb.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("[LOG] - Processing request with RequestViewHelper.process(); " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/ersdb/login.view":
			return "partials/login.html";
		case "/ersdb/signup.view":
			return "partials/signup.html";
		case "/ersdb/adminhome.view":
			return "partials/adminhome.html";
		case "/ersdb/managerhome.view":
			return "partials/managerhome.html";
		case "/ersdb/home.view":
			return "partials/home.html";
		case "/ersdb/userReim.view":
			return "partials/userReim.html";
		case "/ersdb/reimbursements.view":
			return "partials/reimbursements.html";
		default:
			return null;
		}
	}

}
