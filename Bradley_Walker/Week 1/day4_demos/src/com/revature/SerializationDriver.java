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
		String input = "";

		System.out.println("+------------------- MAIN MENU -------------------+");

		System.out.println("[1] - Login");
		System.out.println("[2] - Register");
		System.out.print("Selection: ");

		try {
			input = br.readLine();

			switch(input) {
			case "1":
				System.out.println("Navigating to Login Menu...");
				login();
				break;
			case "2":
				System.out.println("Navigating to Registration Menu...");
				register();
				break;
			default:
				System.out.println("Invalid selection, please try again.\n");
				mainMenu();
			}
		} catch (IOException e) {
			System.out.println("{LOG} - Error while reading from console");
			e.printStackTrace();
		}
	}
	
	private static void register() {
		String firstName, lastName, username, password, email;

		System.out.println("\n+------------------- REGISTER -------------------+");
		
		try {
			System.out.print("First Name: ");
			firstName = br.readLine();
			
			System.out.print("Last Name: ");
			lastName = br.readLine();
			
			System.out.print("Username: ");
			username = br.readLine();
			
			System.out.print("Password: ");
			password = br.readLine();
			
			System.out.print("Email Address: ");
			email = br.readLine();
			
			user = new User(firstName, lastName, username, password, email);
			System.out.println("\nChecking username availability...");
			
			if(usernameAvailable(user)) {
				System.out.println("Username available!");
				System.out.println("Creating new user, " + user.getUsername() + "...\n");
				serializeUser(user);
				mainMenu();
			} else {
				System.out.println("Username is not available. Please try again.");
				register();
			}
			
			
		} catch (IOException ioe) {
			System.out.println("{LOG} - Error while reading from console");
			ioe.printStackTrace();
		}
	}
	
	private static boolean usernameAvailable(User u) {
		String fileName = u.getUsername() + ".dat";
		File file = new File(fileName);
		return !file.exists();
	}

	private static void serializeUser(User u) {
		String fileName = u.getUsername() + ".dat";
		
		/*
		 * Try with resources block
		 */
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			
			/*
			 * Write the specified object to the oos. The class of the object, the
			 * signature of the class, and the values of the non-transient and
			 * non-static fields of the class and all of its supertypes are written
			 */
			oos.writeObject(u);
			
		} catch (FileNotFoundException e) {
			System.out.println("{LOG} = An error occurred while accessing the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("{LOG} = An error occurred while writing to the file");
			e.printStackTrace();
		}
	}

	private static void login() {
		String username, password;
		
		System.out.println("\n+------------------- LOGIN -------------------+");
		
		try {
			System.out.println("Enter username: ");
			username = br.readLine();
			
			System.out.println("Enter password: ");
			password = br.readLine();
			
			if(credentialsValid(username, password)) {
				System.out.println("Login successful");
				return;
			} else {
				System.out.println("Login failed\n");
				mainMenu();
			}
		} catch (IOException ioe) {
			System.out.println("{LOG} - Error while reading from console");
		}
	}

	private static boolean credentialsValid(String username, String password) {
		String fileName = username + ".dat";
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			
			user = (User) ois.readObject();
			if(user != null) {
				if(username.equals(user.getUsername()) & password.equals(user.getPassword()))
					return true;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("{LOG} = An error occurred while accessing the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("{LOG} = An error occurred while reading from the file");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("{LOG} - An error occured while deserializing the object");
			e.printStackTrace();
		}
		
		return false;
	}
}
