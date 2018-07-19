package com.revature.models;

import java.util.ArrayList;

import com.revature.DAO.ReimbDAOImpl;
import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDAOImpl;
import com.revature.models.interfaces.EmployeeReimbursementSystemInterface;

public class EmployeeReimbursementSystem implements EmployeeReimbursementSystemInterface {

	UserDAOImpl userDAO = new UserDAOImpl();
	ReimbDAOImpl reimbDAO = new ReimbDAOImpl();

	//there will be a menu with options
	//login, register

	public void registerUser(User newUser) {

		userDAO.registerUser(newUser);
	}

	public boolean registrationValid(User user) {

		return userDAO.validRegistration(user);
	}

	public User getReimbursements(User user) {
	 ArrayList<Reimbursement> reimbList = reimbDAO.getReimbursements(user);
		user.setReimbList(reimbList);
		return user;
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


	public Reimbursement addReimbursement(String type, String description, double amount, int userID) {
		Reimbursement newReimb = new Reimbursement();
		newReimb.setDescription(description);
		newReimb.setReimbursementAmount(amount);
		newReimb.setAuthorID(userID);
		newReimb.setTypeName(type);
		
		newReimb = reimbDAO.addReimbursement(newReimb, userID);
		
		return newReimb;
	}
	
	public ArrayList<Reimbursement> getAllReimbursements(){
		
		ArrayList<Reimbursement> allReimbs = reimbDAO.getAllReimbursements();
		
		return allReimbs;
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

	public boolean checkUserName(String userName) {
		boolean isValid = userDAO.validUserName(userName);
		return isValid;
	}

	public boolean checkEmail(String email) {
		boolean isValid = userDAO.validEmail(email);
		return isValid;
	}


	@Override
	public void loggedInMenuEmployee() {




	}


}
