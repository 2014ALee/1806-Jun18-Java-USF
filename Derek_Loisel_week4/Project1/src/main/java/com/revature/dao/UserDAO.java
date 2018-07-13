package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserDAO {

	public ArrayList<User> getAllUsers();
	
	public User getUserByUsername(String username);
	
	public User getUserByUsernameCallable(String username);
	
	public User addUser(User newUser);
	
	
	
	
}
