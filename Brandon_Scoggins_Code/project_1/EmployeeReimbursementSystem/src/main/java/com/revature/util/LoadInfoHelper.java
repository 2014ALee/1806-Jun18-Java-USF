package com.revature.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.ERSReimbursement;
import com.revature.models.ERSUser;
import com.revature.services.ERSService;

public class LoadInfoHelper {

	public Object[] process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] - Processing request with LoadInfoHelper: " + req.getRequestURI());
		
		ERSService service = new ERSService();
		
		HttpSession session = req.getSession();
		ERSUser sessionUser = (ERSUser) session.getAttribute("user");
		
		ArrayList<ERSReimbursement> sessionUserReimbursements = service.getUserReimbursements(sessionUser);
		
		return new Object[] {sessionUser, sessionUserReimbursements};
		
	}
}
