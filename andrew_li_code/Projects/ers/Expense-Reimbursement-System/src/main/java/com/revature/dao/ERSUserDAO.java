package com.revature.dao;

import com.revature.models.ERSUser;

public interface ERSUserDAO {

	public abstract void makeUser(String firstName, String lastName, String username, String password, String email);
	public abstract ERSUser getERSUserByUsername(String username);
	public abstract ERSUser getERSUserById(int id);
	public abstract ERSUser getERSUserByEmail(String email);
	public abstract ERSUser getERSUserByNameAndPassword(String username, String password);
}
