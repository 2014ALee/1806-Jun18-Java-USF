package com.revature.models;

import java.util.ArrayList;

import com.revature.dao.UsersDAO;
import com.revature.dao.UsersDAOImpl;

public class Validation {

	// check if the username is available by comparing the user input to the serialized file names
	public static boolean usernameAndEmailAvailable(User u) {

		//call the getAllUsers() method from the usersDAO to get an arraylist of all the user objects from the database
		UsersDAO usersDAO = new UsersDAOImpl();
		ArrayList<User> usersList = usersDAO.getAllUsers();

		//check if the users input matches any of the usernames or emails from the users list, return false if it ever does
		for (User user : usersList) {

			if (u.getUsername().equals(user.getUsername())){
				return false;
			}

			if (u.getEmail().equals(user.getEmail())) {
				return false;
			}
		}
		return true;
	}
 
	public static boolean credentialsValid(String username, String password) {

		//call the getAllUsers() method from the usersDAO to get an arraylist of all the user objects from the database
		UsersDAO usersDAO = new UsersDAOImpl();
		ArrayList<User> usersList = usersDAO.getAllUsers();
		
		//create user object to hold the users input for username and password
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		
		//check if the users input matches any of the username/password combinations from the database
		for (User user : usersList) {
			//check for matching username
			if (u.getUsername().equals(user.getUsername())){

				//check for matching password after username matched
				if (u.getPassword().equals(user.getPassword())) {

					//return true if both the username and password matched
					return true;
				}
			}
		}
		//return false if the username and password never matched
		return false;
	}
	
}
