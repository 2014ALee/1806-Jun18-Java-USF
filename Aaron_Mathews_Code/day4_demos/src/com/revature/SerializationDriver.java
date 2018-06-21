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

public class SerializationDriver {

	private static User user = null;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		mainMenu();
	}

	private static void mainMenu() {
		String userInput;
		System.out.println("-------------------Main Menu-------------------");

		System.out.println("[1] - Login\n[2] - Register");
		System.out.println("Selection: ");

		try {
			userInput = br.readLine();

			switch(userInput) {
			case "1":
				System.out.println("Navigating to Login menu.\n");
				login();
				break;
			case "2":
				System.out.println("Navigating to Registration menu.\n");
				register();
				break;
			default:
				System.out.println("Invalid input. Please try again.\n");
				mainMenu();
			}
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console.");
			e.printStackTrace();
		}
	}
	
	private static void register() {
		
		String firstName, lastName, username, password, email;
		
		System.out.println("\n-------------------Registration Menu-------------------");
		
		try {
			
			System.out.print("First Name: ");
			firstName = br.readLine();
			
			System.out.print("Last Name: ");
			lastName = br.readLine();
			
			System.out.print("Username: ");
			username = br.readLine();
		
			System.out.print("Password: ");
			password = br.readLine();
		
			System.out.print("Email: ");
			email = br.readLine();
			
			user = new User(firstName, lastName, username, password, email);
			System.out.println("Checking username availability");
			
			if (usernameAvailable(user) ) {
				System.out.println("Username available");
				System.out.println("Creating new user, '" + user.getUserName() + ".....\n");
				serializedUser(user);
			} else {
				System.out.println("Username not available.");
				register();
			}
//			System.out.println(user);
			
			
			
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console.");
			e.printStackTrace();
		}
	}
	
	private static void serializedUser(User user) {
		
		String fileName = user.getUserName() + ".ser";
		
		/*
		 * Try with resources block
		 */
		try (FileOutputStream fos = new FileOutputStream(fileName); 
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			
			/*
			 * Write the specified object to the ObjectOutputStream. The class of the object,
			 * the signature of the class, and the value of the non-transient and non-static fields
			 * of the class and all of its supertypes are written.
			 */
			oos.writeObject(user);
			
		} catch (FileNotFoundException e) {
			System.out.println("[LOG] - An error occurred while accessing the file.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occured while writing the file");
			e.printStackTrace();
		}
		
	}
	
	private static boolean usernameAvailable(User u) {
		
		String fileName = u.getUserName() + ".ser";
		File file = new File(fileName);
		
		if (file.exists()) {
			return false;
		} else {
			return true;
		}
	}
	
	private static void login() {
		
		String username, password;
		System.out.println("-------------------LOGIN-------------------");
		
		try {
			
			System.out.print("Username: ");
			username = br.readLine();
			
			System.out.println("Password: ");
			password = br.readLine();
			
			if(credentialsValid(username, password)) {
				System.out.println("Login successful.");
				return;
			} else {
				System.out.println("Login unsuccessful.");
				login();
			}
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console.");
			e.printStackTrace();
		}
	}
	
	private static boolean credentialsValid(String username, String password) {
		String fileName = username + ".ser";
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			
			user = (User) ois.readObject();
			
			if (user != null & user.getUserName().equals(username) & user.getPassword().equals(password)) {
				return true;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("[LOG] - An error occurred while accessing the file.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occured while reading the file");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("[LOG] - An error occured while deserializing object.");
			e.printStackTrace();
		}
		return false;
	}

}
