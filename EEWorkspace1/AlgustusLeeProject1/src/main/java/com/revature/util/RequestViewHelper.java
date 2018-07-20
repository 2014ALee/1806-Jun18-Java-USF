package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {
	public String process(HttpServletRequest req, HttpServletResponse res) {
		//System.out.println("Processing called somehow");
		switch (req.getRequestURI()) {
		case "/AlgustusLeeProject1/login.view":
			return "partials/login.html";
			
		case "/AlgustusLeeProject1/home.view":
			return "partials/home.html";
			
		case "/AlgustusLeeProject1/register.view":
			return "partials/register.html";
			
		case "/AlgustusLeeProject1/reimbs.view":
			return "partials/reimbursements.html";
			
		case "/AlgustusLeeProject1/homeAdmin.view":
			return "partials/homeAdmin.html";
			
		case "/AlgustusLeeProject1/loadRegisterAdmin.view":
			return "partials/RegisterAdmin.html";
			
		case "/AlgustusLeeProject1/loadAllReimbs.view":
			return "partials/AllReimbs.html";
			
		case "/AlgustusLeeProject1/loadEditReimbs.view":
			return "partials/EditReimbs.html";
			
		case "/AlgustusLeeProject1/NewReimbPage.view":
			return "partials/NewReimbPage.html";
		
		default:
		return null;
		}
		
	}
}
