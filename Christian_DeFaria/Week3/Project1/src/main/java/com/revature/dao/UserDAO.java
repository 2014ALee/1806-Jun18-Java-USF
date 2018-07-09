package com.revature.dao;

import com.revature.models.Users;

public interface UserDAO {

	public Users getUser(int id);
	public Users getUserByName(String username);
	public Users getUserByEmail(String email);
	
	public Users addUser(Users u);
	
}
