package com.revature.Dao;

import com.revature.model.User;

public interface UserDAO {
	
	//update
	
	public User AddUser(User a);
	public boolean updateUser(User updatedUser);
	
	//insert
	public User createUser(User b);
	
	//delete
	public User GetUser(User a);
	
	
	

}
