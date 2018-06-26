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
import com.revature.models.User;


public class BankDriver {

	public static void main(String[] args) {

		// create a BufferedReader to read user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// create a User object to serialize, deserialize, and manipulate user data
		User user = null;

		//bool to exit app
		boolean exitApp = false;

		//bool for invalid input
		boolean tryAgain = false;

		//loop to start back at the main menu or exit
		do {
			//get user input from the main menu
			String userInputStr = Pages.mainMenu(br);

			switch (userInputStr) {
			//user selected login
			case "1":

				do {
					user = Pages.login(br, user);
					//check if the user from login are valid
					if (credentialsValid(user.getUsername(), user.getPassword(), user)) {
						// login successful
						// go to home page after successful login					
						tryAgain = false;
						//break;					
					} else {
						System.out.println("Login failed!\n");
						tryAgain = true;
					}					
				}while(tryAgain);				
				break;

				//user selected register
			case "2":
				//loop to retry case if user input was invalid
				do {
					user = Pages.register(br, user);
					// check username availability
					if (usernameAvailable(user)) {
						// username available
						tryAgain = false;
						// create new user
						serializeUser(user);
						tryAgain = false;
						//break;
					} else {
						System.out.println("Username is not available. Please try again...");
						tryAgain = true;
					}	
				}while(tryAgain);
				break;

				//user selected exit
			case "3":
				exitApp = true;
				break;
				
			default:
				System.out.println("Invalid selection, please try again!\n");
				// back to main menu			
			}

			Pages.homePage(br, user);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			//back to main menu unless exit was selected
		}while(!exitApp);

		//exit app
		System.exit(0);

	}

	private static boolean usernameAvailable(User u) {

		String fileName = u.getUsername() + ".ser";
		File file = new File(fileName);

		if (file.exists()) {
			return false;
		} else {
			return true;
		}
	}

	// store the User object into the text file if they're registering with a valid username
	private static void serializeUser(User u) {

		// create a string to name the users file according to username
		String fileName = u.getUsername() + ".ser";

		// try with resources to autoclose after the try/catch
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			// Write the specified object to the ObjectOutputStream.
			oos.writeObject(u);

		} catch (FileNotFoundException fnfe) {
			// System.out.println("[LOG] - An error occurred while accessing the file");
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			// System.out.println("[LOG] - An error occurred while writing the file");
			ioe.printStackTrace();
		}
	}

	private static boolean credentialsValid(String username, String password, User user) {

		String fileName = username + ".ser";

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

			user = (User) ois.readObject();

			if (user != null) {

				if (username.equals(user.getUsername()) & password.equals(user.getPassword())) {
					return true;
				}
			}

		} catch (FileNotFoundException fnfe) {
			//System.out.println("Invalid login");
			fnfe.printStackTrace();

		} catch (IOException ioe) {
			//System.out.println("Invalid login");
			ioe.printStackTrace();

		} catch (ClassNotFoundException cnfe) {
			//System.out.println("Invalid login");
			cnfe.printStackTrace();

		}

		return false;
	}


	public static boolean validateUserInput(String userInput) {

		boolean validated = false;



		return validated;
	}

}
