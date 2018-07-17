

package com.revature.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.UserReimbursements;
import com.revature.services.ErsService;

public class LoadInfoHelper {

	public Object process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] - Processing request with LoadInfoHelper: " + req.getRequestURI());

		switch(req.getRequestURI()) {

		case "/Project1/home.loadinfo":
			ErsService service = new ErsService();

			HttpSession session = req.getSession();
			User sessionUser = (User) session.getAttribute("user");
			sessionUser.setPassword("***************");
				System.out.println("user role ID in LoadInfoHelper: " + sessionUser.getUserRoleID());
			//return home info depending on the users role
			if(sessionUser.getUserRoleID() == 1) {
			//return info depending on the users role
			//employee returns all personal reimbursements
				System.out.println("user ID in LoadInfoHelper: " + sessionUser.getUserID());
			ArrayList<Reimbursement> sessionUserReimbursements = service.getReimbursementsByUserID(sessionUser.getUserID());
				System.out.println("user reimbursements length from LoadInfoHelper: " + sessionUserReimbursements.size());
			UserReimbursements homeInfo = new UserReimbursements(sessionUser, sessionUserReimbursements);
			return homeInfo;
			}else {
			//manager and admin returns all reimbursements
			ArrayList<Reimbursement> sessionAllReimbursements = service.getAllReimbursements();
			UserReimbursements managerHomeInfo = new UserReimbursements(sessionUser, sessionAllReimbursements);
			return managerHomeInfo;
			}

		default:
			return null;
		}
	}
}
