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

		System.out.println("+---------------------------Main Menu------------------+");

		System.out.println("[1] - Login");
		System.out.println("[2] - Register");
		System.out.println("selection");

		try {
			userInput = br.readLine();

			switch(userInput) {
			case "1":
				System.out.println("Navigating to login menu..");
				login();
				break;
			case "2":
				System.out.println("Navigating to registration menu...");
				register();
				break;
			default:
				System.out.println("Invalid selection please try again");
				mainMenu();
			}

		}catch(Exception e) {
			System.out.println("Error while reading from console");
			e.printStackTrace();
		}
	}

	private static void register() {

		String firstName, lastName, username, password, email;

		System.out.println("+---------------------------Registration------------------+");

		try {
			System.out.println("first name: ");
			firstName = br.readLine();

			System.out.println("Last name: ");
			lastName = br.readLine();

			System.out.println("username: ");
			username = br.readLine();

			System.out.println("password: ");
			password = br.readLine();

			System.out.println("email: ");
			email = br.readLine();

			user = new User(firstName, lastName, username, password, email);
			System.out.println("Checking username availability...");

			if(usernameAvailable(user)) {
				System.out.println("Username is Available");
				System.out.println("Creating new user, " + user.getUsername() + "....\n");
				serializeUser(user);
			}
			else {
				System.out.println("username is not available. Please try again...");
				register();
			}	

		}catch(IOException e) {
			System.out.println("[Log] - Error while reading from console");
			e.printStackTrace();
		}
	}

	private static void serializeUser(User u) {
		String filename = u.getUsername() + ".ser";

		try(FileOutputStream fos = new FileOutputStream(filename);
				ObjectOutputStream oos = new ObjectOutputStream(fos);){
			// write the specified object to the output stream
			oos.writeObject(u);
		}
		catch(IOException e) {
			System.out.println("[Log] - Error while reading from console");
			e.printStackTrace();
		}
	}

	private static boolean usernameAvailable(User u) {
		String fileName = u.getUsername() + ".ser";
		File file = new File(fileName);

		if(file.exists()) {
			return false;
		}
		else {
			return true;
		}
	}

	private static void login() {
		String username, password = null;

		try {
			System.out.print("User name");
			username = br.readLine();

			System.out.print("Password");
			username = br.readLine();

			if(credentialsValid(username, password)) {
				System.out.println("Login successful!");
				return;
			}
			else {
				System.out.println("Login unsuccessful!\n");
				mainMenu();
			}

		}
		catch(IOException e) {
			System.out.println("[Log] - Error while reading from console");
			e.printStackTrace();
		}
	}

	private static boolean credentialsValid(String username, String password) {
		String fileName = username + ".ser";

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

			user = (User) ois.readObject();

			if(user != null) {
				if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
					return true;
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("[Log] - Error while reading from console");
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println("[Log] - Error while reading from console");
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			System.out.println("[Log] - Error while reading from console");
			e.printStackTrace();
		}
		return false;
	}	
}
