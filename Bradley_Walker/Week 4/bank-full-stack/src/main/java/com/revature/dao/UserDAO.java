package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserDAO {
	
	User addUser(User u);
	User getUserById(int userId);
	User getUserByUsername(String username);
	User getUserByEmailAddress(String emailAddress);
	ArrayList<User> getAllUsers();
	User updateUser(int userId, User u);

}
