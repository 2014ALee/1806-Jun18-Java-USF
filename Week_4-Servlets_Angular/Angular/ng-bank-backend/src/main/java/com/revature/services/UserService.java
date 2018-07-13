package com.revature.services;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;

public class UserService {
	
	public static UserDAO userDao = new UserDAOImpl();

	public User createUser(User user) {
		
		if(isEmailAvailable(user.getEmail()) && isUsernameAvailable(user.getUsername())) {
			return userDao.addUser(user);
		}
		
		return null;
	}
	
	public User getUserById(int userId) {
		return userDao.getUserById(userId);
	}
	
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}
	
	public User getUserByEmailAddress(String email) {
		return userDao.getUserByEmailAddress(email);
	}
	
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}
	
	public User loginUser(User user) {
		
		System.out.println(user);
		User usernameMatch = userDao.getUserByUsername(user.getUsername());
		System.out.println(usernameMatch);
		
		if(user.getUsername() != null) {
			if(usernameMatch.getPassword().equals(user.getPassword())) {
				return usernameMatch;
			}
		}
		
		return null;
	}
	
	public boolean isEmailAvailable(String email) {
		
		for(User user : userDao.getAllUsers()) {
			if(user.getEmail().equalsIgnoreCase(email)) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isUsernameAvailable(String username) {
		
		for(User user : userDao.getAllUsers()) {
			if(user.getUsername().equalsIgnoreCase(username)) {
				return false;
			}
		}
		
		return true;
		
	}
}
