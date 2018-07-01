package com.revature.models;

import java.util.ArrayList;

import com.revature.dao.UsersDAO;
import com.revature.dao.UsersDAOImpl;

public class Validate {

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
	
//	public static boolean emailAvailable(User user) {
//		
//		//deserialize Users list of emails to compare with to make sure email is unique
//		return false;
//	}
	
	public static boolean credentialsValid(String username, String password, User user) {

		Pages.user = Serialize.deSerializeUser(username, user);
		
		if (Pages.user != null) {

			if (username.equals(Pages.user.getUsername()) & password.equals(Pages.user.getPassword())) {
				return true;
			}
		}

		return false;
	}

}
