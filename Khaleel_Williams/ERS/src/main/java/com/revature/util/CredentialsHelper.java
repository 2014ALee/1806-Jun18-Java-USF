package com.revature.util;

import com.revature.dao.ImplementUsers;
import com.revature.models.Users;

public class CredentialsHelper {
	
	public Users checkCredentials(String username, String password) {
		
		Users checkMe = new Users();
		ImplementUsers user = new ImplementUsers();
		
		checkMe = user.getUserByUsername(username);
		
		if (checkMe != null) {
			if (checkMe.getPassword().equals(password)) {
				
				System.out.println("input of username = " + username + " and password = " + password);
				System.out.println("db username = " + checkMe.getUsername() +" db password = " + checkMe.getPassword());
				return checkMe;
			} else {
				return null;
			}
		} else {
			return null;
		}
		
	}
}
