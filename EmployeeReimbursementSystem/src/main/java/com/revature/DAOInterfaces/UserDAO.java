package com.revature.DAOInterfaces;

import com.revature.models.User;

public interface UserDAO {
		
	//use this when registering
	public boolean registerUser(User newUser);
	
	//used for logging in
	public User getUser(String userName);

	//check if registration given a user is possible, or if name is taken
	public boolean validRegistrationCredentials(User newUser);
	
	//check if a user exists
	public boolean userExists(String userName, String password);
	
}
