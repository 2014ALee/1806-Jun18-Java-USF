package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserDAO {

	public ArrayList<User> getAllUsers();
	
	public User getUserByUsername(User newUser);
	
	public User addUser(User newUser);
}
