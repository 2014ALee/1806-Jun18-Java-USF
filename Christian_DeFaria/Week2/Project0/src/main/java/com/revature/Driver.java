package com.revature;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.revature.dao.AccountDAOImpl;
import com.revature.dao.UserDAOImpl;
import com.revature.models.Account;
import com.revature.models.User;

public class Driver {
	public static User user = null;
	public static Account account = null;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static UserDAOImpl userDAO = new UserDAOImpl();
	private static AccountDAOImpl accountDAO = new AccountDAOImpl();
	
	public static void main(String[] args) {
		startMenu();
	}

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
					login("", "");
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

	public static User register() {
		String username, password, email;
		System.out.println("\n+--------------Registration--------------+");
		try {
			System.out.print("User Name: ");
			username = br.readLine();
			
			System.out.print("Password: ");
			password = br.readLine();
			
			System.out.print("Email Address: ");
			email = br.readLine();
			
			user = new User(username, email, password);
			System.out.println("Checking User Name availabilty");
			
			if(!userDAO.usernameExists(user.getUsername())) {
				System.out.println("Username available!");
				if(!userDAO.emailExists(user.getEmail())) {
					System.out.println("Email available!");
					System.out.println("Creating new user, " + user.getUsername() + "...\n");
					user = userDAO.addUser(user);
					account = new Account(true, 0, 0.0);
					account = accountDAO.createAccount(account, user);
					mainMenu();
				} else {
					clearScreen();
					System.out.println("Email not available! Please try again.");
					register();
				}
			} else {
				clearScreen();
				System.out.println("Username not available! Please try again.");
				register();
			}
			
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from file.");
			e.printStackTrace();
		}
		return user;
	}

	public static User login(String u, String p) {
		System.out.println("\n+--------------Login--------------+");
		String username, password;
		
		if(u == "") {
			try {
				System.out.print("Username/Email: ");
				username = br.readLine();
				
				System.out.print("Password: ");
				password = br.readLine();
				
				user = userDAO.getUser(username, password);
				
				if(user!=null) {
					System.out.println("Login Successful");
					account = accountDAO.getAccount(user.getUserID(), true);
					mainMenu();
				} else {
					System.out.println("Login Failed");
					startMenu();
				}
			} catch (IOException e) {
				System.out.println("[LOG] - Error reading from console");
				e.printStackTrace();
			}
		} else {
			username = u;
			password = p;
			
			user = userDAO.getUser(username, password);
			
			if(user!=null) {
				System.out.println("Login Successful");
				account = accountDAO.getAccount(user.getUserID(), true);
			} else {
				System.out.println("Login Failed");
			}
		}
		return user;
	}
	
	public static void mainMenu() {
		System.out.println("\n+--------------Main Menu--------------+");
		System.out.println("Welcome: " + user.getUsername() + "\n\n");
		
		String userInput;
		
		System.out.println("[1] - Deposit Money");
		System.out.println("[2] - Withdrawl Money");
		System.out.println("[3] - View Balance");
		System.out.println("[4] - Create Account");
		System.out.println("[5] - Log Out");
		System.out.print("Selection: ");
		
		try {
			userInput = br.readLine();
			
			switch(userInput) {
				case "1":
					System.out.println("Navigating to Deposit Screen...");
					deposit("");
					break;
				case "2":
					System.out.println("Navigating to Withdrawl Screen");
					withdrawl("");
					break;
				case "3":
					System.out.println("Navigating to Balance Screen");
					balance("");
					break;
				case "4":
					System.out.println("Navigating to Account Creation Sccren");
					createAccount();
					break;
				case "5":
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

	public static void logout() {
		account = null;
		user = null;
		clearScreen();
		startMenu();
		
	}

	public static void clearScreen() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
	}

	public static void createAccount() {
		System.out.println("\n+--------------Account Creation Menu--------------+");
		System.out.println("Welcome: " + user.getUsername() + "\n\n");
		
		String userInput;
		
		System.out.println("[1] - Checking Account");
		System.out.println("[2] - Savings Account");
		System.out.print("Selection: ");
		
		try {
			userInput = br.readLine();
			
			switch(userInput) {
				case "1":
					account = new Account(true, 0, 0.0);
					account = accountDAO.createAccount(account, user);
					balance("");
				case "2":
					account = new Account(false, 0, 0.0);
					account = accountDAO.createAccount(account, user);
					balance("");
				default:
					System.out.println("Invalid Selection. Please try again.");
					createAccount();
			}
			
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from file.");
			e.printStackTrace();
		}
	}

	public static double balance(String data) {
		clearScreen();
		System.out.println("\n+--------------" + user.getUsername() + "'s Balance--------------+");
		System.out.println("Your available balance is: " + account.getBalance() + "\n\n");
		
		if(data == "") {
			String userInput;
			
			System.out.println("[1] - Return to Main Menu");
			System.out.println("[2] - Switch Account");
			System.out.println("[3] - Log Out");
			System.out.print("Selection: ");
			try {
				userInput = br.readLine();
				
				switch(userInput) {
					case "0":
						break;
					case "1":
						System.out.println("Navigating to Main Menu...");
						clearScreen();
						mainMenu();
						break;
					case "2":
						System.out.println("Navigating to Accounts Menu...");
						clearScreen();
						accountsMenu("");
					case "3":
						System.out.println("Logging Out...");
						logout();
						break;
					default:
						System.out.println("Invalid Selection. Please try again.");
						balance("");
				}
			} catch (IOException e) {
				System.out.println("[LOG] - Error while reading from file.");
				e.printStackTrace();
			}
		}
		return account.getBalance();
		
	}

	public static int accountsMenu(String data) {
		System.out.println("\n+--------------Accounts Menu--------------+");
		System.out.println("Welcome: " + user.getUsername() + "\n\n");
		
		if(data == "") {
			String userInput;

			ArrayList<Account> accounts = accountDAO.getAllUserAccounts(user.getUserID());
			int i = 1;

			for(Account a : accounts) {
				System.out.print("[" + i + "] - ");
				if(a.isChecking())
					System.out.print("Checking: ");
				else
					System.out.print("Savings: ");
				System.out.println("#" + a.getAccountId());
				i++;
			}

			System.out.print("Select an account: ");
			try {
				userInput = br.readLine();

				int j = Integer.parseInt(userInput);
				if(j>0 && j<=i) {
					account = accounts.get(j-1);
					System.out.println("Current account changed to:" + account.getAccountId());
					balance("");
				} else {
					clearScreen();
					System.out.println("Invalid Selection. Please try again.");
					accountsMenu("");
				}

			} catch (IOException e) {
				System.out.println("[LOG] - Error while reading from file.");
				e.printStackTrace();
			}
		} else {
			ArrayList<Account> accounts = accountDAO.getAllUserAccounts(user.getUserID());
			return accounts.size();
		}
		return account.getAccountId();
	}

	public static double withdrawl(String data) {
		clearScreen();
		System.out.println("\n+--------------" + user.getUsername() + "'s Balance--------------+");
		System.out.println("Your available balance is: " + account.getBalance() + "\n\n");
		
		if(data == "") {
			String userInput;
			double balance;

			System.out.print("Enter withdrawl amount: ");

			try {
				userInput = br.readLine();
				if(userInput.indexOf('.') != -1 && userInput.indexOf('.') < (userInput.length()-2))
					userInput = userInput.substring(0, (userInput.indexOf('.')+1));
				balance = Double.parseDouble(userInput);

				if(balance <= 0.0) {
					System.out.println("WITHDRAWL DENIED: $" + balance + " invalid deposit ammount.");
					balance("");
				}
				else if(balance > account.getBalance()) {
					System.out.println("WITHDRAWL DENIED: $" + balance + " excedes current balance: " + account.getBalance());
					balance("");
				} else {
					account.setBalance(account.getBalance() - balance);
					accountDAO.updateAccountBalance(account);
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
						balance("");
				}
			} catch (IOException e) {
				System.out.println("[LOG] - Error while reading from file.");
				e.printStackTrace();
			}
		}
		return account.getBalance();
		
	}

	public static double deposit(String data) {
		clearScreen();
		System.out.println("\n+--------------" + user.getUsername() + "'s Balance--------------+");
		System.out.println("Your available balance is: " + account.getBalance() + "\n\n");
		
		String userInput;
		double balance;
		if(data == "") {
			System.out.print("Enter deposit amount: ");

			try {
				userInput = br.readLine();
				if(userInput.indexOf('.') != -1 && userInput.indexOf('.') < (userInput.length()-2))
					userInput = userInput.substring(0, (userInput.indexOf('.')+1));
				balance = Double.parseDouble(userInput);

				if(balance>0) {
					account.setBalance(account.getBalance() + balance);
					accountDAO.updateAccountBalance(account);
					System.out.println("Deposit Successful");
					System.out.println("New Balance is: " + account.getBalance());
				} else {
					//clearScreen();
					System.out.println("DEPOST DENIED: $" + balance + " invalid deposit ammount.");
					balance("");
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
						balance("");
				}
			} catch (IOException e) {
				System.out.println("[LOG] - Error while reading from file.");
				e.printStackTrace();
			}
		}
		return account.getBalance();
		
	}
	
	public void setUser(User u) {
		user = u;
	}
	
	public void setAccount(Account a) {
		account = a;
	}

}
