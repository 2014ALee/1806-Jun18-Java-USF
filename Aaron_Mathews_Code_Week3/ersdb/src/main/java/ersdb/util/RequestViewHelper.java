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
		case "/ersdb/submitReimb.view":
			return "partials/submitReimb.html";
		case "/ersdb/reimbDetails.view":
			return "partials/reimbDetails.html";
		case "/ersdb/userProfile.view":
			return "partials/userProfile.html";
		case "/ersdb/adminTools.view":
			return "partials/adminTools.html";
		case "/ersdb/adminViewUsers.view":
			return "partials/adminViewUsers.html";
		case "/ersdb/adminUserDetails.view":
			return "partials/adminUserDetails.html";
		case "/ersdb/managerTools.view":
			return "partials/managerTools.html";
		case "/ersdb/managerViewUsers.view":
			return "partials/managerViewUsers.html";
		case "/ersdb/managerUserDetails.view":
			return "partials/managerUserDetails.html";
		case "/ersdb/managerReimbDetails.view":
			return "partials/managerReimbDetails.html";
		case "/ersdb/managerViewReimb.view":
			return "partials/managerViewReimb.html";
		default:
			return null;
		}
	}

}
