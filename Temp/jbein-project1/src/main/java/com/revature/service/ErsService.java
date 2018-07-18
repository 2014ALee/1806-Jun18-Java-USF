package com.revature.service;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.dao.UserDao;
import com.revature.models.User;

public class ErsService {
	static UserDao userDao = new UserDaoImpl();
	static ReimbursementDao reimbursementDao = new ReimbursementDaoImpl();
	

	/**
	 * 
	 * @return User; null if new user creation is unsuccessful, 
	 * 				 newly created user (with id) if new user creation is successful
	 */
	public User createNewUser(User user) {

		User newUser = null;

		boolean emailAddressAvailable = isEmailAvailable(user.getUser_email());
		boolean usernameAvailable = isUsernameAvailable(user.getErs_username());

		if (emailAddressAvailable && usernameAvailable) {
			newUser = userDao.addUser(user);
		}

		return newUser;

	}

	
	public User getUserByUsername(User u) {

		User soughtUser = userDao.getUserByUsername(u);
		return soughtUser;

	}

	
	public User getUserByEmailAddress(User u) {

		User soughtUser = userDao.getUserByEmail(u);
		return soughtUser;
		
	}

	
	public User updateUser(User userForUpdate) {

		User updatedUser = userDao.updateUser(userForUpdate);
		return updatedUser;

	}


	public User loginUser(User u) {

		User loggedInUser = null;

		// stores returned User object from getUserByUsername() based on given username; ignores case
		User currentUser = userDao.getUserByUsername(u);
		String usernameMatch = currentUser.getErs_username();
		if (currentUser.getErs_username() != null) {

			if (currentUser.getErs_password().equals(u.getErs_password())) {
				loggedInUser = currentUser;
			}

			else {
				System.out.println("\nInvalid login credentials: password incorrect\nReturning to main menu.");
			}
		}

		else {
			System.out.println("\nNo records found for username: " + usernameMatch + "\nReturning to main menu...");
		}

		return loggedInUser;
	}

	
	public void printAllUsers() {

		ArrayList<User> users = userDao.getAllUsers();

		System.out.println();
		users.forEach(user -> System.out.println(user));
		System.out.println();

	}


	public boolean isUsernameAvailable(String username) {

		ArrayList<User> users = userDao.getAllUsers();

		for (User user : users) {
			if (user.getErs_username().equalsIgnoreCase(username)) {
				return false;
			}
		}

		return true;

	}

	
	public boolean isEmailAvailable(String emailAddress) {

		ArrayList<User> users = userDao.getAllUsers();

		for (User user : users) {
			if (user.getUser_email().equalsIgnoreCase(emailAddress)) {
				return false;
			}
		}

		return true;

	}
	
	
public boolean createReimb(Reimbursement newReim, User user) {
		
		Reimbursement temp = newReim;
		temp.setReimb_author(user.getErs_users_id());
		boolean created = reimbursementDao.addReimbursement(newReim);
		
		return created;
	}

public ArrayList<Reimbursement> getReimbursmentsByAuthor(int authorId) {
	System.out.println("made it here");
	return reimbursementDao.getReimbursementsByAuthor(authorId);

}

}
