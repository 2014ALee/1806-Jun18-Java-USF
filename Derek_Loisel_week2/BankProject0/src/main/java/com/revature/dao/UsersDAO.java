package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.User;

public interface UsersDAO {

	
	public ArrayList<User> getAllUsers();
	
	public User getUserByUsername(User newUser);
	
	public int getUserIDByUsername(String username);
	
	public User addUser(User newUser);
	
}
