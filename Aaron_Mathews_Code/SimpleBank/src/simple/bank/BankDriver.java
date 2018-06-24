package simple.bank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import simple.bank.models.User;

public class BankDriver {		

	private static User user = null;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		mainMenu();
	}

	private static void mainMenu() {
		String userInput;

		System.out.println("-----------MAIN MENU-----------");
		System.out.println("(Enter the number of the option you would like to choose)");
		System.out.println("[1] Create an account\n[2] Login");

		try {
			userInput = br.readLine();
			switch(userInput) {
			case "1":
				createAccount();
				break;
			case "2":
				login();
				break;
			default:
				System.out.println("Invalid input. Please try again.");
				mainMenu();
			}
		} catch (IOException e) {
			System.out.println("There was an error while reading input.\nPlease try again.");
			mainMenu();
		}
	}
	
	private static void createAccount() {
		String firstName, lastName, loginName, password;
		System.out.println("-----------CREATE ACCOUNT-----------\n");
		
		try {
			System.out.print("First name: ");
			firstName = br.readLine();
			
			System.out.print("\nLast name: ");
			lastName = br.readLine();
			
			System.out.print("\nUsername or Email: ");
			loginName = br.readLine();
			
			System.out.print("\nPassword: ");
			password = br.readLine();
			
			user = new User(firstName, lastName, loginName, password);
			
			
			if (loginAvailable(user)) {
				System.out.println("Successfully created account!");
				serializeUser(user);
				accountMenu();
			} else {
				System.out.println("Login not available. Please try a different username or email.");
				createAccount();
			}
			
		} catch (IOException e) {
			System.out.println("Error while reading input. Please try again.");
			createAccount();
		}
	}
	
	private static void serializeUser(User user) {
		String fileName = user.getLoginName() + ".ser";

		try (FileOutputStream fos = new FileOutputStream(fileName); 
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(user);
			
		} catch (FileNotFoundException e) {
			System.out.println("[LOG] - An error occurred while accessing the file.");
			createAccount();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occured while writing the file");
			createAccount();
		}
		
	}
	
	private static boolean loginAvailable(User user) {
		String loginStr = user.getLoginName() + ".ser";
		
		File file = new File(loginStr);
		
		if (file.exists()) {
			return false;
		}
		return true;
	}
	
	private static void login() {	
		try {
			System.out.println("Username or Email: ");
			String loginName = br.readLine();
			
			System.out.println("Password: ");
			String password = br.readLine();
			
			if (checkInfo(loginName, password)) {
				System.out.println("Login Successful");
				accountMenu();
			} else {
				System.out.println("Invalid credentials. Please try again");
				login();
			}
		} catch (IOException e) {
			System.out.println("Error occured while reading input. Please try again.");
			login();
		}
	}
	
	private static boolean checkInfo(String loginName, String password) {
		String fileName = loginName + ".ser";
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			
			user = (User) ois.readObject();
			
			if (user != null & user.getLoginName().equals(loginName) & user.getPassword().equals(password)) {
				return true;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error occurred while accessing the file. Please try again.");
			login();
		} catch (IOException e) {
			System.out.println("Error occured while reading the file. Please try again.");
			login();
		} catch (ClassNotFoundException e) {
			System.out.println("Error occured while deserializing object. Please try again.");
			login();
		}
		return false;
	}
	
	private static void accountMenu() {
		String userName = user.getFirstName();
		System.out.println("-----------ACCOUNT MENU-----------\n");
		System.out.println("Hello " + userName + "! What would you like to do today?");
		System.out.println("[1] Balance Inquiry");
		System.out.println("[2] Withdrawal");
		System.out.println("[3] Deposit");
		System.out.println("[4] End session and Logout");
		
		try {
			String input = br.readLine();
			
			switch(input) {
			case "1":
				balanceMenu();
				break;
			case "2":
				withdrawMenu();
				break;
			case "3":
				depositMenu();
				break;
			case "4":
				serializeUser(user);
				user = null;
				mainMenu();
				break;
			default:
				System.out.println("Invalid input. Please try again.");
				accountMenu();
			}
		} catch (IOException ioe) {
			System.out.println("Error occured while reading input. Please try again.");
			accountMenu();
		}
	}
	
	private static void balanceMenu() {
		double balance = user.getBalance();
		System.out.println("The current balance in the account is: $" + balance);
		System.out.println("Return to the Account Menu at any time by entering '1'.");
		
		try {
			String input = br.readLine();
			
			switch(input) {
			case "1":
				accountMenu();
				break;
			default:
				System.out.println("Invalid input. Please try again.");
				balanceMenu();
			}
		} catch (IOException ioe) {
			System.out.println("Error occured while reading input. Please try again.");
			balanceMenu();
		}
	}
	
	private static void withdrawMenu() {
		double balance = user.getBalance();
		if (balance == 0.0) {
			System.out.println("Withdrawal is unavailable on this account because of the current balance");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Error occured. Please try again");
			}
			accountMenu();
		} else {
			try {
				System.out.println("Please enter the amount you would like to withdraw");
				
				withdraw(Double.valueOf(br.readLine()));

				System.out.println("Current balance is $" + user.getBalance());
				Thread.sleep(3000);
			} catch (IOException ioe) {
				System.out.println("Error occured while reading value. Please try again");
			} catch (InterruptedException e) {
				System.out.println("Error occured. Please try again");
				withdrawMenu();
			} finally {
				anotherTransaction();
			}
		}
	}

	private static void withdraw(Double withdrawal) {
		double balance = user.getBalance();
		user.setBalance((balance - withdrawal > 0.0) ? balance - withdrawal : 0.0);
	}
	
	private static void depositMenu() {
		try {
			System.out.println("Please enter the amount you would like to deposit");
			double amount = Double.valueOf(br.readLine());
			if (amount > 0.0) {
				deposit(amount);
			} else {
				System.out.println("Deposit amount must be greater than zero. Please try again");
				depositMenu();
			}
			System.out.println("Current balance is $" + user.getBalance());
			Thread.sleep(3000);
		} catch (IOException ioe) {
			System.out.println("Error occured while reading value. Please try again");
		} catch (InterruptedException e) {
			System.out.println("Error occured. Please try again");
			anotherTransaction();
		} finally {
			anotherTransaction();
		}
	}

	private static void deposit(Double deposit) {
		double balance = user.getBalance();
		user.setBalance(balance + deposit);
	}
	
	private static void anotherTransaction() {
		try {
			System.out.println("Would you like to make another transaction?");
			System.out.println("[1] Yes, return to account menu.");
			System.out.println("[2] No, logout and end session.");
			
			String input = br.readLine();
			
			switch(input) {
			case "1":
				accountMenu();
				break;
			case "2":
				serializeUser(user);
				System.out.println("Thank you for your business. Have a nice day!");
				Thread.sleep(3000);
				user = null;
				mainMenu();
			default: 
				System.out.println("Invalid input. Your session has been ended.");
				serializeUser(user);
				user = null;
				mainMenu();
			}			
			
		} catch (IOException ioe) {
			System.out.println("Error occured while reading value. Please try again");
		} catch (InterruptedException e) {
			System.out.println("Error occured. Please try again");
			anotherTransaction();
		}
	}
}