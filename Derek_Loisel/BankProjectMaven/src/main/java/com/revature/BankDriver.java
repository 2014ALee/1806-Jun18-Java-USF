package com.revature;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.models.MainMenu;
import com.revature.models.User;

public class BankDriver {
	
	public static void main(String[] args) {

		// create a BufferedReader to read user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// create a String to hold user input
		String userInput;
				
		// create a User object to serialize, deserialize, and manipulate user data
		User user = null;
		
		//get user input from the main menu
		userInput = MainMenu.getUserInput(br);

		while(!validateUserInput(userInput)) {
			switch (userInput) {
			case "1":
				Login.getUserInput(br);
				break;
			case "2":
				register();
				break;
			case "3":
				System.exit(0);
			default:
				System.out.println("Invalid selection, please try again!\n");
				// back to main menu
				userInput = MainMenu.getUserInput(br);
			}
		}
	}
	
	private static boolean validateUserInput(String userInput) {
		
		boolean validated;
		
		return validated;
	}

}
