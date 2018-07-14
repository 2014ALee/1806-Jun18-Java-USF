package com.revature.models.interfaces;

public interface EmployeeReimbursementSystemInterface {

	public void registerUser();
	public void logIn();
	public void mainMenu();
	public void exitProgram();
	
	//we check role for this
	public void loggedInMenuEmployee();
	public void loggedInMenuManager();
	
}
