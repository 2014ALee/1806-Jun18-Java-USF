package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.Account;
import com.revature.models.User;

public class BankAppDriver {

	static Scanner input = new Scanner(System.in);
	// Create static user
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static AccountDao accountDao = new AccountDaoImpl();
	public static Account account = new Account();
	public static UserDao userDao = new UserDaoImpl();
	public static User user = new User();
	
	public static void main(String[] args) {

		// Prompt the user with the main menu
		mainMenu();
	}

	public static void mainMenu() {
		String userInput;
		System.out.println("\t \t \t \t---------Welcome to the main menu!-----------");

		System.out.println("[1] - Login");
		System.out.println("[2] - Register");
		System.out.println("[3] - Exit");
		System.out.print("\nYou selected: ");

		try {
			userInput = br.readLine();

			switch(userInput) {
			case "1":
				System.out.println("\n Please enter your credentials: \n");
				login();
				break;
			case "2":
				System.out.println("\n Create your username and password:");
				register();
				break;
			case "3":
				System.out.println("Thank you! Goodbye!");
				System.exit(0);
			default:
				System.out.println("\nInvalid selection. Please try again. \n");
				mainMenu();
			}

		} catch (IOException e) {
			System.out.println("[Log] - Error while reading from console.");
			e.printStackTrace();
		}
	}	


	private static void login(){
		String username, password;

		try {
			System.out.println("Username: ");
			username = br.readLine();

			System.out.println("Password: ");
			password = br.readLine();
			
			user = new User(0, username, password, "");
			
			if(credentialsValid(username, password)) {
				System.out.println("\nLogin successful!\n");
				System.out.println("\t \t \t \t---------Welcome to the login menu!-----------\n");
				loginMenu();

			}else {
				System.out.println("\nLogin unsuccessful! Please try again.\n");
				mainMenu();
			}

		} catch (IOException e) {
			System.out.println("[Log] - Error while reading from console.");
			e.printStackTrace();
		}
	}

	private static void loginMenu() {
		
		User currentUser = userDao.GetUser(user);
		ArrayList<Account> account = new ArrayList<>();
		String loginMenuInput;
		Account currentAccount = new Account();

		System.out.println("Here are your available accounts:\n");
	
		account = accountDao.GetAccounts(currentUser);
		System.out.println(account);
		System.out.println("\nPlease enter the account "
				+ "number of the account you wish to view or press [4] to logout:");
		
		try {
				int accountnum = input.nextInt();
				if(accountnum == 4) {
					System.out.println("You have successfully logged out!");
					mainMenu();
				}
				else {
				currentAccount = accountDao.GetAccount(accountnum);
				}
		}catch (InputMismatchException e) {
			System.out.println("\nAccount number must be an integer.");
		}
		System.out.println(" \nPlease select what you would like to do from here:");
		System.out.println("[1] Deposit");
		System.out.println("[2] Withdraw");
		System.out.println("[3] View Balance");
		System.out.println("[4] Logout");
		System.out.println("Option: ");

		try {
			loginMenuInput = br.readLine();
			switch(loginMenuInput) {
			case "1":
				System.out.println("How much would you like to deposit?");
				double depositAmount = (input.nextDouble());
				accountDao.Deposit(currentAccount, depositAmount);
				System.out.println("You successfully deposited: " + depositAmount + " dollars! \n");
				loginMenu();
				break;
			case "2":
				System.out.println("How much would you like to withdraw?");
				double withdrawalAmount = input.nextDouble();
				if((accountDao.GetBalance(currentAccount)) - (withdrawalAmount) >= 0) {
					accountDao.Withdraw(currentAccount, withdrawalAmount);
					System.out.println("You successfully withdrew " + withdrawalAmount + " dollars! \n");
				} else {
					System.out.println("You may not overdraft. Please check your balance before withdrawing.\n");
					loginMenu();
					break;
				}

				loginMenu();
				break;
			case "3":
				System.out.println("\n Balance: ");
				double acct_balance = accountDao.GetBalance(currentAccount);
				System.out.println(acct_balance + "\n");
				loginMenu();
				break;
			case "4":
				System.out.println("Are you sure you would like to log out?\n"
						+ "[1] - Yes\n"
						+ "[2] - No");
				String status = br.readLine();
				if (status.equals("1")) {
					System.out.println(" You have successfully Logged out! \n");
					mainMenu();
				}else {
					loginMenu();
				}
				break;
			default:
				System.out.println("Invalid selection. Please try again. \n");
				loginMenu();
			}
		}catch (IOException e) {
			System.out.println("You must enter an acceptable money value.");
			e.printStackTrace();
		}
			
		}
	

	public static void register() {
		String username, password, email;

		System.out.println("\t \t \t \t \t+-------REGISTER-------+");


		try {

			System.out.print("Username: ");
			username = br.readLine();

			System.out.print("Password: ");
			password = br.readLine();

			System.out.print("Email Address: ");
			email = br.readLine();


			user = new User(0, username, password, email);
			System.out.println("Checking username availability... \n");


			if (usernameAvailable(user)) {
				System.out.println("Username Available!\n");
				System.out.println("Creating new user, " + user.getUserName() + "...\n");
				userDao.AddUser(user);
				System.out.println("Would you like to create a checking or savings account?\n"
						+ "[1] - Checking\n"
						+ "[2] - Savings");
				String accountType = br.readLine();
				if (accountType.equals("1")) {
					accountType = "Checking";
					accountDao.createAccount(user, accountType );
					System.out.println("Checking account created!");
					loginMenu();
				}else {
					accountType = "Savings";
					accountDao.createAccount(user, accountType);
					System.out.println("Savings account created!");
					loginMenu();
				}
			} else {
				System.out.println("Username is not available. Please try again...");
				register();
			}
		} catch (IOException e) {
			System.out.println("[Log] - Error while reading from console.");
			e.printStackTrace();
		}	
	}
	
	public static boolean usernameAvailable(User u) {
		
		User newUser = userDao.GetUser(u);

		if(newUser.getUserName() != null) {
			return false;
		}else {
			return true;
		}
	}

	public static boolean credentialsValid(String username, String password) {
		
		User newUser = userDao.GetUser(user);
		if(user != null) {
			if(username.equals(newUser.getUserName()) && password.equals(newUser.getPassword())) {
				return true;		
			}
		} else{
			System.out.println("Invalid credentials..."); 
			login();
		}
	return false;
}

}






