package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.ERSUser;
import com.revature.models.UserRole;

public class RequestViewHelper {
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] Request sent to front controller, LoadViewServlet"
				+ ".process(HttpServletRequest, HttpServletResponse)");
		String uri = req.getRequestURI();
		switch(uri) {
		
		case "/Expense-Reimbursement-System/login.view":
			return "partials/login.html";
		case "/Expense-Reimbursement-System/register.view":
			return "partials/register.html";
		case "/Expense-Reimbursement-System/registration-success.view":
			return "partials/finishregistration.html";
		case "/Expense-Reimbursement-System/home.view":
			return selectHome(req);
		case "/Expense-Reimbursement-System/guesthome.view":
			return "partials/guesthome.html";
		case "/Expense-Reimbursement-System/userhome.view":
			return "partials/userhome.html";
		case "/Expense-Reimbursement-System/managerhome.view":
			return "partials/managerhome.html";
		case "/Expense-Reimbursement-System/submit-request.view":
			return "partials/submitrequest.html";
		case "/Expense-Reimbursement-System/finish-submit-request.view":
			return "partials/finishsubmittingrequest.html";
		case "/Expense-Reimbursement-System/main.view":
			return selectHome(req);
		default:
			System.out.println("NULL EXCEPTION");
			System.out.println(uri);
			return null;
		}
		
	}
	private String selectHome(HttpServletRequest req) {

		ERSUser ersUser = SessionCheck.checkSession(req);
		if (ersUser == null) {
			return "partials/guesthome.html";
		}
		if (ersUser.getRole() == UserRole.REGULAR) {
			return "partials/userhome.html";
		} else if (ersUser.getRole() == UserRole.FINANCE_MANAGER) {
			return "partials/managerhome.html";
		}
		return "partials/guesthome.html";
	}
}

/*
window['getOldRequests'] = function() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let errorIndex = xhr.responseText.indexOf('error:');
			if (errorIndex >= 0 && errorIndex < 7) {
				alert(xhr.responseText.substring(errorIndex + 6));
				return;
			}
			try {
				window['oldRequestsList'] = JSON.parse(xhr.responseText);
			} catch (e) { console.log(e); }
			for (let i = 0; i < window['oldRequestsList'].length; i++) {
				window['oldRequestsList'][i] = JSON.parse(window['oldRequestsList'][i]);
				window['oldRequestsList'][i]['author'] = JSON.parse(window['oldRequestsList'][i]['author']);
			}
			for (let i = 0; i < window['oldRequestsList'].length; i++) {
				console.log(window['oldRequestsList'][i]);
			}
		}
	}
	xhr.open('GET', '/Expense-Reimbursement-System/personaltickets', true);
	xhr.send();
}
 */
