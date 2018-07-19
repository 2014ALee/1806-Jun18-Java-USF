package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.User;

public class LoadUserHelper {
	public Object process(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("UserHelper called");
		switch(req.getRequestURI()) {
		case "/AlgustusLeeProject1/user.loadUser":
			
			HttpSession session = req.getSession();
			User currentUser = (User)session.getAttribute("user");
			currentUser.setPassword("**************************");
			
			
			return currentUser;
		case "/AlgustusLeeProject1/admin.loadUser":
			HttpSession session1 = req.getSession();
			User currentUser1 = (User)session1.getAttribute("user");
			currentUser1.setPassword("**************************");
			
			return currentUser1;
		default:
			return null;
		}
	}
}
