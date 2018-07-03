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
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

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
		System.out.println("---------Welcome to the main menu!-----------");

		System.out.println("[1] - Login");
		System.out.println("[2] - Register");
		System.out.println("[3] - Exit");
		System.out.print("You selected: ");

		try {
			userInput = br.readLine();

			switch(userInput) {
			case "1":
				System.out.println("\n Please enter your credentials:");
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
				System.out.println("Invalid selection. Please try again. \n");
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

			if(credentialsValid(username, password)) {
				System.out.println("\nLogin successful!\n");
				loginMenu();

			}else {
				System.out.println("Login unsuccessful! Please try again.\n");
				mainMenu();
			}

		} catch (IOException e) {
			System.out.println("[Log] - Error while reading from console.");
			e.printStackTrace();
		}
	}

	private static void loginMenu() {
		
		String loginMenuInput;

		System.out.println("Welcome to the login menu! Please enter the account "
				+ "number of the account you wish to view.");
		int accountnum = input.nextInt();
		account = accountDao.GetAccount(accountnum);
		System.out.println(" Please select what you would like to do from here.");

		System.out.println("[1] Deposit");
		System.out.println("[2] Withdraw");
		System.out.println("[3] View Balance");
		System.out.println("[4] Logout");
		System.out.println("Option: ");

		try {
			loginMenuInput = br.readLine();
			double account_balance = account.getBalance();
			switch(loginMenuInput) {
			case "1":
				System.out.println("How much would you like to deposit?");
				double depositAmount = (input.nextDouble());
				accountDao.Deposit(account, depositAmount);
				System.out.println("You successfully deposited: " + depositAmount + " dollars! \n");
				loginMenu();
				break;
			case "2":
				System.out.println("How much would you like to withdraw?");
				double withdrawalAmount = input.nextDouble();
				if((account.getBalance()) - (withdrawalAmount) >= 0) {
					account.setBalance((account.getBalance() - withdrawalAmount));
					accountDao.Withdraw(account, withdrawalAmount);
					System.out.println("You successfully withdrew " + withdrawalAmount + " dollars! \n");
				} else {
					System.out.println("You may not overdraft! Please check your balance before withdrawing.\n");
					loginMenu();
					break;
				}

				loginMenu();
				break;
			case "3":
				System.out.println("\n Balance: ");
				System.out.println(account.getBalance() + "\n");
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
			System.out.println("[Log] - Error while reading from console.");
			e.printStackTrace();
		}

	}

	public static void register() {
		String firstName, lastName, username, password, email;
		int userid = 0;

		System.out.println("+-------REGISTER-------+");


		try {
			System.out.print("First Name: ");
			firstName = br.readLine();

			System.out.print("Last Name: ");
			lastName = br.readLine();

			System.out.print("Username: ");
			username = br.readLine();

			System.out.print("Password: ");
			password = br.readLine();

			System.out.print("Email Address: ");
			email = br.readLine();


			user = new User(userid, firstName, lastName, username, password, email);
			System.out.println("Checking username availability... \n");


			if (usernameAvailable(user)) {
				System.out.println("Username Available!\n");
				System.out.println("Creating new user, " + user.getUserName() + "...\n");
				userDao.AddUser(user);
				createAccount();
			} else {
				System.out.println("Username is not available. Please try again...");
				register();
			}


		} catch (IOException e) {
			System.out.println("[Log] - Error while reading from console.");
			e.printStackTrace();
		}	
	}
	
	
	public static void createAccount() {
		String menuInput;
		System.out.println("+-------Create Account-------+");
		
		System.out.println("Please select the kind of account you would like to create.");

		System.out.println("[1] Checking");
		System.out.println("[2] Savings");
		System.out.println("Option: ");
		
		try {
			menuInput = br.readLine();
			switch(menuInput) {
			case "1":
				createCheckingAccount();
				break;
			case "2":
				createSavingsAccount();
				break;
			default:
				System.out.println("Invalid selection. Please try again. \n");
				createAccount();
				
			}
			
		}catch (IOException e) {
			System.out.println("[Log] - Error while reading from console.");
			e.printStackTrace();}
	}
	
	public static void createCheckingAccount() {
System.out.println("+-------Create Checking Account-------+");
		
		System.out.println("Please enter account information below.");

		System.out.println("[1] Checking");
		System.out.println("[2] Savings");
		System.out.println("Option: ");
		
		try {
				System.out.print("First Name: ");
				firstName = br.readLine();

				System.out.print("Last Name: ");
				lastName = br.readLine();

				System.out.print("Username: ");
				username = br.readLine();

				System.out.print("Password: ");
				password = br.readLine();

				System.out.print("Email Address: ");
				email = br.readLine();


				user = new User(userid, firstName, lastName, username, password, email);
				System.out.println("Checking username availability... \n");
		}catch (IOException e) {
			System.out.println("[Log] - Error while reading from console.");
			e.printStackTrace();}
	}

	private static boolean usernameAvailable(User u) {
		User newUser = userDao.GetUser(u);

		if(newUser.getUserName() != null) {
			return false;
		}else {
			return true;
		}
	}

	public static boolean credentialsValid(String username, String password) {	

		if(user != null) {
			if(username.equals(user.getUserName()) && password.equals(user.getPassword())) {
				return true;
			}
		} else {
			System.out.println("Invalid credentials..."); 
			login();
		}
	return false;
}

}






