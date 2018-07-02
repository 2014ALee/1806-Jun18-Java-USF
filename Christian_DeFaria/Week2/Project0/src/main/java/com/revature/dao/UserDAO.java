package com.revature.dao;

import com.revature.models.User;

public interface UserDAO {
	
	public boolean usernameExists(String username);
	public boolean emailExists(String email);
	
	public User addUser(User u);
	
	public User getUser(String username, String password);

}
