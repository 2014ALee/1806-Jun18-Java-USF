package com.revature;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;

public class NgBankDriver {
	
	public static void main(String[] args) {
		
		System.out.println("Spinning up NgBankDriver...");
		
		UserDAO userDao = new UserDAOImpl();
		
		User admin = userDao.getUserByUsername("test");
		
		System.out.println("Shutting down NgBankDriver...");
	}

}
