package com.revature.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.UserReimbursements;
import com.revature.service.ErsService;

public class LoadInfoHelper {

	public Object process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] - Processing request with LoadInfoHelper: " + req.getRequestURI());

		switch(req.getRequestURI()) {

		case "/jbein-project1/reimbursement.loadinfo":
			ErsService service = new ErsService();
 
			HttpSession session = req.getSession();
			User sessionUser = (User) session.getAttribute("user");
			sessionUser.setErs_password("***************");

			
			ArrayList<Reimbursement> sessionUserReimbursements = service.getReimbursmentsByAuthor(sessionUser.getErs_users_id());
			UserReimbursements reimbursementInfo = new UserReimbursements(sessionUser, sessionUserReimbursements);

			return reimbursementInfo;
			
		case "/jbein-project1/allreimbursements.loadinfo":
			ErsService service2 = new ErsService();

			HttpSession session2 = req.getSession();
			User sessionUser2 = (User) session2.getAttribute("user");
			sessionUser2.setErs_password("***************");
			
			ArrayList<Reimbursement> allReimbursements = service2.getAllReimbursements();
			UserReimbursements empReimbursementInfo = new UserReimbursements(sessionUser2, allReimbursements);

			System.out.println(empReimbursementInfo);

			return empReimbursementInfo;
			
		case "/jbein-project1/pendingreimbursements.loadinfo":
			ErsService service3 = new ErsService();

			HttpSession session3 = req.getSession();
			User sessionUser3 = (User) session3.getAttribute("user");
			sessionUser3.setErs_password("***************");
			
			
			ArrayList<Reimbursement> pendingReimbursements =  service3.getAllReimbursementsByStatus(1);
			UserReimbursements pendingReimbursementInfo = new UserReimbursements(sessionUser3, pendingReimbursements);

			System.out.println(pendingReimbursementInfo);

			return pendingReimbursementInfo;
			
		case "/jbein-project1/approvedreimbursements.loadinfo":
			ErsService service4 = new ErsService();

			HttpSession session4 = req.getSession();
			User sessionUser4 = (User) session4.getAttribute("user");
			sessionUser4.setErs_password("***************");
			
			ArrayList<Reimbursement> approvedReimbursements = service4.getAllReimbursementsByStatus(2);
			UserReimbursements approvedReimbursementInfo = new UserReimbursements(sessionUser4, approvedReimbursements);

			System.out.println(approvedReimbursementInfo);

			return approvedReimbursementInfo;
			
		case "/jbein-project1/deniedreimbursements.loadinfo":
			ErsService service5 = new ErsService();

			HttpSession session5 = req.getSession();
			User sessionUser5 = (User) session5.getAttribute("user");
			sessionUser5.setErs_password("***************");
			
			ArrayList<Reimbursement> deniedReimbursements = service5.getAllReimbursementsByStatus(3);
			UserReimbursements deniedReimbursementInfo = new UserReimbursements(sessionUser5, deniedReimbursements);

			System.out.println(deniedReimbursementInfo);

			return deniedReimbursementInfo;
			
		case "/jbein-project1/editreimbursements.loadinfo":
			
			System.out.println("In editreimbursements.loadInfo");
			
			ErsService service7 = new ErsService();

			HttpSession session7 = req.getSession();
			User sessionUser7 = (User) session7.getAttribute("user");
			sessionUser7.setErs_password("***************");
			
			ArrayList<Reimbursement> allEditReimbursements = service7.getAllReimbursements();
			UserReimbursements empEditReimbursementInfo = new UserReimbursements(sessionUser7, allEditReimbursements);

			System.out.println(empEditReimbursementInfo);

			return empEditReimbursementInfo;
			
		case "/jbein-project1/updatereimbursements.loadinfo":
			ErsService service6 = new ErsService();

			HttpSession session6 = req.getSession();
			User sessionUser6 = (User) session6.getAttribute("user");
			sessionUser6.setErs_password("***************");
			
			Reimbursement sessionReimb = (Reimbursement) session6.getAttribute("reimb");
			Reimbursement empReimb = service6.getReimbursementById(sessionReimb.getReimb_id());
			boolean editReimbursements = service6.updateType(sessionUser6, empReimb);


			return editReimbursements;
			
		default:
			System.out.print("defaulting to null");
			return null;
		}
	}
	
}
