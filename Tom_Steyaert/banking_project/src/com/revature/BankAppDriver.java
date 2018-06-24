package com.revature;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

import com.revature.models.User;

public class BankAppDriver {
	static BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
	static Date currentTime = new Date();

	//the following tree map keeps track of all registered users, using the username
	//as the key and the actual user object as the value mapped to
	static TreeMap<String, User> userBank = new TreeMap<String, User>();


	public static void persistUserBank() {
		String fileName = Long.toString(currentTime.getTime()) + ".txt";

		FileOutputStream file;
		try {

			file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(userBank);
			out.close();
			file.close();

		} catch (FileNotFoundException e) {
			System.out.println("error");

		} catch (IOException e) {
			System.out.println("error");

		}
	}

	public static void mainMenu() {

		persistUserBank();

		System.out.println("\n\n                Welcome to Revature Bank");
		System.out.println("------------------------------------------------------------");
		System.out.println("[1] Login");
		System.out.println("[2] Create new account");
		System.out.println("[3] Close application\n");
		System.out.print("Option selected:");

		try {
			String optionChosen = userInputReader.readLine();

			if(optionChosen.equals("1")) {

				logIn();

			} else if(optionChosen.equals("2")) {

				registerAccount();

			} else if(optionChosen.equals("3")) {
				System.out.println("Application ended");
				System.exit(0);
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

		User currentUser = userBank.get(userName);

		int amountToWithdraw = 0;

		try {
			System.out.print("\n\nAmount to withdraw:");			

			amountToWithdraw = Integer.parseInt(userInputReader.readLine());

			//if this is true, we know the withdrawl was successful
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
			System.out.print("\n\n"
					+ "Amount to deposit:");			
			amountToDeposit = Integer.parseInt(userInputReader.readLine());

			currentUser.deposit(amountToDeposit);

			System.out.println("Money successfully deposited");

			persistUserBank();

			loggedInMenu(userName);

		} catch (NumberFormatException | IOException e) {

			System.out.println("Invalid amount entered for deposit");
			loggedInMenu(userName);
		}


	}

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
			System.out.print("Username:");

			String userName = userInputReader.readLine();

			System.out.print("Password:");

			String password = userInputReader.readLine();

			if(!userBank.containsKey(userName)) {

				System.out.println("Login failed, please try again");
				logIn();

			} else if (!userBank.get(userName).getPassword().equals(password)){

				System.out.println("Login failed, please try again");
				logIn();			

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
		mainMenu();
	}
}
