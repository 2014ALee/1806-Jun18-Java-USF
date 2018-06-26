package com.revature.models;

import java.io.BufferedReader;
import java.io.IOException;

public class UserActions {

	public static void deposit(BufferedReader br, User user) {

	}

	public static void withdraw(BufferedReader br, User user) {

	}

	public static void viewBalance(BufferedReader br, User user) {

	}

	public static void logout(BufferedReader br, User user) {

		String userInput;

		System.out.println("\n---------------LOGOUT--------------");
		System.out.println("Are you sure you want to log out?");
		System.out.println("[1] - Yes");
		System.out.println("[2] - No");
		System.out.print("Selection: ");
		try {
			// get user input from logout
			userInput = br.readLine();

			switch (userInput) {
			case "1":
				// re serialization here before logout to store the user obect back in the file			
				serializeUser(user);

				mainMenu();
				break;
			case "2":
				homePage();
				break;
			default:
				System.out.println("Invalid selection, please try again!\n");
				// back to logout
				logout();
			}

		} catch (IOException ioe) {
			System.out.println("An error occured while trying to log out");
			// e.printStackTrace();
			homePage();
		}
	}

}
}
