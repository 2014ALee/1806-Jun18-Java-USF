package com.revature.services;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;

public class UserService {
	static UserDAO userDao = new UserDAOImpl();
	
	// TODO: change dao to get username, perform validation here
	public User validateUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		return userDao.validateUser(user);
	}
}
