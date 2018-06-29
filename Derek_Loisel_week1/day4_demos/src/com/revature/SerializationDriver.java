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
	private static BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));

	public static void main(String[] args) {

		mainMenu();

	}
	
	private static void mainMenu() {
		
		String userInput;

		System.out.println("+---------------------MAIN MENU------------------------+");
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
				System.out.println("Invalid Selection, Please Try Again...");
				mainMenu();
			}

		} catch (IOException ioe) {
			System.out.println("[LOG] - Error while reading from console");
			ioe.printStackTrace();
		}
		
	}
	
	private static void register() {
		
		String firstName, lastName, username, password, email;
		
		System.out.println("/n+---------------------REGISTRATION------------------------+");
		
		try {
			System.out.println("First Name: ");
			firstName = br.readLine();
			
			System.out.println("Last Name: ");
			lastName = br.readLine();
			
			System.out.println("Username: ");
			username = br.readLine();
			
			System.out.println("Password: ");
			password = br.readLine();
			
			System.out.println("Email: ");
			email = br.readLine();
			
			user = new User(firstName, lastName, username, password, email);
			System.out.println(user);
			
			if(usernameAvailable(user)) {
				System.out.println("Username available!");
				System.out.println("Creating new user, " + user.getUsername() + ".../n");
				//the idea is we're converting it to binary to store the object
				serializeUser(user);
			}else {
				System.out.println("Username is not available, please try again.");
				register();
			}
			
			
		} catch (IOException ioe) {
			System.out.println("[LOG] - Error while registering");
			ioe.printStackTrace();
		}
		
	}
	
	private static void serializeUser(User u) {
		
		String fileName = u.getUsername() + ".ser";
		/*
		 *Try-with-Resources block
		 */
		//here we're giving the file we're writing a name
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);){
			
			//now i want to take the object and specify it to the file.  So i write the specified object to the ObjectOutputStream.  
			//The class of the object, the signature of the class, and the values of the non transient and non static fields of 
			//the class and all of its supertypes are written.
			//you can make something transient when you declare it so it doesnt get serialized
			
			oos.writeObject(u);
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("[LOG] - An error occured while accessing the file");
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("[LOG] - An error occured while writing the file");
			ioe.printStackTrace();
		}
	}
	
	private static boolean usernameAvailable(User u) {
		
		String fileName = u.getUsername() + ".ser";
		File file = new File(fileName);
		
		if(file.exists()) {
			return false;
		}else {
			return true;
		}
	}
	
	private static void login() {
		
		String username, password;
		
		System.out.println("/n---------------------LOGIN------------------------");
		
		try {
			System.out.println("Username: ");
			username = br.readLine();
			
			System.out.println("Password : ");
			password = br.readLine();
			
			if(credentialsValid(username, password)) {
				System.out.println("Login Successful!");
				return;
				
			}else {
				System.out.println("Login unsuccessful!/n");
				mainMenu();
			}
		}
		catch(IOException ioe) {
			System.out.println("[LOG] - Error while reading from console");
			ioe.printStackTrace();
		}
		
	}
	
	private static boolean credentialsValid(String username, String password) {
		
		String fileName = username + ".ser";
		User user = null;
		
		//deserializing object
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)) ){
			
			user = (User) ois.readObject();
			
			if(user != null) {
				
				if(username.equals(user.getUsername()) & password.equals(user.getPassword())){
					return true;
				}
			}
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("[LOG] - An error occured while accessing the file");
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("[LOG] - An error occured while writing the file");
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("[LOG] - An error occured while deserializing the object");
			cnfe.printStackTrace();
		}
		
		return false;
	}
}
