package com.revature.dao;

import com.revature.models.User;

public interface UserDAO {
	
	public User getUserById(User user);
	
	public User createUser(User user);

	public User getUserByUsername(String username);

}

