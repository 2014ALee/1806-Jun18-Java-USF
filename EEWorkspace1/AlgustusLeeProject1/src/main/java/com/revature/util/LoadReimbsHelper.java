package com.revature.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.UserReimbursements;
import com.revature.service.ErsService;

public class LoadReimbsHelper {
	public Object process(HttpServletRequest req, HttpServletResponse res) {
		//System.out.println("ReimbHelper called");
		ErsService eservice = new ErsService();
		switch(req.getRequestURI()) {
		case "/AlgustusLeeProject1/reimbs.loadReimbs":
			
			HttpSession session = req.getSession();
			User currentUser = (User)session.getAttribute("user");
			currentUser.setPassword("**************************");
			
			ArrayList<Reimbursement> currentUserReimbs = eservice.getReimbursements(currentUser);
			UserReimbursements reimbInfo = new UserReimbursements(currentUser, currentUserReimbs);
			
			return reimbInfo;
		case "/AlgustusLeeProject1/oldReimbs.loadReimbs":
			
			HttpSession session1 = req.getSession();
			User currentUser1 = (User)session1.getAttribute("user");
			currentUser1.setPassword("**************************");
			
			ArrayList<Reimbursement> currentUserReimbs1 = eservice.getPastReimbursements(currentUser1);
			UserReimbursements pastReimbInfo = new UserReimbursements(currentUser1, currentUserReimbs1);
			
			return pastReimbInfo;
		case "/AlgustusLeeProject1/editReimbs.loadReimbs":
			
			HttpSession session2 = req.getSession();
			User currentAdmin = (User)session2.getAttribute("user");
			currentAdmin.setPassword("**************************");
			
			ArrayList<Reimbursement> currentAdminReimbs = eservice.getEditReimbursements(currentAdmin);
			UserReimbursements editInfo = new UserReimbursements(currentAdmin, currentAdminReimbs);
			
			return editInfo;
		case "/AlgustusLeeProject1/allReimbs.loadReimbs":
			
			HttpSession session3 = req.getSession();
			User currentAdmin1 = (User)session3.getAttribute("user");
			currentAdmin1.setPassword("**************************");
			
			ArrayList<Reimbursement> currentAdminReimbs1 = eservice.getAllReimbursements(currentAdmin1);
			UserReimbursements allInfo = new UserReimbursements(currentAdmin1, currentAdminReimbs1);
			
			return allInfo;
		default:
			return null;
		}
	}

}
