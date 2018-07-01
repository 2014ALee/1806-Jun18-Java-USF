package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.User;

public interface UsersDAO {

	
	public ArrayList<User> getAllUsers();
	
	public User addUser(User newUser);
}
