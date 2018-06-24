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
import java.text.DecimalFormat;

import com.revature.models.User;

public class Driver {

	// create a User object to store user data
	private static User user = null;
	// create a BufferedReader to read user input
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {

		mainMenu();

	}

	private static void mainMenu() {

		// string to store user input
		String userInput;

		System.out.println("+--------------MAIN MENU--------------+");

		System.out.println("[1] - Login");
		System.out.println("[2] - Register");
		System.out.println("[3] - Exit");
		System.out.print("Selection: ");

		try {
			// get user input from main menu
			userInput = br.readLine();

			switch (userInput) {
			case "1":
				login();
				break;
			case "2":
				register();
				break;
			case "3":
				System.exit(0);
			default:
				System.out.println("Invalid selection, please try again!\n");
				// back to main menu
				mainMenu();
			}

		} catch (IOException ioe) {
			// System.out.println("[LOG] - Error while reading from console");
			// e.printStackTrace();
			mainMenu();
		}

	}

	private static void register() {

		// Strings to store user input for User object
		String firstName, lastName, username, password, email;

		System.out.println("\n+--------------REGISTRATION--------------+");

		try {

			// get user input to make User object
			System.out.print("First name: ");
			firstName = br.readLine();

			System.out.print("Last name: ");
			lastName = br.readLine();

			System.out.print("Username: ");
			username = br.readLine();

			System.out.print("Password: ");
			password = br.readLine();

			System.out.print("Email Address: ");
			email = br.readLine();

			// create new User object
			user = new User(firstName, lastName, username, password, email);

			// check username availability
			if (usernameAvailable(user)) {
				// username available
				// create new user
				serializeUser(user);
				mainMenu();
			} else {
				System.out.println("Username is not available. Please try again...");
				register();
			}

		} catch (IOException ioe) {
			// System.out.println("[LOG] - Error while reading from console");
			// e.printStackTrace();
			mainMenu();
		}

	}

	// check if the username is available by comparing the user input to the
	// serialized file names
	private static boolean usernameAvailable(User u) {

		String fileName = u.getUsername() + ".ser";
		File file = new File(fileName);

		if (file.exists()) {
			return false;
		} else {
			return true;
		}
	}

	// store the User object into the text file if they're registering with a valid username
	private static void serializeUser(User u) {

		// create a string to name the users file according to username
		String fileName = u.getUsername() + ".ser";

		// try with resources to autoclose after the try/catch
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			// Write the specified object to the ObjectOutputStream.
			oos.writeObject(u);

		} catch (FileNotFoundException fnfe) {
			// System.out.println("[LOG] - An error occurred while accessing the file");
			// e.printStackTrace();
			mainMenu();
		} catch (IOException ioe) {
			// System.out.println("[LOG] - An error occurred while writing the file");
			// e.printStackTrace();
			mainMenu();
		}
	}

	private static void login() {

		String username, password;

		System.out.println("\n+--------------LOGIN--------------+");

		try {

			System.out.print("Username: ");
			username = br.readLine();

			System.out.print("Password: ");
			password = br.readLine();

			if (credentialsValid(username, password)) {
				// login successful
				// get users serialized object from file and store it in User object to access
				// and modify its variables as needed
				String fileName = username + ".ser";

				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

					user = (User) ois.readObject();

				} catch (FileNotFoundException fnfe) {
					System.out.println("An error occurred while logging in");
					// e.printStackTrace();
					mainMenu();
				} catch (IOException ioe) {
					System.out.println("An error occurred while logging in");
					// e.printStackTrace();
					mainMenu();
				} catch (ClassNotFoundException cnfe) {
					System.out.println("An error occurred while logging in");
					// e.printStackTrace();
					mainMenu();
				}
				// go to home page after successful login
				homePage();

				return;
			} else {
				System.out.println("Login failed!\n");
				mainMenu();
			}

		} catch (IOException ioe) {
			// System.out.println("[LOG] - Error while reading from console");
			// e.printStackTrace();
			mainMenu();
		}
	}

	private static boolean credentialsValid(String username, String password) {

		String fileName = username + ".ser";

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

			user = (User) ois.readObject();

			if (user != null) {

				if (username.equals(user.getUsername()) & password.equals(user.getPassword())) {
					return true;
				}
			}

		} catch (FileNotFoundException fnfe) {
			System.out.println("An error occurred while logging in");
			// e.printStackTrace();
			mainMenu();
		} catch (IOException ioe) {
			System.out.println("An error occurred while logging in");
			// e.printStackTrace();
			mainMenu();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("An error occurred while logging in");
			// e.printStackTrace();
			mainMenu();
		}

		return false;
	}

	private static void homePage() {

		// string to store user input
		String userInput;

		System.out.println("+--------------HOME PAGE--------------+");

		System.out.println("[1] - Deposit");
		System.out.println("[2] - Withdraw");
		System.out.println("[3] - View Balance");
		System.out.println("[4] - Logout");
		System.out.print("Selection: ");

		try {
			// get user input from home page
			userInput = br.readLine();

			switch (userInput) {
			case "1":
				deposit();
				break;
			case "2":
				withdraw();
				break;
			case "3":
				viewBalance();
				break;
			case "4":
				logout();
				break;
			default:
				System.out.println("Invalid selection, please try again!\n");
				// back to home page
				homePage();
			}

		} catch (IOException ioe) {
			System.out.println("An error occured with your selection");
			// e.printStackTrace();
			homePage();
		}

	}

	private static void deposit() {

		Double amountToDeposit = 0d;

		System.out.println("+-------------------DEPOSIT--------------------+");
		System.out.print("How much would you like to deposit? ");
		try {

			// put the users input into the amount to deposit
			amountToDeposit = Double.parseDouble(br.readLine());
			if (amountToDeposit < 0) {
				System.out.println("Please enter a valid number\n");
				deposit();
			}

			// check if the user is sure they want to deposit
			String userInput = "";

			System.out.println("Are you sure you want to deposit " + amountToDeposit + "?");
			System.out.println("[1] - Yes");
			System.out.println("[2] - No");
			System.out.print("Selection: ");
			try {
				// get user input from deposit
				userInput = br.readLine();

				switch (userInput) {
				case "1":
					// user wants to deposit, break switch
					break;
				case "2":
					// user doesnt want to deposit, return to home
					homePage();
					break;
				default:
					System.out.println("Invalid selection, please try again!\n");
					// back to deposit
					deposit();
				}

			} catch (IOException ioe) {
				System.out.println("Invalid selection, please try again!\n");
				// e.printStackTrace();
				deposit();
			}

			// add the amount of deposit to the users current balance
			user.setBalance(user.getBalance() + amountToDeposit);

			System.out.println("Deposit successful!  You deposited $" + amountToDeposit);
			homePage();

		} catch (NumberFormatException nfe) {
			System.out.println("Please enter a valid number");
			deposit();
			// nfe.printStackTrace();
		} catch (IOException ie) {
			System.out.println("Please enter a valid number");
			deposit();
			// ie.printStackTrace();
		}
	}

	private static void withdraw() {
		Double amountToWithdraw = 0d;

		System.out.println("+-------------------Withdraw--------------------+");
		System.out.print("How much would you like to withdraw? ");
		try {


			// put the users input into the amount to withdraw
			amountToWithdraw = Double.parseDouble(br.readLine());
			if (amountToWithdraw < 0) {
				System.out.println("Please enter a valid number\n");
				withdraw();
			}

			// check if the user is sure they want to withdraw
			String userInput = "";

			System.out.println("Are you sure you want to withdraw " + amountToWithdraw + "?");
			System.out.println("[1] - Yes");
			System.out.println("[2] - No");
			System.out.print("Selection: ");
			try {
				// get user input from logout
				userInput = br.readLine();

				switch (userInput) {
				case "1":
					// user wants to withdraw, break switch
					break;
				case "2":
					// user doesnt want to withdraw, return to home
					homePage();
					break;
				default:
					System.out.println("Invalid selection, please try again!\n");
					// back to withdraw
					withdraw();
				}

			} catch (IOException ioe) {
				System.out.println("Invalid selection, please try again!\n");
				// e.printStackTrace();
				withdraw();
			}

			// make sure the withdrawal wont bring user balance into the negative
			if ((user.getBalance() - amountToWithdraw) >= 0) {

				// deduct the amount from the users current balance
				user.setBalance(user.getBalance() - amountToWithdraw);

			} else {
				// cant withdraw that much
				System.out.println("Your balance is too low to withdraw " + amountToWithdraw + ", please try again");
				withdraw();
			}

			System.out.println("Withdrawal successful!  You withdrew $" + amountToWithdraw);
			homePage();

		} catch (NumberFormatException nfe) {
			System.out.println("Please enter a valid number");
			withdraw();
			// nfe.printStackTrace();
		} catch (IOException ie) {
			System.out.println("Please enter a valid number");
			withdraw();
			//ie.printStackTrace();
		}
	}

	private static void viewBalance() {

		String userInput;

		System.out.println("+-------------------VIEW BALANCE--------------------+");
		System.out.println("Your current balance is: " + user.getBalance());
		System.out.println("----------------------------------------------------");
		System.out.println("[1] - Back to Home Page");
		System.out.println("[2] - Logout");
		System.out.print("Selection: ");

		try {
			// get user input from view balance
			userInput = br.readLine();

			switch (userInput) {
			case "1":
				homePage();
				break;
			case "2":
				logout();
				break;
			default:
				System.out.println("Invalid selection, please try again!\n");
				// back to view balance
				viewBalance();

			}

		} catch (IOException ioe) {
			System.out.println("An error occured with your selection");
			// e.printStackTrace();
			homePage();
		}
	}

	private static void logout() {

		String userInput;

		System.out.println("+--------------LOGOUT--------------+");
		System.out.println("Are you sure you want to log out?");
		System.out.println("[1] - Yes");
		System.out.println("[2] - No");
		System.out.print("Selection: ");
		try {
			// get user input from logout
			userInput = br.readLine();

			switch (userInput) {
			case "1":
				// re serialization here before logout
				// create a string to name the users file according to username
				String fileName = user.getUsername() + ".ser";

				// try with resources to autoclose after the try/catch
				try (FileOutputStream fos = new FileOutputStream(fileName);
						ObjectOutputStream oos = new ObjectOutputStream(fos);) {

					// Write the specified object to the ObjectOutputStream.
					oos.writeObject(user);

				} catch (FileNotFoundException fnfe) {
					// System.out.println("[LOG] - An error occurred while accessing the file");
					// e.printStackTrace();
					mainMenu();
				} catch (IOException ioe) {
					// System.out.println("[LOG] - An error occurred while writing the file");
					// e.printStackTrace();
					mainMenu();
				}

				mainMenu();
				break;
			case "2":
				homePage();
				break;
			default:
				System.out.println("Invalid selection, please try again!\n");
				// back to logout
				logout();
			}

		} catch (IOException ioe) {
			System.out.println("An error occured while trying to log out");
			// e.printStackTrace();
			homePage();
		}

	}
}
