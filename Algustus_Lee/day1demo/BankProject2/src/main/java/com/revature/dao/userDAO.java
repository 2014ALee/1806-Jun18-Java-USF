package com.revature.dao;

import com.revature.models.userData;

public interface userDAO {
	public userData createUser(userData user);
	public boolean checkForUser(userData user);
	public boolean checkForEmails(userData user);
	public userData setUser(String username, userData user);
	public double withdraw(userData theUser, double withdrawAmount);
	public double deposit(userData theUser, double depositAmount);

}
