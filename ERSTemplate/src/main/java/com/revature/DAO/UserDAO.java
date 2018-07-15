package com.revature.DAO;

import com.revature.models.User;

public interface UserDAO {
		
	//use this when registering
	public boolean registerUser(User newUser);
	
	//used for logging in
	public User getUser(User newUser);

	//check if registration given a user is possible, or if name is taken
	public boolean validRegistration(User newUser);
	
	//check if a user exists
public boolean validLogin(String userName, String password);	


//message if taken., message if improper format
public boolean validUserName(String userName);

public boolean validEmail(String email);

}
