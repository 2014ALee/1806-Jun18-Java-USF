package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserDAO {

	public ArrayList<User> getAllUsers();
	
	public User getUserByUsername(User user);
	
	public User getUserByUsernameCallable(User user);
	
	public User addUser(User newUser);
	
	
	
	
}
