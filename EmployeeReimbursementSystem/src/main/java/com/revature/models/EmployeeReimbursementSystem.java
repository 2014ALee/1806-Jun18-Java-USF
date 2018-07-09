package com.revature.models;

import java.util.Date;

import com.revature.models.interfaces.EmployeeReimbursementSystemInterface;

public class EmployeeReimbursementSystem implements EmployeeReimbursementSystemInterface {

	//there will be a menu with options
	//login, register
	
	public void registerUser() {
		// do our checks, see if we can do this
		//if so, add them to userbank
		
		mainMenu();
	}
	
	public void logIn() {
		// we need to get user
		//we have front end forms that ask for the information
		//if we are succesful, we send them to the logged in menu
		
		//sample vars
		String userName = "tomsteyaert";
		String password = "password";
		String firstName = "tom";
		String lastName = "steyaert";
		String email = "tom@bob.com";
		UserRole role = new UserRole();
		
		User newUser = new User(userName,password,firstName,lastName,email,role);		
		
		boolean inDatabase = userInDatabase(newUser);
		
	}

	public void mainMenu() {
		//nothing here yet
		
	}

	public void exitProgram() {
		System.exit(0);
		
	}

	public void loggedInMenuEmployee() {
		// we will display this to the user on the front end
		
	}

	public void loggedInMenuManager() {
		// we will display this to the user on the front end
		
	}	
	
	public boolean nameAndEmailAvailable() {
		
		return true;
	}
	
	public boolean userInDatabase(User newUser) {
		//both username and email must be in there for the same user
		//first check username
		//	if it exists, go to next step
		//	if match, then check email, if no match user already exists
		//	if no match for both of these, user doesn't yet exist
		
		
		//create connection, do our thing to check
		//we will use a procedure stored in the database
		
		return false;
	}
	
}
