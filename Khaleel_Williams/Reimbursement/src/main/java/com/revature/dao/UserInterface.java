package com.revature.dao;

import com.revature.models.Users;

public interface UserInterface {

	public boolean addUser(Users newUser);
	public Users getUserByUsername(String username);
	public boolean removeUserByUsername(String username);
	//public boolean updateUserInfo(Users updateUser); - implement later
	
	
}
