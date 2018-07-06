package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.UserDAOImpl;

public class SimpleBank {
	// br is used by all methods but main(args)
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static UserDAOImpl userDao = new UserDAOImpl();

	public static void main(String[] args) {
		mainMenu();

		try {
			br.close();
		} catch (IOException e) {
			System.out.println("Trouble with closing input.");
			e.printStackTrace();
		}
	}

	public static void mainMenu() {
		System.out.println("Welcome!");
		System.out.println("[1] Login");
		System.out.println("[2] Register");

		try {
			switch(br.readLine()) {
			case "1":
				loginMenu();
				break;
			case "2":
				registerMenu(true);
				break;
			default:
				System.out.println("Invalid input. Please try again.");
				mainMenu();
			}
		} catch (IOException e) {
			System.out.println("Input Error");
			e.printStackTrace();
		}
	}

	private static void registerMenu(boolean fromMainMenu) {
		// Capitalized e-mail this way because it's an abbreviated version of 'electronic mail'.
		String username, password, firstName, lastName, eMail;

		System.out.println("Register");

		try {
			// Getting Registration info
			System.out.println("First Name: ");
			firstName = br.readLine();

			System.out.println("Last Name: ");
			lastName = br.readLine();

			// Checking if first name and last name contain only valid characters
			if(!firstName.matches("^[A-Za-z ]+$") || !lastName.matches("[A-Za-z]+(-[A-Za-z ]+)?")) {
				System.out.println("Invalid name");
				registerMenu(fromMainMenu);
				return;
			}

			// TODO: SQL Injection cleaning on username and password
			System.out.println("Username: ");
			username = br.readLine();

			System.out.println("Password: ");
			password = br.readLine();

			System.out.println("E-mail: ");
			eMail = br.readLine();

			// Checking if e-mail contains only valid characters, and has the required characters
			if(!eMail.matches("^[A-Za-z][\\w-_\\.]*@[a-z0-9]+\\.[a-z]+")) {
				System.out.println("Invalid email");
				registerMenu(fromMainMenu);
				// To fix registration of invalid input 2 wrong inputs registered the 2nd input into the database
				return;
			}

			User user = new User(username,password,firstName,lastName,eMail);

			// Username availability checking, registerMenu() is called again if not
			// If the username is available, mainMenu() called so they can log in right away
			if(1 == userDao.usernameAvailable(user)) {
				user = userDao.createUser(user);
				if(user != null) {
					System.out.println("Created user");
					if(fromMainMenu) {
						user = null;
						mainMenu();
					}
					else {
						System.out.println("Joint account ability not added yet");
					}
				} else {
					System.out.println("User creation error");
				}
			} else {
				System.out.println("Username unavailable. Please try again.");
				registerMenu(fromMainMenu);
			}
		} catch (IOException e) {
			System.out.print("Input Error");
			e.printStackTrace();
		}
	}

	private static void loginMenu() {
		String username, password;
		User user = new User();

		System.out.println("Login");

		try {
			System.out.println("Username: ");
			username = br.readLine();

			System.out.println("Password: ");
			password = br.readLine();
			
			user.setUsername(username);
			user.setPassword(password);

			// Checking Credentials
			user = userDao.validateUser(user);
			if(user != null) {
				clientMenu(user);
			} else {
				System.out.print("Login Credentials Incorrect. Please try again.");
				mainMenu();
			}
		} catch(IOException e) {
			System.out.println("Input Error");
			e.printStackTrace();
		}
	}
	
	public static void clientMenu(User u) {
		AccountDAOImpl accountDao = new AccountDAOImpl();
		ArrayList<Account> accounts = new ArrayList<>();
		Account account = new Account();
		String doubleCheck = new String();
		double amount;
		
		accounts = accountDao.getAccounts(u);
		
		account = accounts.get(0);

		System.out.println("[1] Deposit");
		System.out.println("[2] Withdrawl");
		System.out.println("[3] View Balance");
		System.out.println("[4] Logout");

		try {
			switch(br.readLine()) {
			// Deposit
			case "1":
				System.out.println("Enter the amount you wish to deposit:");

				doubleCheck = br.readLine();

				// Check to see if a double
				if(numCheck(doubleCheck)) {
					amount = Double.parseDouble(doubleCheck);
					if(amount > 0) {
						account.deposit(amount);
						System.out.println("Balance:\n" + account.getBalance());
					}
				} else {
					System.out.println("Invalid input");
				}
				break;
				// Withdrawal: Same as deposit, but different setter for balance
			case "2":
				System.out.println("Enter the amount you wish to withdraw:");

				doubleCheck = br.readLine();
				if(numCheck(doubleCheck)) {
					amount = Double.parseDouble(doubleCheck);
					if(amount > 0  && (account.getBalance() - amount) >= 0) {
						account.withdrawl(amount);
						System.out.println("Balance:\n" + account.getBalance());
					} else { 
						System.out.println("Not enough currency to make transaction.");
					}
				} else {
					System.out.println("Invalid input");
				}
				break;
				// Balance
			case "3":
				System.out.println("Your Balance");
				System.out.println(account.getBalance());
				break;
			case "4":
				System.out.println("Logged Out");
				return;
			default:
				System.out.println("Invalid input. Please try again.");
				clientMenu(u);
				break;
			}
		} catch (IOException e) {
			System.out.println("Input Error");
			e.printStackTrace();
		}

		clientMenu(u);
	}
	
	public static boolean numCheck(String str) {
		// Checks for a double
		if(str.matches("^\\d*\\.?\\d?\\d?$")) {
			return true;
		} else {
			return false;
		}
	}
}