

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

			ArrayList<Reimbursement> sessionUserReimbursements = service.getReimbursementsByUserID(sessionUser.getUserID());
			UserReimbursements homeInfo = new UserReimbursements(sessionUser, sessionUserReimbursements);

			return homeInfo;

		default:
			return null;
		}
	}
}
