package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserDao {
	
	public void Login(String username, String pw);
	public User GetUser(User u);
	public User AddUser(User u);

}
