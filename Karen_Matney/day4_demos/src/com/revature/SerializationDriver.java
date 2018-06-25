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
		System.out.println("+--------------MAIN MENU--------------+");

		System.out.println("[1] - Login");
		System.out.println("[2] - Register");
		System.out.println("Selection: ");

		try {
			switch(br.readLine()) {
			case "1":
				System.out.println("Navigating ot Login Menu...");
				login();
				break;
			case "2":
				System.out.println("Navigating to Reistration Menu...");
				register();
				break;
			default:
				System.out.println("Invalid selection, please try again");
				mainMenu();
				break;
			}
		} catch (IOException ioe) {
			System.out.println("[LOG] - Error while reading from console");
			ioe.printStackTrace();
		}
	}

	public static void register() {
		String firstName, lastName, username, password, email;

		System.out.println("\n+--------------Registration---------------+");

		try {
			System.out.println("First name: ");
			firstName = br.readLine();

			System.out.println("last name: ");
			lastName = br.readLine();

			System.out.println("username: ");
			username = br.readLine();

			System.out.println("Password: ");
			password = br.readLine();

			System.out.println("E-mail: ");
			email = br.readLine();

			user = new User(firstName, lastName, username, password, email);
			System.out.println("Checking username availabilty...");
			
			if(usernameAvailable(user)) {
				System.out.println("Username available!");
				System.out.println("Creating new user, " + user.getUsername() + ".../n");
				serializeUser(user);
			} else {
				System.out.println("Username is not available. Please try again...");
				register();
			}
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console");
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

	private static void serializeUser(User u) {
		String fileName = u.getUsername() + ".ser";
		/*
		 * Try-with-Resources Block
		 */
		
		try (FileOutputStream fos = new FileOutputStream(fileName); 
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			/*
			 * Write the specified object to the ObjectOutputStream. The class of the object, the signature of
			 * the class, and the values of the non-transient and non-static fields of the class and all of its
			 * supertypes are written.
			 */
			oos.writeObject(u);
		} catch (FileNotFoundException e) {
			System.out.println("[LOG] - An error occurred while accesssing the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occurred while writing the file");
			e.printStackTrace();
		}
	}
	
	private static void login() {
		String username, password;
		
		try {
			System.out.println("Username: ");
			username = br.readLine();
			
			System.out.println("Password: ");
			password = br.readLine();
			
			if(credentialsValid(username,password)) {
				System.out.println("Login successful!");
				return;
			} else {
				System.out.println("Login unsuccessful!\n");
				mainMenu();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean credentialsValid(String username, String password) {
		String fileName = username + ".ser";
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			user = (User) ois.readObject(); // In the future, check to make sure
			
			if(user != null) {
				if(username.equals(user.getUsername()) & password.equals(user.getPassword())) {
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			//System.out.println("[LOG] - An error occurred while accesssing the file");
			//e.printStackTrace();
			System.out.println("Login Credentials incorrect. Sending back to main menu.");
			mainMenu();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occurred while writing the file");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("[LOG] - An error occured while deserializing an object");
			e.printStackTrace();
		}
		
		return false;
	}
}