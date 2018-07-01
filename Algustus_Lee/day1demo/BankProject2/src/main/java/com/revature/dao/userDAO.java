package com.revature.dao;

import com.revature.models.userData;

public interface userDAO {
	public userData createUser(userData user);
	public boolean checkForUser(userData user);
	public boolean checkForEmails(userData user);

}
