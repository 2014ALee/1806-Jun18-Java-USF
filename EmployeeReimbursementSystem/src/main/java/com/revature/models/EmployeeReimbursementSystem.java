package com.revature.models;

import com.revature.DAO.ReimbDAOImpl;
import com.revature.DAO.UserDAOImpl;
import com.revature.models.interfaces.EmployeeReimbursementSystemInterface;

public class EmployeeReimbursementSystem implements EmployeeReimbursementSystemInterface {

	UserDAOImpl userDAO = new UserDAOImpl();
	ReimbDAOImpl reimbDAO = new ReimbDAOImpl();
	
	//there will be a menu with options
	//login, register
	
	public void registerUser() {
		// do our checks, see if we can do this
		//if so, add them to userbank
		//please provide x information
		User newUser = new User();
		if(userDAO.validRegistration(newUser)) {
			userDAO.registerUser(newUser);
			System.out.println("user registered successfully!");
			mainMenu();
		}
		
		
		mainMenu();
	}
	
	public void logIn() {
		// we need to get user
		//we have front end forms that ask for the information
		//if we are succesful, we send them to the logged in menu
		
		//sample vars
		String userName = "tomsteyaert";
		String password = "password";
		
		User newUser = new User();	
		newUser.setUserName(userName);
		newUser.setPassword(password);
		
		//if our login is succesful
	//	if(userDAO.validLogin(newUser)) {
		//	newUser = userDAO.getUser(newUser);
	//	}
		
	/*
	 * 
	 * if(newUser.roleName == "manager"){
	 * 	loggedInMenuManager(User newUser);
	 * } else if(newUser.roleName == "employee"){
	 *  loggedInMenuEmployee(User newUser);
	 * }
	 * 
	 * 
	 * 
	 */
		
		
		boolean inDatabase = userInDatabase(newUser);
		
	}
	

	public void mainMenu() {
		System.out.println("welcome to the ERS!");
		System.out.println("[1] for login");
		System.out.println("[2] for registration");
		//we do a system get here
		
		/*
		 * if (input == 1){
			logIn();
	}
	
	
	*/	
	}

	public void exitProgram() {
		System.exit(0);
		
	}

	public void loggedInMenuEmployee(User newUser) {
		newUser.setReimbList(reimbDAO.getReimbursements(newUser));
		
		// we will display this to the user on the front end
		
	}

	public void loggedInMenuManager() {
		// we will display this to the user on the front end
		//display options:
		//view all reimbs
		//add new one
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

	@Override
	public void loggedInMenuEmployee() {

		
		
		
	}
	
}
