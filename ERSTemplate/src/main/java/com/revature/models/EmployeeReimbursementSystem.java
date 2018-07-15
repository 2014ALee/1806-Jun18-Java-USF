package com.revature.models;

import com.revature.DAO.ReimbDAOImpl;
import com.revature.DAO.UserDAO;
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
	
	public User logIn(String userName, String password) {
		// we need to get user
		//we have front end forms that ask for the information
		//if we are succesful, we send them to the logged in menu
		
		//sample vars

		User newUser = new User();	
		newUser.setUserName(userName);
		newUser.setPassword(password);
		
		User loggedInUser = userDAO.getUser(newUser);
		
		return loggedInUser;
		
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
	
	public boolean userInDatabase(String userName, String password) {
	
		boolean validLogin = userDAO.validLogin(userName, password);
		
		
		return validLogin;
	}

	@Override
	public void loggedInMenuEmployee() {

		
		
		
	}
	
}
