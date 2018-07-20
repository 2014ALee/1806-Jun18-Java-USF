package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] - Processing request with RequestViewHelper.process(): " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		
		case "/jbein-project1/login.view":
			return "partials/login.html";
		
		case "/jbein-project1/register.view":
			return "partials/register.html";
			
		case "/jbein-project1/home.view":
			return "partials/home.html";
			 
		case "/jbein-project1/employee-reimbursement.view":
			return "partials/employee-reimbursement.html";
			
		case "/jbein-project1/manager-reimbursement.view":
			return "partials/manager-reimbursements.html";
			
		case "/jbein-project1/all-reimbursements.view":
			return "partials/all-reimbursements.html";
			
		case "/jbein-project1/pending-reimbursements.view":
			return "partials/pending-reimbursements.html";
			
		case "/jbein-project1/approved-reimbursements.view":
			return "partials/approved-reimbursements.html";
			
		case "/jbein-project1/denied-reimbursements.view":
			return "partials/denied-reimbursements.html";
			
		case "/jbein-project1/edit-reimbursements.view":
			return "partials/edit-reimbursements.html";
			
		default:
			return null;
		}
	}

}
