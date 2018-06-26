package com.revature.models;

import java.io.File;

public class Validate {


	public static boolean credentialsValid(String username, String password, User user) {

		user = Serialize.deSerializeUser(username, user);

		if (user != null) {

			if (username.equals(user.getUsername()) & password.equals(user.getPassword())) {
				return true;
			}
		}

		return false;
	}
	
	public static boolean usernameAvailable(User user) {

		String fileName = user.getUsername() + ".ser";
		File file = new File(fileName);

		if (file.exists()) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean validateUserInput(String userInput) {

		boolean validated = false;



		return validated;
	}
}
