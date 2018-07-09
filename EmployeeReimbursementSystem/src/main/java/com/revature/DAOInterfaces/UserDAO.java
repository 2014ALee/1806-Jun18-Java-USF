package com.revature.DAOInterfaces;

import com.revature.models.User;

public interface UserDAO {
		
	//use this when registering
	public boolean registerUser(User newUser);
	
	//used for logging in
	public User getUser(String userName);
	
}
