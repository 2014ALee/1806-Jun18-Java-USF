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
		
		System.out.println("+--------------Main Menu--------------+");
		
		System.out.println("[1] - Login");
		System.out.println("[1] - Registration");
		System.out.print("Selection: ");
		
		try {
			userInput = br.readLine();
			
			switch(userInput) {
				case "1":
					System.out.println("Navigating to Login Menu...");
					login();
					break;
				case "2":
					System.out.println("Navigating to Registration Menu");
					register();
					break;
				default:
					System.out.println("Invalid Selection. Please try again.");
					mainMenu();
			}
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from file.");
			e.printStackTrace();
		}
	}
	
	private static void register() {
		String firstName, lastName, username, password, email;
		System.out.println("\n+--------------Registration--------------+");
		
		try {
			System.out.print("First Name: ");
			firstName = br.readLine();
			
			System.out.print("Last Name: ");
			lastName = br.readLine();
			
			System.out.print("User Name: ");
			username = br.readLine();
			
			System.out.print("Password: ");
			password = br.readLine();
			
			System.out.print("Email Address: ");
			email = br.readLine();
			
			user = new User(firstName,lastName, username, password, email);
			System.out.println("Checking User Name availabilty");
			
			if(usernameAvailable(user)) {
				System.out.println("Username available!");
				System.out.println("Creating new user, " + user.getUsername() + "...\n");
				serializeUser(user);
			} else {
				System.out.println("Username not available! Please try again.");
				register();
			}
			
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from file.");
			e.printStackTrace();
		}
		
	}

	private static void serializeUser(User u) {
		
		String fileName = u.getUsername() + ".ser";
		
		/*
		 * Try-with-resources block
		 */
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			
			/*
			 * Write the specified object to the specified ObjectOutputStream. The class of the object, the signature of
			 * the class, and the values of the non-transient and non-static fields of the class and all of its
			 * super types are written
			 */
			oos.writeObject(u);
			
		} catch (FileNotFoundException e) {
			System.out.println("[LOG] - An error occurred while accessing the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occurred while writing to the file");
			e.printStackTrace();
		}
		
	}
	
	private static boolean usernameAvailable(User u) {
		
		String fileName = u.getUsername() + ".ser";
		File file = new File(fileName);
		
		if(file.exists()) {
			return false;
		} else {
			return true;
		}
	}
	
	private static void login() {
		System.out.println("\n+--------------Login--------------+");
		String username, password;
		
		try {
			System.out.print("Username: ");
			username = br.readLine();
			
			System.out.print("Password: ");
			password = br.readLine();
			
			if(credentialsValid(username, password)) {
				System.out.println("Login Successful");
				return;
			} else {
				System.out.println("Login Failed");
				mainMenu();
			}
		} catch (IOException e) {
			System.out.println("[LOG] - Error reading from console");
			e.printStackTrace();
		}
	}

	private static boolean credentialsValid(String username, String password) {
		
		String fileName = username + ".ser";
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));) {
			
			user = (User) ois.readObject();
			
			if(user != null) {
				if(username.equals(user.getUsername()) & password.equals(user.getPassword())) {
					return true;
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("[LOG] - An error occurred while accessing the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occurred while writing to the file");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("[LOG] - An error occurred while deserializing an object");
			e.printStackTrace();
		}
		return false;
	}

}
