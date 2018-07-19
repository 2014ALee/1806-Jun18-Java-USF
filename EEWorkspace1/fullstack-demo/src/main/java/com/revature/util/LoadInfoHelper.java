package com.revature.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.models.UserAccounts;
import com.revature.services.BankService;

public class LoadInfoHelper {
	public Object process(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Request in LoadInfoHelper: "+req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/fullstack-demo/home.loadinfo":
			BankService service = new BankService();
			
			HttpSession session = req.getSession();
			User sessionUser = (User) session.getAttribute("user");
			sessionUser.setPassword("***************");
			
			ArrayList<Account> sessionUserAccounts = service.getUserAccounts(sessionUser);
			UserAccounts homeInfo = new UserAccounts(sessionUser, sessionUserAccounts);
			return homeInfo;
			
		default:
			return null;
		}
	}

}
