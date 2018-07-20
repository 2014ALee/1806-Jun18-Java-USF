package com.revature.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.UserReimbursements;
import com.revature.service.ErsService;

public class LoadAllinfoHelper {

	public Object process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] - Processing request with LoadAllinfoHelper: " + req.getRequestURI());

		switch(req.getRequestURI()) {

		case "/jbein-project1/allreimbursements.loadinfo":
			ErsService service = new ErsService();

			HttpSession session = req.getSession();
			User sessionUser = (User) session.getAttribute("user");
			sessionUser.setErs_password("***************");
			
			ArrayList<Reimbursement> allReimbursements = service.getAllReimbursements();
			UserReimbursements empReimbursementInfo = new UserReimbursements(sessionUser, allReimbursements);

			return empReimbursementInfo; 

		default:
			System.out.print("defaulting to null");
			return null;
		}
	}
	
}
