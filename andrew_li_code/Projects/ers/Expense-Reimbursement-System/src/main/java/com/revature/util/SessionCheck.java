package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.models.ERSUser;

public class SessionCheck {
	public static ERSUser checkSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return checkSession(session);	
	}
	
	public static ERSUser checkSession(HttpSession session) {
		Object sessionObj = session.getAttribute("user");
		if (sessionObj == null) {
			System.out.println("No session!");
			return null;
		}
		try {
			System.out.println("Session!");
			return (ERSUser) session.getAttribute("user");
		} catch (ClassCastException e) {
			System.out.println("How did this happen?");
		}
		return null;		
	}
}
