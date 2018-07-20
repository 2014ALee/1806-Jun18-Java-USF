package com.revature.dao;

import com.revature.models.ERSUser;

public interface ERSUserDAO {
	public abstract ERSUser getERSUserByUsername(String username);
	public abstract ERSUser getERSUserById(int id);
}
