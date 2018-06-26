package com.revature;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.models.Pages;
import com.revature.models.Serialize;
import com.revature.models.User;
import com.revature.models.UserActions;
import com.revature.models.Validate;


public class BankDriver {

	public static void main(String[] args) {

		// create a BufferedReader to read user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// create a User object to serialize, deserialize, and manipulate user data
		User user = new User();

		//variable to exit app
		boolean exitApp = false;

		//loop to start back at the main menu anytime
		while(!exitApp){

			///////////////////////////////////
			//get user input from the main menu
			String userInput = Pages.mainMenu(br);

			switch (userInput) {
			//case 1 when user selected login
			case "1":
				do {
					//set user object info from login page
					user = Pages.loginPage(br, user);
					//go to home page if login input was valid
				}while(!user.isInputValid());				
				break;

				//case 2 when user selected register
			case "2":
				do {
					//set user object info from register page
					user = Pages.registerPage(br, user);

					//serialize the new user if input was valid
					if (user.isInputValid()) {
						Serialize.serializeUser(user);
					}				
				}while(!user.isInputValid());
				//back to main menu after succesful registration
				continue;

				//case 3 when user selected exit
			case "3":
				//exit app
				System.exit(0);

			default:
				System.out.println("Invalid selection, please try again!\n");
				user.setInputValid(false);
				// back to main menu	
				continue;
			}

			//loop to start back at the home page at any time
			boolean logout = false;
			while(!logout) {

				///////////////////////////////////
				//home page after successful login
				userInput = Pages.homePage(br, user);

				switch (userInput) {
				case "1":
					UserActions.deposit();
					break;
				case "2":
					UserActions.withdraw();
					break;
				case "3":
					UserActions.viewBalance();
					break;
				case "4":
					UserActions.logout();
					break;
				default:
					System.out.println("Invalid selection, please try again!\n");
					// back to home page
					continue;

				}

			}

			//back to main menu unless exit was selected
		}



	}


}
