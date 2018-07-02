package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserDAO {

	public boolean userExist(String userNameOrEmail);	
	// create an account - give option of creating checking or savings
	public boolean createUser(User newUser);		
				
	public boolean deleteUser(User deleteUser);	
	
	public User logInUser(String userName, String passWord);	
	
	public boolean updateUser(User updatedUser);
	
	public ArrayList<User> getAllUsers();
	
	public int getUserId(User myUser);
}
