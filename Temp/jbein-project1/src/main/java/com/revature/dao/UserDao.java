package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserDao {
	ArrayList<User> getAllUsers();
	User GetUser(User u);
	public User getUsersById(int id);
	User AddUser(User newUser);
	User getUserByUsername(User newUser);
	User getUserByEmail(User newUser);
	User addUser(User newUser);
	User updateUser(User u);

}
