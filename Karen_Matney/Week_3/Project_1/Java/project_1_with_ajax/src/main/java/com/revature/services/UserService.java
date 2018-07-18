package com.revature.services;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;

public class UserService {
	static UserDAO userDao = new UserDAOImpl();
	
	public User validateUser(String username, String password) {
		System.out.println("[Log] UserService validating user");
		//TODO: Or by email, need to restrict username options first
		User user = userDao.getByUsername(username);
		
		if(user == null || !user.getPassword().equals(password)) {
			return null;
		} else {
			user.setPassword("*****");
			return user;
		}
	}
	
	public User addUser(String[] values) {
		for(String value : values) {
			System.out.println(value);
			if(value == "")
				return null;
		}
		
		// TODO: Add more verification of values (i.e. username available)
		User user = new User();
		
		user.setUsername(values[0]);
		user.setPassword(values[1]);
		user.setFirstName(values[2]);
		user.setLastName(values[3]);
		user.setEMail(values[4]);
		user.setUserRole("Employee");
		
		return userDao.addUser(user);
	}
	
	// TODO: Profile changes
}
