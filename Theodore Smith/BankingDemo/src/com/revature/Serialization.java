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
import java.util.Scanner;

import com.revature.model.User;


public class Serialization {

	private static User user = null;

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


	public static void main(String[] args) {

		

		mainMenu();



	}


 // Here is where everything for the main menu was made 
	private static void mainMenu() {



		String userInput;


		// Here is where you make all the options you want the menu to give once someone wants to use the bank.
		// Either logging in/ registering an account now once the user knows what they want to do the they choose from the two options.
		
		System.out.println("+--------------MAIN MENU--------------+");

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

				System.out.println("Invalid selection, please try again.\n");

				mainMenu();

			}



		} catch (IOException e) {

			System.out.println("[LOG] - Error while reading from console");

			e.printStackTrace();

		}



	}
	
	int balance1;
	
	void deposit(int amount)
	{
		if(amount != 0)
		{
			balance1 = balance1 + amount;
			//previousTransaction = amount;
		
		}
	}
	void withdraw(int amount) {
		
		if(amount != 0)
		{
			balance1 = balance1 - amount;
			//previousTransaction = amount;
		
		}
		
	}

void showMenu()
{
	char option = '\0';
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("A. Check My Balance ");
	System.out.println("B. Deposit My Funds ");
	System.out.println("C. Withdraw My Funds ");
	System.out.println("E. Exit Application ");
	
		switch(option)
		{
		case 'A' :
			System.out.println("Your Current Balance = " + balance1);
			System.out.println("+---------------------------+");
			System.out.println("\n");
			break;
			
		case 'B' :
			System.out.println(" How much will you be depositing ");
			System.out.println("+---------------------------+");
			int amount1 = scanner.nextInt();
			deposit(amount1);
			System.out.println("\n");
			break;
		
		case 'C' :
			System.out.println(" How much will you be withdrawing ");
			System.out.println("+---------------------------+");
			int amount2 = scanner.nextInt();
			withdraw(amount2);
			System.out.println("\n");
			break;
			
		case 'E' :
			System.out.println(" Thank you and have a good day ");
			break;
			
		default :
			System.out.println(" You have choose an invalid option please try again ");
			break;
		}
	}




	private static void register() {

		

		String firstName, lastName, username, password, email;

		

		System.out.println("\n+--------------WELCOME TO MyBANKS REGISTRATION--------------+");

		

		

		try {

			

			System.out.print("What is your First name: ");

			firstName = br.readLine();

			

			System.out.print("What is your Last name: ");

			lastName = br.readLine();

			

			System.out.print("Create your Username: ");

			username = br.readLine();

			

			System.out.print("Create a Password: ");

			password = br.readLine();

			

			System.out.print(" What is your Email Address: ");

			email = br.readLine();

			

			user = new User(firstName, lastName, username, password, email);

			System.out.println("Checking username availability...");

			

			if(usernameAvailable(user)) {

				System.out.println("Username available!");

				System.out.println("Creating new user, " + user.getUsername() + "...\n");

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

	

	private static void serializeUser(User u) {

		

		String fileName = u.getUsername() + ".ser";

		

		/*
		 All done in class using instructors work for this information.
		 
		 
		 
		 * Try-with-Resources block

		 * 

		 * Syntactically it is a try block with a set of parenthesis that is used to declared and initialize any

		 * variables whose data type implement the AutoCloseable interface. Any variables declared here will be 

		 * automatically closed after the try/catch execution.

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

			System.out.println("[LOG] - An error occurred while accessing the file");

			e.printStackTrace();

		} catch (IOException e) {

			System.out.println("[LOG] - An error occurred while writing the file");

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

		

		String username, password;

		

		System.out.println("\n+--------------PLEASE LOGIN--------------+");

		

		try {

			

			System.out.print("Username: ");

			username = br.readLine();

			

			System.out.print("Password: ");

			password = br.readLine();

			

			if(credentialsValid(username, password)) {
				
				System.out.println();
				System.out.println("+--------Welcome You have Successfully Logged In--------+ ");
				System.out.println();
				
					BankAccount obj1 = new BankAccount();
					obj1.showMenu();
					
				// Here is where we will be deserializable the code to go back to the home page. 
				
			}	
					
			else {

				System.out.println("Login unsuccessful!\n");

				mainMenu();
			}


		} catch (IOException e) {

			System.out.println("[LOG] - Error while reading from console");

			e.printStackTrace();

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

			e.printStackTrace();

		} catch (IOException e) {

			System.out.println("[LOG] - An error occurred while writing the file");

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			System.out.println("[LOG] - An error occurred while deserializing the object");

			e.printStackTrace();

		}

		

		return false;

	}



}