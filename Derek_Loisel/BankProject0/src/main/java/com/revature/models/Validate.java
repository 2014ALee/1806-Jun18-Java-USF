package com.revature.models;

import java.io.File;

public class Validate {

	// check if the username is available by comparing the user input to the serialized file names
	public static boolean usernameAvailable(User user) {

		String fileName = user.getUsername() + ".ser";
		File file = new File(fileName);

		if (file.exists()) {
			return false;
		} else {
			return true;
		}
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
