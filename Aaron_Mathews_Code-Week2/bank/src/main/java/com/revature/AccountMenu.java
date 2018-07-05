package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.revature.dao.AccountDAOImpl;
import com.revature.dao.UserDAOImpl;
import com.revature.models.Account;
import com.revature.models.User;

public class AccountMenu {
	private static User currentUser = null;
	private static Account currentAccount = null;
	private static AccountDAOImpl accDAO = new AccountDAOImpl();
	private static UserDAOImpl userDAO = new UserDAOImpl();

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void createAccount() {
		String firstName, lastName, username, password, email;
		
		
		System.out.println("-----------CREATE ACCOUNT-----------\n");
		System.out.println("All fields must have at least four characters and no more than 40 characters.");
		
		try {
			System.out.print("First name: ");
			firstName = br.readLine();
			
			System.out.print("\nLast name: ");
			lastName = br.readLine();
			
			System.out.print("\nUsername: ");
			username = br.readLine();
			
			System.out.print("\nEmail: ");
			email = br.readLine();
			
			System.out.print("\nPassword: ");
			password = br.readLine();
			
			User newUser = new User(1, username, firstName, lastName, email, password);
			Account newAccount = new Account(1, 0.0, newUser.getUserId());
			
			if (firstName.length() < 4 || lastName.length() < 4 || username.length() < 4 || email.length() < 4 || password.length() < 4) {
				System.out.println("All fields must have at least four characters. Please try again.");
				MainMenu.mainMenu();
			}
			
			if (firstName.length() > 40 || lastName.length() > 40 || username.length() > 40 || email.length() > 40 || password.length() > 40) {
				System.out.println("All fields must have no more than 40 characters characters. Please try again.");
				MainMenu.mainMenu();
			}
			
			if (!accDAO.checkUsername(username)) {
				System.out.println("Username not available. Please try another.");
				MainMenu.mainMenu();
			} else if (!accDAO.checkEmail(email)) {
				System.out.println("Email not available. Please try another.");
				MainMenu.mainMenu();
			} else {
				currentUser = userDAO.createUser(newUser);
				currentAccount = accDAO.createAccount(newAccount, currentUser);
				System.out.println("User and account successfully created");
				Thread.sleep(2000);
				accountMenu(currentAccount);
			}
			
		} catch (IOException e) {
			System.out.println("Error while reading input. Please try again.");
			createAccount();
		} catch (InterruptedException e) {
			System.out.println("Error occured. Please try again.");
			createAccount();
		}
	}
	
	static void login()	{
		
		try {
			System.out.println("Username: ");
			String username = br.readLine();
			
			System.out.println("Password: ");
			String password = br.readLine();
			
			if (checkCred(username, password)) {
				System.out.println("Login Successful");
				currentUser = userDAO.getUserByUsername(username);
				currentAccount = accDAO.getAccountByUser(currentUser);
				accountMenu(currentAccount);
			} else {
				System.out.println("Invalid credentials. Please try again");
				MainMenu.mainMenu();
			}
		} catch (IOException e) {
			System.out.println("Error occured while reading input. Please try again.");
			MainMenu.mainMenu();
		}
	}
	
	public static void accountMenu(Account...account) {
		if (account[0].getAccountId() != 0) {
			currentAccount = account[0];
		}
		
		String name = currentUser.getFirstname();
		System.out.println("-----------ACCOUNT MENU-----------\n");
		System.out.println("Hello " + name + "! What would you like to do today?");
		System.out.println("[1] Balance Inquiry");
		System.out.println("[2] Withdrawal");
		System.out.println("[3] Deposit");
		System.out.println("[4] Transaction History");
		System.out.println("[5] End session and log out");
		if (currentUser.getUsername().equals("admin")) {
			System.out.println("[6] View all accounts");
			System.out.println("[7] View average account balance");
		}
		
		try {
			String input = br.readLine();
			
			switch(input) {
			case "1":
				balanceMenu();
				break;
			case "2":
				TransactionMenu.withdrawMenu(currentAccount);
				break;
			case "3":
				TransactionMenu.depositMenu(currentAccount);
				break;
			case "4":
				TransactionMenu.displayTransactions(currentAccount);
				break;
			case "5":
				currentUser = null;
				MainMenu.mainMenu();
				break;
			case "6":
				if (currentUser.getUsername().equals("admin")) {
					viewAccounts();
					break;
				}
			case "7":
				if (currentUser.getUsername().equals("admin")) {
					viewAccountAverage();
					break;
				}
			default:
				System.out.println("Invalid input. Please try again.");
				accountMenu(currentAccount);
			}
		} catch (IOException ioe) {
			System.out.println("Error occured while reading input. Please try again.");
			accountMenu(currentAccount);
		}
	}
	
	private static void viewAccountAverage() {
		double avgBalance = accDAO.getAverageBalance();
		System.out.println("The average balance across accounts is: $" + avgBalance);
		System.out.println("Press enter to return to the previous menu at any time.");
		try {
			String str = br.readLine();
			
			switch(str) {
			default:
				accountMenu(currentAccount);
			}
		} catch (IOException ioe) {
			System.out.println("Error occured while retrieving accounts. Please try again.");
		}
	}

	private static boolean checkCred(String username, String password) {
		UserDAOImpl userDAO = new UserDAOImpl();
		User temp = userDAO.getUserByUsername(username);
		
		if (temp.getUserId() == 0) {
			return false;
		}
			
		boolean checkPass = temp.getPassword().equals(password);
		
		if(!checkPass) {
			return false;
		}
		currentUser = temp;
		return true;
	}
	
	private static void balanceMenu() {
		double balance = currentAccount.getBalance();
		System.out.println("The current balance in the account is: $" + balance);
		System.out.println("Return to the Account Menu at any time by entering any key.");
		
		try {
			String input = br.readLine();
			
			switch(input) {
			default:
				accountMenu(currentAccount);
			}
		} catch (IOException ioe) {
			System.out.println("Error occured while reading input. Please try again.");
			balanceMenu();
		}
	}
	
	private static void viewAccounts() {
		ArrayList<Account> accounts = accDAO.getAllAccounts();
		
		for (Account acc : accounts) {
			System.out.println("Account: " + acc.getAccountId() + " for user: " + acc.getOwnerId() + " has a balance of $" + acc.getBalance() + ".");
		}
		System.out.println("Press enter to return to the previous menu at any time.");
		try {
			String str = br.readLine();
			
			switch(str) {
			default:
				accountMenu(currentAccount);
			}
		} catch (IOException ioe) {
			System.out.println("Error occured while retrieving accounts. Please try again.");
		}
	}
}
