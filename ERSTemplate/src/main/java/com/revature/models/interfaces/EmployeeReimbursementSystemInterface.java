package com.revature.models.interfaces;

import com.revature.models.User;

public interface EmployeeReimbursementSystemInterface {

	public void registerUser(User user);
	public User logIn(String userName, String password);
	public void mainMenu();
	public void exitProgram();
	
	//we check role for this
	public void loggedInMenuEmployee();
	public void loggedInMenuManager();
	
}
