package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.ERSUser;

public interface ERSUsersDAO {

	public ERSUser logInUser(String userNameOrEmail, String passWord);
	
	public boolean userExist(String userNameOrEmail);	
	
	public String[] createUser(ERSUser newUser);		
				
	public boolean deleteUser(ERSUser deleteUser);		
	
	public boolean updateUser(ERSUser updatedUser);
	
	public ArrayList<ERSUser> getAllUsers();

	public ArrayList<ERSUser> getAllUsersByRole(int roleId);
	
	public int getUserId(String userNameOrEmail);
}
