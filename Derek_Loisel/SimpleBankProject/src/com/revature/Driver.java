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

import com.revature.models.User;

public class Driver {

	//create a User object to store user input
	private static User user = null;
	//create a BufferedReader to read user input
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		
		mainMenu();

	}

	private static void mainMenu() {

		//string to store user input
		String userInput;

		System.out.println("+--------------MAIN MENU--------------+");

		System.out.println("[1] - Login");
		System.out.println("[2] - Register");
		System.out.print("Selection: ");

		try {
			//get user input from main menu
			userInput = br.readLine();

			switch(userInput) {
			case "1":
				login();
				break;
			case "2":
				register();
				break;
			default:
				System.out.println("Invalid selection, please try again!\n");
				//back to main menu
				mainMenu();
			}

		} catch (IOException ioe) {
			//System.out.println("[LOG] - Error while reading from console");
			//e.printStackTrace();
			mainMenu();
		}

	}
	
	private static void register() {
		
		//Strings to store user input for User object
		String firstName, lastName, username, password, email;
		
		System.out.println("\n+--------------REGISTRATION--------------+");		
		
		try {
			
			//get user input to make User object
			System.out.print("First name: ");
			firstName = br.readLine();
			
			System.out.print("Last name: ");
			lastName = br.readLine();
			
			System.out.print("Username: ");
			username = br.readLine();
			
			System.out.print("Password: ");
			password = br.readLine();
			
			System.out.print("Email Address: ");
			email = br.readLine();
			
			//create new User object
			user = new User(firstName, lastName, username, password, email);

			//check username availability
			if(usernameAvailable(user)) {
				//username available
				//create new user
				serializeUser(user);
			} else {
				System.out.println("Username is not available. Please try again...");
				register();
			}
					
		} catch (IOException ioe) {
			//System.out.println("[LOG] - Error while reading from console");
			//e.printStackTrace();
			mainMenu();
		}
				
	}
	
	//check if the username is available by comparing the user input to the serialized file names
		private static boolean usernameAvailable(User u) {
			
			String fileName = u.getUsername() + ".ser";
			File file = new File(fileName);
			
			if(file.exists()) {
				return false;
			} else {
				return true;
			}
		}
		
	//store the User object into the text file if they're registering with a valid username
	private static void serializeUser(User u) {
		
		//create a string to name the users file according to username
		String fileName = u.getUsername() + ".ser";
		
		//try with resources to autoclose after the try/catch
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
						
			//Write the specified object to the ObjectOutputStream.			
			oos.writeObject(u);
				
			
			//***call  home page function here
			
		} catch (FileNotFoundException fnfe) {
			//System.out.println("[LOG] - An error occurred while accessing the file");
			//e.printStackTrace();
			mainMenu();
		} catch (IOException ioe) {
			//System.out.println("[LOG] - An error occurred while writing the file");
			//e.printStackTrace();
			mainMenu();
		}
	}
	
	private static void login() {
		
		String username, password;
		
		System.out.println("\n+--------------LOGIN--------------+");
		
		try {
			
			System.out.print("Username: ");
			username = br.readLine();
			
			System.out.print("Password: ");
			password = br.readLine();
			
			if(credentialsValid(username, password)) {
				//login successful
				
				//***call  home page function here
				
				return;
			} else {
				System.out.println("Login failed!\n");
				mainMenu();
			}
			
		} catch (IOException ioe) {
			//System.out.println("[LOG] - Error while reading from console");
			//e.printStackTrace();
			mainMenu();
		}
	}
	
	private static boolean credentialsValid(String username, String password) {
		
		String fileName = username + ".ser";
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			
			user = (User) ois.readObject();
			
			if(user != null) {
				
				if(username.equals(user.getUsername()) & password.equals(user.getPassword())) {
					return true;
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("[LOG] - An error occurred while accessing the file");
			//e.printStackTrace();
			mainMenu();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occurred while writing the file");
			//e.printStackTrace();
			mainMenu();
		} catch (ClassNotFoundException e) {
			System.out.println("[LOG] - An error occurred while deserializing the object");
			//e.printStackTrace();
			mainMenu();
		}
		
		return false;
	}

}
