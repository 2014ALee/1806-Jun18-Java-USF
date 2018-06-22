package bank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import bank.models.User;

public class BankDriver {

	public static final String USERS_FILENAME = "userFilenames.ser";

	private static User user = null;
	private static ArrayList<User> users = new ArrayList<>();
	private static Scanner scan = new Scanner(System.in);
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		initializeUsers();
		mainMenu();
	}

	private static void initializeUsers() {
		// Deserialize the user data from the files

		// First we get the filenames for all of the users
		ArrayList<String> userFileNames = new ArrayList<>();
		if(new File(USERS_FILENAME).exists())
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILENAME))){
				userFileNames = (ArrayList<String>) ois.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		// Then we deserialize each user and put them into the users list
		for(String fileName : userFileNames) {
			if(new File(fileName).exists())
				try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
					users.add((User) ois.readObject());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
		}
	}

	private static void mainMenu() {
		String input;

		System.out.println("\n+-------------------- MAIN MENU --------------------+");

		System.out.println("[1] - Login");
		System.out.println("[2] - Register");
		System.out.println("[3] - Exit");
		System.out.print("\n:> ");

		input = scan.nextLine();

		switch(input) {
		case "1":
			login();
			break;
		case "2":
			register();
			break;
		case "3":
			System.out.println("Goodbye");
			break;
		default:
			System.out.println("Invalid input. Please try again.");
			mainMenu();
		}
	}

	private static void accountMenu() {
		String input;

		System.out.println("\n+-------------------- ACCOUNT MENU --------------------+");

		System.out.println("[1] - View Balance");
		System.out.println("[2] - Deposit");
		System.out.println("[3] - Withdraw");
		System.out.println("[4] - Transfer Funds");
		System.out.println("[5] - Change Password");
		System.out.println("[6] - Logout");
		System.out.print("\n:> ");

		try {
			input = br.readLine();

			switch(input) {
			case "1":
				viewBalance();
				accountMenu();
				break;
			case "2":
				deposit();
				break;
			case "3":
				withdraw();
				break;
			case "4":
				transfer();
				break;
			case "5":
				changePassword();
				break;
			case "6":
				logout();
				break;
			default:
				System.out.println("Invalid input. Please try again.");
				accountMenu();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void login() {
		String username, password;

		System.out.println("\n+-------------------- LOGIN --------------------+");

		try {
			System.out.print("Username :> ");
			username = br.readLine();

			System.out.print("Password :> ");
			password = br.readLine();

			User u;
			// If the user exists and the password is correct
			if((u = getUserByUsername(username)) != null & password.equals(u.getPassword())) {
				user = u;
				System.out.println("Login Successful!");
				accountMenu();
			} else {
				System.out.println("Login Unsuccessful");
				mainMenu();
			}

			//			if(usernameExists(username)) {
			//				
			//				String fileName = username + ".ser";
			//				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			//
			//					User u = (User) ois.readObject();
			//
			//					if(password.equals(u.getPassword())) {
			//						user = u;
			//						System.out.println("Login Successful!");
			//						accountMenu();
			//					} else {
			//						System.out.println("Login Unsuccessful");
			//						mainMenu();
			//					}
			//
			//				} catch (FileNotFoundException e) {
			//					System.out.println("I just checked that the file exists in the if statement above. How did manage to get here?");
			//					e.printStackTrace();
			//				} catch (IOException e) {
			//					System.out.println("Something went badly wrong");
			//					e.printStackTrace();
			//				} catch (ClassNotFoundException e) {
			//					System.out.println("Something went VERY badly wrong");
			//					e.printStackTrace();
			//				}
			//			} else {
			//				System.out.println("Login Unsuccessful");
			//				mainMenu();
			//			}
		} catch (IOException ioe) {
			System.out.println("Invalid input. Please try again.");
			login();
		}

	}

	private static void register() {
		String username, email, password;

		System.out.println("\n+-------------------- REGISTER --------------------+");

		try {
			System.out.print("Username :> ");
			username = br.readLine();

			System.out.print("Password :> ");
			password = br.readLine();

			System.out.print("Email Address :> ");
			email = br.readLine();

			if(getUserByUsername(username) == null) {
				user = new User(username, password, email, 100.0);
				users.add(user);
				System.out.println("Registration Successful");
				serializeUser(user);
				serializeUserFileNames();
				accountMenu();
			} else {
				System.out.println("A user with that username already exists.");
				mainMenu();
			}

			//			if(!usernameExists(username)) {
			//				user = new User(username, password, email, 100.0);
			//				System.out.println("Registration Successful");
			//				serializeUser(user);
			//				accountMenu();
			//			} else {
			//				System.out.println("A user with that username already exists. Please try again.");
			//				register();
			//			}
		} catch (IOException ioe) {
			System.out.println("Invalid input. Please try again.");
			register();
		}
	}

	private static void serializeUserFileNames() {
		ArrayList<String> userFileNames = new ArrayList<>();
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILENAME))){
			for(User u : users)
				userFileNames.add(u.getUsername() + ".ser");
			oos.writeObject(userFileNames);
		} catch (FileNotFoundException e) {
			System.out.println("{LOG} - An error occured while attempting to access the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("{LOG} - An error occured while attempting to write to the file");
			e.printStackTrace();
		}
	}

	private static void serializeUser(User u) {
		String fileName = u.getUsername() + ".ser";
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(u);
		} catch (FileNotFoundException e) {
			System.out.println("{LOG} - An error occured while attempting to access the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("{LOG} - An error occured while attempting to write to the file");
			e.printStackTrace();
		}
	}

	private static void logout() {
		user = null;
		mainMenu();
	}

	private static void changePassword() {
		String password;

		System.out.println("\n+-------------------- CHANGE PASSWORD --------------------+");

		try {
			System.out.print("Old password :> ");
			password = br.readLine();

			if(password.equals(user.getPassword())) {
				System.out.print("New password :> ");
				password = br.readLine();

				user.setPassword(password);
				serializeUser(user);
				System.out.println("Password changed");
			} else
				System.out.println("Incorrect password");
			accountMenu();
		} catch (IOException ioe) {
			System.out.println("Invalid input. Please try again.");
			changePassword();
		}
	}

	private static void withdraw() {
		double input;

		System.out.println("\n+-------------------- WITHDRAW --------------------+");

		viewBalance();
		System.out.print("Amount to withdraw :> ");

		try {
			input = Double.parseDouble(br.readLine());

			if(user.getBalance() - input < 0) {
				System.out.println("Amount specified exceeds available funds.\nCannot overdraw.");
			} else if(input < 0) {
				System.out.println("Cannot withdraw negative funds.");
			} else {
				user.setBalance(user.getBalance() - input);
				serializeUser(user);
				System.out.printf("Withdrawal complete. New balance is $%.2f\n", user.getBalance());
			}
			accountMenu();
		} catch (Exception e) {
			System.out.println("Invalid input. Please try again.");
			withdraw();
		}

	}

	private static void deposit() {
		double amount;

		System.out.println("\n+-------------------- DEPOSIT --------------------+");

		viewBalance();
		System.out.print("Amount to deposit :> ");

		try {
			amount = Double.parseDouble(br.readLine());

			// Check that they entered a positive number
			if(amount < 0) 
				System.out.println("Invalid input. Cannot deposit negative funds.");
			else {
				// Set the new balance and save changes
				user.setBalance(user.getBalance() + amount);
				serializeUser(user);
				System.out.printf("Deposit complete. New balance is $%.2f\n", user.getBalance());
			}
			
			accountMenu();
		} catch (Exception e) {
			System.out.println("Invalid input. Please try again.");
			deposit();
		}

	}

	private static void viewBalance() {
		System.out.printf("Current balance $%.2f\n", user.getBalance());
	}

	private static void transfer() {
		// Allow the user to transfer funds from their own account to another user's account
		// Get a list of the available users
		int userSelection;
		double amount;

		System.out.println("\n+-------------------- TRANSFER --------------------+");

		// Exclude the current user
		ArrayList<User> transferUsers = new ArrayList<>();
		transferUsers.addAll(users);
		transferUsers.remove(user);
		int i;
		for(i = 0; i < transferUsers.size(); i++) {
			System.out.println("[" + (i+1) + "] - " + transferUsers.get(i).getUsername());
		}
		System.out.println("[" + (i+1) + "] - Cancel");
		System.out.print("User to transfer funds to :> ");

		try {
			userSelection = Integer.parseInt(br.readLine());
			userSelection--;	// Array indices start at 0

			// If they didn't select cancel
			if(userSelection != i) {
				// If they actually selected a user
				if(userSelection >= 0 && userSelection < transferUsers.size()) {
					System.out.print("Amount to transfer :> ");
					amount = Double.parseDouble(br.readLine());

					// Check if they're transferring a legal amount
					if(amount < 0)
						System.out.println("Invalid input. Cannot transfer negative funds.");
					if(amount > user.getBalance())
						System.out.println("Invalid input. Transfer amount cannot exceed current balance.");

					// Get the selected user
					User transferUser = transferUsers.get(userSelection);

					// Set the balances of the users
					user.setBalance(user.getBalance() - amount);
					transferUser.setBalance(transferUser.getBalance() + amount);

					// And save
					serializeUser(user);
					serializeUser(transferUser);

					System.out.printf("Transfer complete. New balance is $%.2f\n", user.getBalance());
				} else {
					System.out.println("Invalid input. Please try again.");
					transfer();
				}
			}
		} catch (IOException e) {
			System.out.println("Invalid input. Please try again.");
			transfer();
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid input. Please try again.");
			transfer();
		}

		accountMenu();
	}

	private static boolean usernameExists(String username) {
		for(User u : users)
			if(username.equals(u.getUsername()))
				return true;
		return false;
	}

	private static User getUserByUsername(String username) {
		// Returns the user if they exist. Else returns null
		for(User u : users)
			if(username.equals(u.getUsername()))
				return u;
		return null;
	}
}
