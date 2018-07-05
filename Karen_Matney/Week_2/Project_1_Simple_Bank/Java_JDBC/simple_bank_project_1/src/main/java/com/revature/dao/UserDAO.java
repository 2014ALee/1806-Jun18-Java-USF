package com.revature.dao;

import com.revature.models.User;

public interface UserDAO {
	public int usernameAvailable(User u);
	
	public User createUser(User u);
	
	public User validateUser(User u);
}