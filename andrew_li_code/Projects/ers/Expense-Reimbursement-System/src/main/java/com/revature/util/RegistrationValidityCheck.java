package com.revature.util;

public class RegistrationValidityCheck {
	public static String check(String username, String password, String firstName, String lastName, String email) {
		if (!BasicHelpers.isAlphaNumeric(username)) {
			return "error:Only letters and numbers are allowed in your username.";
		}
		if (!email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
			return "error:Invalid email address!";
		}
		if (username.length() < 3) {
			return "error:Username must have at least three characters.";
		}
		if (password.length() < 6) {
			return "error:Password must have at least six characters.";
		}
		if (firstName.length() < 2) {
			return "error:First name must have at least two characters.";
		}
		if (lastName.length() < 2) {
			return "error:Last name must have at least two characters.";
		}
		if (username.length() > 50) {
			return "error:No more than 50 characters are allowed in your username.";
		}
		if (firstName.length() > 100) {
			return "error:No more than 100 characters are allowed in your name.";
		}
		if (lastName.length() > 100) {
			return "error:No more than 100 characters allowed in your last name.";
		}
		if (email.length() > 150) {
			return "error:No more than 150 characters allowed in your email.";
		}
		return "";
	}
}
