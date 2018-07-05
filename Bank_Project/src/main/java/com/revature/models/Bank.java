package com.revature.models;

import java.io.*;
import java.util.TreeMap;

import com.revature.models.interfaces.BankInterface;

public class Bank implements BankInterface {
	static BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

	//the following tree map keeps track of all registered users, using the username
	//as the key and the actual User object as the value mapped to
	public static TreeMap<String, User> userBank;

	//we intially retrieve all the users from our database and place them into our userBank
	public static DatabaseBackUp database = new DatabaseBackUp();

	public static BankAccount currentAccount;
	public static User currentUser;


	public void startApplication() {
		userBank = database.getUsers();
		mainMenu();
	}

	public static void mainMenu() {

		System.out.println("\n\n                Welcome to Revature Bank");
		System.out.println("------------------------------------------------------------");
		System.out.println("[1] Login");
		System.out.println("[2] Create new account");
		System.out.println("[3] Close application\n");
		System.out.print("Option selected:");

		try {
			String optionChosen = userInputReader.readLine();

			//depending on what value the User inputs, a different if statement
			//is evaluated
			if(optionChosen.equals("1")) {

				logIn();

			} else if(optionChosen.equals("2")) {

				registerAccount();

			} else if(optionChosen.equals("3")) {

				System.out.println("\nApplication ended");
				System.exit(0);

				//this else is executed if they input a string, but it isn't any of the options given	
				//then we return to the main menu	
			} else {
				System.out.println("\nInvalid selection, please try again\n\n");
				mainMenu();
			}
		} catch (IOException e) {

			System.out.println("\nError reading selection, please try again\n\n");
			mainMenu();
		}
	}

	public static void withdrawMoney(String userName) {

		//we retrieve the User from the userBank; at this point we know
		//the User exists since they must be logged in to withdraw money	
		double amountToWithdraw = 0;

		try {
			System.out.print("\n\nAmount to withdraw:");			


			amountToWithdraw = Double.parseDouble(userInputReader.readLine());

			//the withdraw method returns true if the withdrawal was successful and false if not
			if(!currentAccount.withdraw(amountToWithdraw)) {

				System.out.println("\nWithdrawal unsuccessful, please try again");
				loggedInMenu(userName);

			} else {

				System.out.println("\nWithdrawl successful");

				//the withdrawal was succesful, so we save the information into the account
				//and persist our database
				currentUser.setBankAccount(currentAccount);
				database.setBalance(currentAccount.getBalance(), currentUser, currentAccount);

				loggedInMenu(userName);
			}

		} catch (NumberFormatException e) {

			System.out.println("Incorrect money format, please try again");
			withdrawMoney(userName);

		} catch (IOException e) {
			System.out.println("Error withdrawing funds");
			loggedInMenu(userName);
		}
	}

	public static void depositMoney(String userName) {
		double amountToDeposit = 0;

		try {
			System.out.print("\n\nAmount to deposit:");

			amountToDeposit = Double.parseDouble(userInputReader.readLine());

			//deposit returns false if the number is invalid
			if(!currentAccount.deposit(amountToDeposit)) {

				System.out.println("Invalid amount entered for deposit");
				loggedInMenu(userName);

			} else {

				//since we made a change to a User's account, we save our data
				System.out.println("Money successfully deposited");

				//again we persist our data in our user's bank account
				//and in the database
				currentUser.setBankAccount(currentAccount);
				database.setBalance(currentAccount.getBalance(), currentUser, currentAccount);

				loggedInMenu(userName);
			}

		} catch (IOException  | IllegalArgumentException j) {

			System.out.println("Invalid amount entered for deposit");
			loggedInMenu(userName);
		}
	}

	public static void loggedInMenu(String userName) {

		System.out.println("\n\n               Banking Services for " + userName);
		System.out.println("------------------------------------------------------------");
		System.out.println("[1] View balance");
		System.out.println("[2] Deposit money");
		System.out.println("[3] Withdraw money");
		System.out.println("[4] Log out");
		System.out.println("[5] Close application");

		//an admin will have additional menu item(s)
		if(userName.equals("admin")) {
			System.out.println("[6] See total bank balance");
		}
		System.out.print("\nOption selected:");

		try {
			String optionChosen = userInputReader.readLine();
			if(optionChosen.equals("1")) {

				System.out.print("Your balance is: $");
				System.out.println(currentAccount.getBalance());	
				loggedInMenu(userName);
			}

			if(optionChosen.equals("2")) {

				depositMoney(userName);
			}

			if(optionChosen.equals("3")) {

				withdrawMoney(userName);
			}

			if(optionChosen.equals("4")) {
				currentAccount = null;
				mainMenu();
			}

			if(optionChosen.equals("5")) {

				System.out.println("\nApplication ended");
				System.exit(0);
			}

			if(userName.equals("admin")) {
				 if(optionChosen.equals("6")) {
					database.adminViewTotalBalance();
					loggedInMenu(userName);
				}
			}
		} catch (IOException e) {
			System.out.println("Invalid selection, please try again");
		}
	}

	public static void registerAccount() {

		try {
			System.out.println("\n\n                Create New Account");
			System.out.println("------------------------------------------------------------");

			//we get the user information below
			System.out.print("First name:");
			String firstName = userInputReader.readLine();

			System.out.print("Last name:");
			String lastName = userInputReader.readLine();

			System.out.print("Username:");
			String userName = userInputReader.readLine();

			System.out.print("Password:");
			String password = userInputReader.readLine();

			User newUser = new User(firstName, lastName, userName, password);

			//if the User is not registered, we add them to the bank of users
			if(!userBank.containsKey(userName)) {

				//if the user doesn't already exist we save them into our database
				//and place them in our internal tree map
				database.registerAccount(newUser, newUser.getBankAccount());
				userBank.put(userName, newUser);

				System.out.println("Account successfully registered");

				mainMenu();

			} else {
				System.out.println("An account associated with that User name already exists, please try again");
				registerAccount();
			}
		} catch (IOException e) {

			System.out.println("Error registering account, please try again");
			registerAccount();
		}
	}

	public static void logIn() {

		try {

			System.out.println("\n\n                Login");
			System.out.println("------------------------------------------------------------");

			//we get our username and password
			System.out.print("Username:");
			String userName = userInputReader.readLine();

			System.out.print("Password:");
			String password = userInputReader.readLine();

			//if the User isn't found in the User bank, we return to the main menu
			if(!userBank.containsKey(userName)) {

				System.out.println("Login failed, returning to main menu");
				mainMenu();

				//if the password entered doesn't match the saved password for that User we go back to the main menu	
			} else if (!userBank.get(userName).getBankAccount().getPassword().equals(password)){

				System.out.println("Login failed, returning to main menu");
				mainMenu();			

			} else {

				System.out.println("Login successful!");

				//once a user logs in we store their information in our class so that accessing
				//them is easier
				currentUser = userBank.get(userName);
				currentAccount = currentUser.getBankAccount();

				loggedInMenu(userName);
			}

		} catch (IOException e) {
			System.out.println("Error logging in, please try again");
			logIn();
		}
	}	
}
