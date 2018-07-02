package com.revature;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import com.revature.models.User;	

public class BankAppDriver {
	static BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

	//the following tree map keeps track of all registered users, using the username
	//as the key and the actual user object as the value mapped to
	static TreeMap<String, User> userBank = new TreeMap<String, User>();


	//the following method saves the userBank by serializing it
	//and placing it in a .txt file
	public static void persistUserBank() {

		try {

			FileOutputStream file = new FileOutputStream("Bank.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(userBank);

			out.close();
			file.close();

		} catch (IOException e) {

			System.out.println("Error saving userbank");

			e.printStackTrace();
		}
	}  

	public static void retrieveUserBankFile(){
		try {

			if(new File("Bank.txt").exists()) {

				FileInputStream file = new FileInputStream("Bank.txt");
				ObjectInputStream in = new ObjectInputStream(file);

				TreeMap map = (TreeMap)in.readObject();
				userBank = map;

				in.close();
				file.close();
			}

		} catch (IOException | ClassNotFoundException e) {

			System.out.println("Error saving userbank");

			e.printStackTrace();
		}

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

			//depending on what value the user inputs, a different if statement
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

		//we retrieve the user from the userBank; at this point we know
		//the user exists since they must be logged in to withdraw money
		User currentUser = userBank.get(userName);

		int amountToWithdraw = 0;

		try {
			System.out.print("\n\nAmount to withdraw:");			

			amountToWithdraw = Integer.parseInt(userInputReader.readLine());

			//the withdraw method returns true if successful or false if not
			//If the amount entered is less than or equal to zero, withdraw returns false
			if(!currentUser.withdraw(amountToWithdraw)) {

				System.out.println("\n Insufficient funds in your account");
				loggedInMenu(userName);

			} else {

				System.out.println("\n Withdrawl successful");
				persistUserBank();

				loggedInMenu(userName);

			}

		} catch (NumberFormatException e) {

			System.out.println("Incorrect money format, please try again using a whole number");
			withdrawMoney(userName);

		} catch (IOException e) {
			System.out.println("Error withdrawing funds");
			loggedInMenu(userName);
		}
	}

	public static void depositMoney(String userName) {
		int amountToDeposit = 0;

		User currentUser = userBank.get(userName);

		try {
			System.out.print("\n\n Amount to deposit:");			
			amountToDeposit = Integer.parseInt(userInputReader.readLine());

			//deposit returns false if the number entered is less than or equal to 0
			if(!currentUser.deposit(amountToDeposit)) {

				System.out.println("Invalid amount entered for deposit: Enter an amount greater than 0");

				loggedInMenu(userName);

			} else {

				//since we made a change to a user's account, we save our data
				System.out.println("Money successfully deposited");
				persistUserBank();

				loggedInMenu(userName);
			}

		} catch (NumberFormatException | IOException e) {

			System.out.println("Invalid amount entered for deposit");
			loggedInMenu(userName);
		}


	}


	//for simplicity we treat money as a whole number, or int in our program
	public static void loggedInMenu(String userName) {
		User currentUser = userBank.get(userName);

		System.out.println("\n\n               Banking Services for " + userName);
		System.out.println("------------------------------------------------------------");
		System.out.println("[1] View balance");
		System.out.println("[2] Deposit money");
		System.out.println("[3] Withdraw money");
		System.out.println("[4] Log out");
		System.out.println("[5] Close application\n");
		System.out.print("Option selected:");

		try {
			String optionChosen = userInputReader.readLine();
			if(optionChosen.equals("1")) {

				System.out.print("Your balance is: $");
				System.out.println(currentUser.getBalance());	
				loggedInMenu(userName);

			}

			if(optionChosen.equals("2")) {

				depositMoney(userName);
			}

			if(optionChosen.equals("3")) {

				withdrawMoney(userName);
			}

			if(optionChosen.equals("4")) {

				mainMenu();
			}

			if(optionChosen.equals("5")) {

				System.out.println("\nApplication ended");
				System.exit(0);
			}

		} catch (IOException e) {
			System.out.println("Invalid selection, please try again");

		}

	}

	public static void registerAccount() {

		try {
			System.out.println("\n\n                Create New Account");
			System.out.println("------------------------------------------------------------");

			//we get the username and password below
			System.out.print("Username:");
			String userName = userInputReader.readLine();

			System.out.print("Password:");
			String password = userInputReader.readLine();

			User newUser = new User(userName, password);

			//if the user is not registered, we add them to the bank of users
			if(!userBank.containsKey(userName)) {

				userBank.put(userName, newUser);

				System.out.println("Account successfully registered");

				persistUserBank();
				mainMenu();

			} else {
				System.out.println("An account associated with that user name already exists, please try again");
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

			//if the user isn't found in the user bank, we return to the main menu
			if(!userBank.containsKey(userName)) {

				System.out.println("Login failed, returning to main menu");
				mainMenu();

				//if the password entered doesn't match the saved password for that user we go back to the main menu	
			} else if (!userBank.get(userName).getPassword().equals(password)){

				System.out.println("Login failed, returning to main menu");
				mainMenu();			

			} else {

				System.out.println("Login successful!");

				loggedInMenu(userName);
			}

		} catch (IOException e) {
			System.out.println("Error logging in, please try again");
			logIn();
		}
	}

	public static void main(String[] args) {
		retrieveUserBankFile();
		mainMenu();
	}
}
