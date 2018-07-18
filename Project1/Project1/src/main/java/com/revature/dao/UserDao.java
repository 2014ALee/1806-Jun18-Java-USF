package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserDao {
	public ArrayList<User> getAllUsers();
	public User GetUser(User u);
	public User AddUser(User u);
	public User getUserByName(String username);
	public User getUserByEmail(String email);

}
