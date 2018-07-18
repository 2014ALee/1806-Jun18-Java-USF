package com.revature.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.services.ERSService;

public class LoadInfoHelper {
	
	public Object process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] - Processing request with loadInfoHelper" + req.getRequestURI());
		
		switch(req.getRequestURI()) {
			case "/Project1/home.loadInfo":
				ERSService service = new ERSService();
				
				HttpSession session = req.getSession();
				Users sessionUser = (Users) session.getAttribute("user");
				sessionUser.setPassword("**********");
				ArrayList<Reimbursement> sessionUserReimbursements = new ArrayList<>();
				
				if(sessionUser.getRole_id() == 1) {
					sessionUserReimbursements = service.getAllReimbursements();
					int len = sessionUserReimbursements.size();
					int removed = 0;
					for(int i = 0; i < len; i++) {
						if(sessionUserReimbursements.get(i-removed).getAuthor() == sessionUser.getUser_id()) {
							sessionUserReimbursements.remove(i-removed);
							removed++;
						}
					}
				} else {
					sessionUserReimbursements = service.getReimbursements(sessionUser);
				}
				
				return sessionUserReimbursements;
			case "/Project1/manager.loadInfo":
				ERSService service1 = new ERSService();
				
				HttpSession session1 = req.getSession();
				Users sessionUser1 = (Users) session1.getAttribute("user");
				sessionUser1.setPassword("**********");
				ArrayList<Reimbursement> sessionUserReimbursements1 = new ArrayList<>();
				sessionUserReimbursements1 = service1.getReimbursements(sessionUser1);
				return sessionUserReimbursements1;
			default:
				return null;
		}
	}

}
