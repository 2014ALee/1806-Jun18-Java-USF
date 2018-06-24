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

import com.revature.models.Account;

public class Driver {
	
	private static Account account = null;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		startMenu();
	}
	
	//startMenu and login/register functionality derived from SerializationDriver
	//in day4_demos/src/com/revature/SerializationDriver.java
	//this includes the functions serializeAccount(), usernameAvailable(), and credentialsValid()
	public static void startMenu() {
		String userInput;
		
		System.out.println("+--------------Start Menu--------------+");
		
		System.out.println("[1] - Login");
		System.out.println("[2] - Registration");
		System.out.print("Selection: ");
		
		try {
			userInput = br.readLine();
			
			switch(userInput) {
				case "1":
					System.out.println("Navigating to Login Menu...");
					login();
					break;
				case "2":
					System.out.println("Navigating to Registration Menu");
					register();
					break;
				default:
					System.out.println("Invalid Selection. Please try again.");
					startMenu();
			}
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from file.");
			e.printStackTrace();
		}
	}
	
	public static void register() {
		String username, password, email;
		System.out.println("\n+--------------Registration--------------+");
		
		try {
			System.out.print("User Name: ");
			username = br.readLine();
			
			System.out.print("Password: ");
			password = br.readLine();
			
			System.out.print("Email Address: ");
			email = br.readLine();
			
			account = new Account(username, password, email);
			System.out.println("Checking User Name availabilty");
			
			if(usernameAvailable(account)) {
				System.out.println("Username available!");
				System.out.println("Creating new user, " + account.getUsername() + "...\n");
				serializeAccount(account);
				mainMenu();
			} else {
				System.out.println("Username not available! Please try again.");
				register();
			}
			
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from file.");
			e.printStackTrace();
		}
	}
	
	private static void serializeAccount(Account a) {
		String file = a.getUsername() + ".ser";
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));) {
			oos.writeObject(a);
		} catch (FileNotFoundException e) {
			System.out.println("[LOG] - An error occurred while accessing the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occurred while writing to the file");
			e.printStackTrace();
		}

		file = a.getEmail() + ".ser";
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));) {
			oos.writeObject(a);
		} catch (FileNotFoundException e) {
			System.out.println("[LOG] - An error occurred while accessing the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occurred while writing to the file");
			e.printStackTrace();
		}
		
		
	}
	
	private static boolean usernameAvailable(Account a) {
		
		String fileName = a.getUsername() + ".ser";
		File file = new File(fileName);
		
		if(file.exists()) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void login() {
		System.out.println("\n+--------------Login--------------+");
		String username, password;
		
		try {
			System.out.print("Username/Email: ");
			username = br.readLine();
			
			System.out.print("Password: ");
			password = br.readLine();
			
			if(credentialsValid(username, password)) {
				System.out.println("Login Successful");
				mainMenu();
			} else {
				System.out.println("Login Failed");
				startMenu();
			}
		} catch (IOException e) {
			System.out.println("[LOG] - Error reading from console");
			e.printStackTrace();
		}
	}
	
	private static boolean credentialsValid(String username, String password) {
		
		String file = username + ".ser"; //don't use email
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));) {
			
			account = (Account) ois.readObject();
			
			if(account != null) {
				if((username.equals(account.getUsername()) | username.equals(account.getEmail())) & password.equals(account.getPassword())) {
					return true;
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("[LOG] - An error occurred while accessing the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occurred while writing to the file");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("[LOG] - An error occurred while deserializing an object");
			e.printStackTrace();
		}
		return false;
	}
	
	public static void mainMenu() {
		System.out.println("\n+--------------Main Menu--------------+");
		System.out.println("Welcome: " + account.getUsername() + "\n\n");
		
		String userInput;
		
		System.out.println("[1] - Deposit Money");
		System.out.println("[2] - Withdrawl Money");
		System.out.println("[3] - View Balance");
		System.out.println("[4] - Log Out");
		System.out.print("Selection: ");
		
		try {
			userInput = br.readLine();
			
			switch(userInput) {
				case "1":
					System.out.println("Navigating to Deposit Screen...");
					deposit();
					break;
				case "2":
					System.out.println("Navigating to Withdrawl Screen");
					withdrawl();
					break;
				case "3":
					System.out.println("Navigating to Balance Screen");
					balance();
					break;
				case "4":
					System.out.println("Logging out...");
					logout();
					break;
				default:
					System.out.println("Invalid Selection. Please try again.");
					mainMenu();
			}
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from file.");
			e.printStackTrace();
		}
	}

	private static void logout() {
		account = null;
		clearScreen();
		startMenu();
		
	}

	private static void clearScreen() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	private static void balance() {
		clearScreen();
		System.out.println("\n+--------------" + account.getUsername() + "'s Balance--------------+");
		System.out.println("Your available balance is: " + account.getBalance() + "\n\n");
		
		String userInput;
		
		System.out.println("[1] - Return to Main Menu");
		System.out.println("[2] - Log Out");
		System.out.print("Selection: ");
		try {
			userInput = br.readLine();
			
			switch(userInput) {
				case "1":
					System.out.println("Navigating to Main Menu...");
					clearScreen();
					mainMenu();
					break;
				case "2":
					System.out.println("Logging Out...");
					logout();
					break;
				default:
					System.out.println("Invalid Selection. Please try again.");
					balance();
			}
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from file.");
			e.printStackTrace();
		}
		
	}

	private static void withdrawl() {
		clearScreen();
		System.out.println("\n+--------------" + account.getUsername() + "'s Balance--------------+");
		System.out.println("Your available balance is: " + account.getBalance() + "\n\n");
		
		String userInput;
		double balance;
		
		System.out.print("Enter withdrawl amount: ");
		
		try {
			userInput = br.readLine();
			balance = Double.parseDouble(userInput);
			
			if(balance <= 0.0) {
				clearScreen();
				System.out.println("WITHDRAWL DENIED: $" + balance + " invalid deposit ammount.");
				balance();
			}
			else if(balance > account.getBalance()) {
				clearScreen();
				System.out.println("WITHDRAWL DENIED: $" + balance + " excedes current balance: " + account.getBalance());
				balance();
			} else {
				account.setBalance(account.getBalance() - balance);
				serializeAccount(account);
				System.out.println("Withdrawl Successful");
				System.out.println("New Balance is: " + account.getBalance());
			}
			
			System.out.println("[1] - Return to Main Menu");
			System.out.println("[2] - Log Out");
			System.out.print("Selection: ");
			
			userInput = br.readLine();
			
			switch(userInput) {
				case "1":
					System.out.println("Navigating to Main Menu...");
					clearScreen();
					mainMenu();
					break;
				case "2":
					System.out.println("Logging Out...");
					logout();
					break;
				default:
					System.out.println("Invalid Selection. Please try again.");
					balance();
			}
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from file.");
			e.printStackTrace();
		}
		
	}

	private static void deposit() {
		clearScreen();
		System.out.println("\n+--------------" + account.getUsername() + "'s Balance--------------+");
		System.out.println("Your available balance is: " + account.getBalance() + "\n\n");
		
		String userInput;
		double balance;
		
		System.out.print("Enter deposit amount: ");
		
		try {
			userInput = br.readLine();
			balance = Double.parseDouble(userInput);
			
			if(balance>0.0) {
				account.setBalance(account.getBalance() + balance);
				serializeAccount(account);
				System.out.println("Deposit Successful");
				System.out.println("New Balance is: " + account.getBalance());
			} else {
				clearScreen();
				System.out.println("DEPOST DENIED: $" + balance + " invalid deposit ammount.");
				balance();
			}
			
			System.out.println("[1] - Return to Main Menu");
			System.out.println("[2] - Log Out");
			System.out.print("Selection: ");
			
			userInput = br.readLine();
			
			switch(userInput) {
				case "1":
					System.out.println("Navigating to Main Menu...");
					clearScreen();
					mainMenu();
					break;
				case "2":
					System.out.println("Logging Out...");
					logout();
					break;
				default:
					System.out.println("Invalid Selection. Please try again.");
					balance();
			}
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from file.");
			e.printStackTrace();
		}
		
	}

}
