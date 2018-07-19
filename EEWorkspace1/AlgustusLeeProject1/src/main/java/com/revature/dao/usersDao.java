package com.revature.dao;

import com.revature.models.User;

public interface usersDao {
	User newUser(String un, String pw, String fn, String ln, String email);
	User newAdmin(String un, String pw, String fn, String ln, String email);
	void removeUser(User u);
	boolean login(String u, String p);
	boolean checkForUser(String username);
	User setUser(String username, User user);
	boolean checkForEmails(String email);
}
