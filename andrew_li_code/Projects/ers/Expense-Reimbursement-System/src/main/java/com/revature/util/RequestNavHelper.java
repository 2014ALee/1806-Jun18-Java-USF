package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.ERSUser;
import com.revature.models.UserRole;
// import com.revature.models.UserRole;

public class RequestNavHelper {
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] Request sent to front controller, LoadViewServlet"
				+ ".process(HttpServletRequest, HttpServletResponse)");
		String uri = req.getRequestURI();
		switch(uri) {
		case "/Expense-Reimbursement-System/home.nav":
			return selectNav(req);
		case "/Expense-Reimbursement-System/main.nav":
			return selectNav(req);
		case "/Expense-Reimbursement-System/guesthome.nav":
			return "navs/guesthome.html";
		case "/Expense-Reimbursement-System/userhome.nav":
			return "navs/userhome.html";
		case "/Expense-Reimbursement-System/managerhome.nav":
			return "navs/managerhome.html";
		default:
			System.out.println("NULL EXCEPTION");
			System.out.println(uri);
			return null;
		}
	}
	private String selectNav(HttpServletRequest req) {
		ERSUser ersUser = SessionCheck.checkSession(req);
		if (ersUser == null) {
			return "navs/guesthome.html";
		}
		if (ersUser.getRole() == UserRole.FINANCE_MANAGER) {
			return "navs/managerhome.html";
		}
		return "navs/userhome.html";
	}
}
