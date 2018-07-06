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
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.Dao.BankDAO;
import com.revature.Dao.BankDB;
import com.revature.Dao.UserDAO;
import com.revature.Dao.UserDB;
import com.revature.model.Account;
import com.revature.model.User;





public class BankAccount {

	
	static Scanner value = new Scanner(System.in);
	

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static BankDAO firstDAO = new BankDB();

	public static Account credential = new Account();

	public static UserDAO secondDAO = new UserDB();
	

	public static User user = new User();

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
		
		System.out.print("[3] - Exit Bank Account ");
		
		System.out.print("\n");

		System.out.println("+-----------------------------------------------+");
		
		System.out.println("Selection: ");

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
				
			case "3":

				System.out.println("Thank You For Using the World Bank ");
				System.exit(0);
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
	private static void login() {

		String username, password;

		try {

			System.out.print("Username: ");
			
			username = br.readLine();

			System.out.print("Password: ");

			password = br.readLine();
			
	//		user = new User(0, username, password, "");
			
			// Here is where we will be deserializing the code to go back to the home page. Since 
			// it will come out successful when login into the account

			if(credentialsValide(username, password)) {

				System.out.println();

				System.out.println("+--------Welcome You have Successfully Created an Account --------+ ");
				
				
				showMenu();
			}	

			else {
				
				System.out.println("Creating a username was Unsuccessful- username not available ! Please try again.\n");

				mainMenu();

			}
		} catch (IOException e) {

			System.out.println("[LOG] - Error while reading from console");

			e.printStackTrace();
		}

	}
	
	private static void register() {

		String firstName, lastName, username, password, email;
		
		int userid = 0;
		

		System.out.println("\n+--------------WELCOME TO MyBank REGISTRATION--------------+");
		
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
			
			

			user = new User(userid, firstName, lastName, username, password, email);

			System.out.println("Checking username availability...");
			

			if(usernameAvaliable(user)) {

				System.out.println("Username available!");

				System.out.println("Creating new user, " + user.getUsername() + "\n");
				
				System.out.println("Please Login");
		
//				secondDAO.AddUser(user);
				showMenu();
			} else {

				System.out.println("Username is not available. Please try again...");

				register();

			}

		} catch (IOException e) {

			System.out.println("[LOG] - Error while reading from console");

			e.printStackTrace();
		}

	}
	
	public static void showMenu()
	{
		
	User currentUser = secondDAO.GetUser(user);
	
	ArrayList<Account> account = new ArrayList<>();
		
	String option;
	
	Account myAccount = new Account();
	
	account = firstDAO.GetFunds(currentUser);
	
	System.out.println(account);
	

	System.out.println("+--------------YOUR ACCOUNT--------------+");
	System.out.println("[1] Check My Balance ");
	System.out.println("[2] Deposit My Funds ");
	System.out.println("[3] Withdraw My Funds ");
	System.out.println("[4] Exit Application ");
	System.out.println("+-----------------------------------------+");
	System.out.println("Please Make Selection ");
	
	try {

		option = br.readLine();
		switch(option)

		{

		case "1"  :

			double acct = firstDAO.getCredbalance(myAccount);
			System.out.println("Your Current Balance = " + acct);
			
			System.out.println("+---------------------------+");

			System.out.println("\n");
			
			showMenu();

			break;

			

		case "2" :

			System.out.println(" How much will you be depositing ");

			System.out.println("+---------------------------+");

			double deposit = (value.nextInt());
			
			firstDAO.Deposit(myAccount, deposit);

			System.out.println("Your Have Depostied: " + deposit);

			showMenu();
			
			return;

		

		case "3" :

			System.out.println(" How much will you be withdrawing ");

			System.out.println("+---------------------------+");

			double withdrawAmount = value.nextInt();
			

			if((firstDAO.getCredbalance(myAccount)) - (withdrawAmount) >= 0) {
				
//				myAccount.setCredbalance((myAccount.getCredbalance()) - withdrawAmount);
				
				firstDAO.Withdraw(myAccount, withdrawAmount);

				System.out.println("You have withdrew $" + withdrawAmount);

			} else {

				System.out.println("WARNING!!! You cannot exceeded the amount in your account. WARNING!!!");
				showMenu();
				break;
			} 

			showMenu();
			break;
			
		case "4" :

			System.out.println(" Thank you and have a good day ");
			signout();
			break;

		default :

			System.out.println(" You have choose an invalid option please try again ");
			showMenu();
			break;
	
		}
	} catch (IOException e) {

		System.out.println("[LOG] - Error while reading from console");
		e.printStackTrace();

	}
	
	}
		public static void signout() {
			user =null;
			eraseInfo();
			System.exit(0);
		}

		public static void eraseInfo() {
			System.out.println("--------------------------------------------------------");
		}

// Created a checking and saving account 

	private static void newAccount() {
		String userInput;
		System.out.println("+--------------MAIN MENU--------------+");
		System.out.println("[1] - Checking");
		System.out.print("\n");
		System.out.println("+-----------------------------------------------+");
		
		System.out.println("Selection: ");
	
		
		try {

			userInput = br.readLine();

			switch(userInput) {

			case "1":

				newcheckingAccount();
				break;
				
			default:
				System.out.println("Invalid selection, please try again.\n");
				newAccount();
			}
		} catch (IOException e) {

			System.out.println("[LOG] - Error while reading from console");

			e.printStackTrace();

		}

	}
	

	private static void newcheckingAccount() {
		
		String firstName, lastName, username, password, email;
		
		int userid = 0;
		
		System.out.println("Please choose an Account");
		
		System.out.println("[1] Checking");
		System.out.println("[2] Savings ");
		
		System.out.println("You Choose: ");
		
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
			
			user = new User(userid, firstName, lastName, username, password, email);

			System.out.println("Checking username availability...");
		
		} catch (IOException e) {

			System.out.println("[LOG] - Error while reading from console");

			e.printStackTrace();
		}
		
	}

	// Made a separated method to print out my actual values using switch statements.

	
	private static boolean credentialsValide(String username, String password) {

		User auser = secondDAO.GetUser(user);
		if(user != null) {
			if(username.equals(auser.getUsername()) && password.equals(auser.getPassword())) {
				return true;		
			}
		} else{
			System.out.println("Invalid credentials..."); 
			login();
		}
	return false;
			
	}
			public static boolean usernameAvaliable(User a) {
	        User auser = secondDAO.GetUser(a);
				
				if(auser.getUsername() != null) {
					
					return false;
				}
				else {
					return true;
				}
					
				}


	
}