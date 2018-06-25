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

		System.out.println("+---------Main Menu---------+");

		System.out.println("[1] - Login");
		System.out.println("[2] - Register");
		System.out.print("Selection: ");
		try {
			userInput = br.readLine();
			System.out.println();
			switch(userInput) {
			case "1":
				System.out.println("Navigating to Login menu.");
				login();
				break;
			case "2":
				System.out.println("Navigating to Registration menu.");
				register();
				break;
			default:
				System.out.println("Invalid selection. Please try again.\n");
				mainMenu();
			}
		} catch (IOException e) {
			System.out.println("[Log] - Error while reading from console.");
			e.printStackTrace();
		}
	}
	
	private static void register() {
		
		String firstName, lastName, username, password, email;
		
		System.out.println("+---------Registration---------+");
		try {
			System.out.print("First name: ");
			firstName = br.readLine();

			System.out.print("Last name: ");
			lastName = br.readLine();

			System.out.print("Username: ");
			username = br.readLine();

			System.out.print("Password: ");
			password = br.readLine();

			System.out.print("Email: ");
			email = br.readLine();
			
			user = new User(firstName, lastName, username, password, email);
			System.out.println("Checking username availability...");
			
			if (usernameAvailable(user)) {
				System.out.println("Username available!");
				System.out.println("Creating new user, " + user.getUsername());
				serializeUser(user);
			}else {
				System.out.println("Username is not available. Please try again.");
				register();
			}
			
			
			
		} catch (IOException e) {
			System.out.println("[Log] - Error while reading from console.");
			e.printStackTrace();
		}
		
	}
	
	private static void serializeUser(User u) {
		
		String fileName = u.getUsername() + ".ser";
		/*
		 * Try-with-Resoures-Block
		 */
		
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);){
			/*
			 * Write to specified object to the output steam. The class of the object, to signature of 
			 * the class, and the values of the non-transient and non-static fields of the class and all of its
			 * supertypes are written.
			 */
			oos.writeObject(u);
			
		} catch (FileNotFoundException e) {
			System.out.println("[Log] - Error while accessing the file.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[Log] - Error while writing to the file.");
			e.printStackTrace();
		}
	}
	
	private static boolean usernameAvailable(User u) {
		String fileName = u.getUsername() + ".ser";
		File file = new File(fileName);
		
		if(file.exists())
			return false;
		else 
			return true;
	}
	
	private static void login() {
		String username, password;
		
		try {
			System.out.print("Username: ");
			username = br.readLine();

			System.out.print("Password: ");
			password = br.readLine();
			
			if(credentialsValid(username, password)) {
				System.out.println("Login successful!");
				return;
			}else {
				System.out.println("Login unsuccessful.");
				mainMenu();
			}
	
		} catch (IOException e) {
			System.out.println("[Log] - Error while reading from console.");
			e.printStackTrace();
		}
	}
	
	private static boolean credentialsValid(String username, String password) {
		String fileName = username + ".ser";
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));){
			
			user = (User) ois.readObject();
			
			if(user != null) {
				if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
					return true;
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("[Log] - Error while accessing the file.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[Log] - Error while reading the file.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("[Log] - Error while deserializing the object.");
			e.printStackTrace();
		}
		
		return false;
		
	}
}
