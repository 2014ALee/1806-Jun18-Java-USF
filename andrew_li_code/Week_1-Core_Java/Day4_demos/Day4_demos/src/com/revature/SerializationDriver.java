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
	
	public static void mainMenu() {
		String userInput;
		System.out.println("+++++++++++++++++++MAIN MENU+++++++++++++++++++");
		System.out.println("[1] - Login");
		System.out.println("[2] - Register");
		System.out.print("Selection: ");
		
		try {
			userInput = br.readLine();
			System.out.print("");
			switch (userInput) {
				case "1":
					System.out.println("Navigating to Login Menu...");
					login();
					break;
				case "2":
					System.out.println("Navigating to Registration Menu...");
					register();
					break;
				default:
					System.out.println("Invalid selection, please try again");
			}
			
				
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console");
			e.printStackTrace();
		}
	}
	
	private static void register() {
		
		
		String firstName, lastName, username, password, email;
		System.out.println("\n+++++++++++++++++++REGISTRATION+++++++++++++++++++");
		
		try {
			System.out.print("First Name: ");
			firstName = br.readLine();
			System.out.println("");

			System.out.print("Last Name: ");
			lastName = br.readLine();
			System.out.println("");

			System.out.print("Username: ");
			username = br.readLine();
			System.out.println("");

			System.out.print("Password: ");
			password = br.readLine();
			System.out.println("");

			System.out.print("Email: ");
			email = br.readLine();
			System.out.println("");
			
			System.out.println("Name: " + firstName + " " + lastName);
			System.out.println("Username: " + username);
			System.out.println("Email: " + email);
			User user = new User(firstName, lastName, username, password, email);
			if (usernameAvailable(user)) {
				serializeUser(user);
			} else {
				System.out.println("Username has been taken!!");
				register();
				return;
			}
			
				
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console");
			e.printStackTrace();
		}
		
	}
	
	private static void serializeUser(User u) {
		String fileName = u.getUsername() + ".ser";
		
		/*
		 * Try-with-Resources block
		 */
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			/*
			 * Write the specified object to the ObjectOutputStream. The class of he object,
			 * the signature of the class, and the values of the non-transient and non-static
			 * fields of the class and all of its super-types are written.
			 */
			oos.writeObject(u);
		} catch (FileNotFoundException e) {
			System.out.println("Error occured while accessing the file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean usernameAvailable(User user) {
		String fileName = user.getUsername() + ".ser";
		File file = new File(fileName);
		return !file.exists();
	}
	
	private static void login() {
		String username, password;

		try {
			System.out.print("Username: ");
			username = br.readLine();
			System.out.println("");

			System.out.print("Password: ");
			password = br.readLine();
			System.out.println("");
			
			if (usernameAvailable(new User(username, username, username, username, username))) {
				System.out.println("Username does not exist!!");
				login();
				return;
			}
			if (credentialsValid(username, password)) {
				
			} else {
				System.out.println("Password is incorrect!");
				login();
				return;
			}
			
				
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console");
			e.printStackTrace();
		}
	}
	
	private static boolean credentialsValid(String username, String password) {
		
		String fileName = username + ".ser";
		User user = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			user = (User) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("[LOG] - An Error occured while deserializing the object");
			e.printStackTrace();
		} catch (ClassCastException e) {
			System.out.println("[LOG] - An Error occured while attempting to fetch a user");
		}
		
		if (user.getPassword().equals(password)) {
			return true;
		}
		
		return false;
	}
}
