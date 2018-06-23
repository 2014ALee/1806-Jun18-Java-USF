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
		
		System.out.println("+-------------------MAIN MENU----------------------+");
		System.out.println("[1] - Login");
		System.out.println("[2] - Register");
		System.out.print("Selection: ");
		
		try {
			userInput = br.readLine();
			
			switch(userInput) {
			case "1":
				System.out.println("Navigating to Login Menu...");
				login();
				break;
			case "2": 
				System.out.println("Navigating to Registration Menu...");
				register();
				break;
			default: 
				System.out.println("Invalid selection, please try again.");
			}
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console.");
			e.printStackTrace();
		}
		
	}
	
	private static void register() {
		
		String firstName, lastName, username, password, email;
		
		System.out.println("+-------------------MAIN MENU----------------------+");
		
		try {
			System.out.println("First name: ");
			firstName = br.readLine();
			
			System.out.println("Last name: ");
			lastName = br.readLine();
			
			System.out.println("Username: ");
			username = br.readLine();
			
			System.out.println("Password: ");
			password = br.readLine();
			
			System.out.println("Email: ");
			email = br.readLine();
			
			user = new User(firstName, lastName, username, password, email);
			System.out.println("Checking username availability...");
			
			if(usernameAvailable(user)) {
				System.out.println("Username avaiable!");
				System.out.println("Creating new user, " + user.getUsername() + "...\n");
				serializeUser(user);
			}else {
				System.out.println("Username is not available. Please try again...");
				register();
			}
			
			serializeUser(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void serializeUser(User u) {
		String fileName = u.getUsername() + ".ser";
		/*
		 * Try-with-Resources block
		 */
		try (FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);){
			
			/*
			 * Write the specified object to the ObjectOutputStream. the class of the object, the 
			 * signature of the class, and the values of the non-transient and
			 * non-static fields of the class and all of its supertypes are written.
			 */
			oos.writeObject(u);
			
		} catch (FileNotFoundException e) {
			System.out.println("[LOG] - An error occured while accessing the file");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occured while writing the file");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	private static boolean usernameAvailable(User u) {
		
		String fileName = u.getUsername() + ".ser";
		File file = new File(fileName);
		
		if(file.exists())
			return false;
		return true;
	}
	
	private static void login() {
		
		String username, password;
		System.out.println("+-------------------LOGIN----------------------+");
		//username thorws io file not found if given wrong user fix this logic.
		try {
			System.out.println("Username: ");
			username = br.readLine();
			System.out.println("Password: ");
			password = br.readLine();
			
			if(credentialsValid(username, password)) {
				System.out.println("Login successful!");
				return;
			}else {
				System.out.println("Login unsuccessful!\n");
				mainMenu();
			}
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static boolean credentialsValid(String username, String password) {
		
		String fileName = username + ".ser";
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			
			user = (User) ois.readObject();
			
			if(user != null)
				if(username.equals(user.getUsername()) & password.equals(user.getPassword()))
					return true;
			
		} catch (FileNotFoundException e) {
			System.out.println("[LOG] - An error occured while accessing the file");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occured while writing the file");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("[LOG] - An error occured while deserializing the object");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}
}
