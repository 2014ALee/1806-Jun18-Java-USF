package com.revature.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pages {

	//mainMenu
	//register
	//login
	//home
	//deposit
	//withdraw
	//transfer
	//viewBalance
	//newAccount

	// create a User object to serialize, deserialize, and manipulate user data
	public static User user = null;

	// create a BufferedReader to read user input
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static Pages page = new Pages();

	public void mainMenu() {
		// string to store user input
		String userInput;

		System.out.println("\n-------------MAIN MENU-------------");

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

	public void register() {

		// Strings to store user input for User object
		String firstName, lastName, username, password, email;

		System.out.println("\n-----------REGISTRATION------------");

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

			// fill in user object
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);

			// check username availability
			if (Validate.usernameAvailable(user)) {
				// username available
				// create new user
				Serialize.serializeUser(user);
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

	public void login() {

		String username, password;

		System.out.println("\n---------------LOGIN---------------");

		try {

			System.out.print("Username: ");
			username = br.readLine();

			System.out.print("Password: ");
			password = br.readLine();

			if (Validate.credentialsValid(username, password, user)) {
				// login successful
				// go to home page after successful login
				//user object is already deserialized and set to user from the credentialsValid() method
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

	public void homePage() {

		// string to store user input
		String userInput;

		System.out.println("\n-------------HOME PAGE-------------");

		System.out.println("[1] - Deposit");
		System.out.println("[2] - Withdraw");
		System.out.println("[3] - View Balance");
		System.out.println("[4] - Transfer Funds");
		System.out.println("[5] - Create New Account");
		System.out.println("[6] - Logout");
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
				transferFunds();
				break;
			case "5":
				createNewAccount();
				break;
			case "6":
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

	public void deposit() {

		double amountToDeposit = 0d;
		String userInput = "";
		//variable to set which account the user chose to deposit to
		String accountChosen = "";

		System.out.println("\n--------------DEPOSIT--------------");
		System.out.println("Which account would you like to Deposit to?");		
		System.out.println("[1] - Checking");
		System.out.println("[2] - Savings");
		System.out.println("[3] - Joint");
		System.out.println("[4] - Back to Home Page");
		try {
			// get user input from which account to deposit to
			userInput = br.readLine();

			//make sure the user actually has the type of account they're trying to deposit to
			switch (userInput) {
			case "1":
				if(user.getHasCheckingAccount()) {
					accountChosen = "Checking";
				}
				else {
					System.out.println("You don't have a Checking account!  Please try again");
					deposit();
				}
				break;
			case "2":
				if (user.getHasSavingsAccount()) {
					accountChosen = "Savings";
				}else {
					System.out.println("You don't have a Savings account!  Please try again");
					deposit();
				}
				break;
			case "3":
				if(user.getHasJointAccount()) {
					accountChosen = "Joint";
				}else {
					System.out.println("You don't have a Joint account!  Please try again");
					deposit();
				}
				break;
			case "4":
				homePage();
				break;
			default:
				System.out.println("Invalid selection, please try again!\n");
				// back to home page
				deposit();
			}

		} catch (IOException ioe) {
			System.out.println("An error occured with your selection");
			// e.printStackTrace();
			homePage();
		}

		System.out.print("How much would you like to deposit? ");
		try {

			// put the users input into the amount to deposit
			amountToDeposit = Double.parseDouble(br.readLine());
			if (amountToDeposit < 0) {
				System.out.println("Please enter a valid number\n");
				deposit();
			}

			// check if the user is sure they want to deposit
			String userDepositInput = "";

			System.out.println("Are you sure you want to deposit " + amountToDeposit + " to your " + accountChosen + " account?");
			System.out.println("[1] - Yes");
			System.out.println("[2] - No");
			System.out.print("Selection: ");
			try {
				// get user input from deposit
				userDepositInput = br.readLine();

				switch (userDepositInput) {
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
			if(accountChosen == "Checking") {
				user.setCheckingBalance(user.getCheckingBalance() + amountToDeposit);
			}else if(accountChosen == "Savings"){
				user.setSavingsBalance(user.getSavingsBalance() + amountToDeposit);
			}else {
				user.setJointBalance(user.getJointBalance() + amountToDeposit);
			}


			System.out.println("Deposit successful!  You deposited $" + amountToDeposit + " into your " + accountChosen + " account!" );
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

	public void withdraw() {

		double amountToWithdraw = 0d;
		String userInput = "";
		String accountChosen = "";

		System.out.println("\n-------------Withdraw--------------");
		System.out.println("Which account would you like to Withdraw from?");		
		System.out.println("[1] - Checking");
		System.out.println("[2] - Savings");
		System.out.println("[3] - Joint");
		System.out.println("[4] - Back to Home Page");

		try {
			// get user input from which account to withdraw from
			userInput = br.readLine();

			//make sure the user actually has the type of account they're trying to withdraw from
			switch (userInput) {
			case "1":
				if(user.getHasCheckingAccount()) {
					accountChosen = "Checking";
				}
				else {
					System.out.println("You don't have a Checking account!  Please try again");
					withdraw();
				}
				break;
			case "2":
				if (user.getHasSavingsAccount()) {
					accountChosen = "Savings";
				}else {
					System.out.println("You don't have a Savings account!  Please try again");
					withdraw();
				}
				break;
			case "3":
				if(user.getHasJointAccount()) {
					accountChosen = "Joint";
				}else {
					System.out.println("You don't have a Joint account!  Please try again");
					withdraw();
				}
				break;
			case "4":
				homePage();
				break;
			default:
				System.out.println("Invalid selection, please try again!\n");
				// back to home page
				withdraw();
			}

		} catch (IOException ioe) {
			System.out.println("An error occured with your selection");
			// e.printStackTrace();
			homePage();
		}

		System.out.print("How much would you like to Withdraw? ");
		try {


			// put the users input into the amount to withdraw
			amountToWithdraw = Double.parseDouble(br.readLine());
			if (amountToWithdraw <= 0) {
				System.out.println("Please enter a valid number\n");
				withdraw();
			}

			// check if the user is sure they want to withdraw
			String userWithdrawalInput = "";

			System.out.println("Are you sure you want to withdraw " + amountToWithdraw + " from your " + accountChosen + " account?");
			System.out.println("[1] - Yes");
			System.out.println("[2] - No");
			System.out.print("Selection: ");
			try {
				// get user input from logout
				userWithdrawalInput = br.readLine();

				switch (userWithdrawalInput) {
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


			// subtract the amount of withdrawal from the users current balance
			if(accountChosen == "Checking") {
				//withdraw the money as long as it doesn't take the account into the negatives
				if ((user.getCheckingBalance() - amountToWithdraw) >= 0) {
					user.setCheckingBalance(user.getCheckingBalance() - amountToWithdraw);
				} else {
					// cant withdraw that much
					System.out.println("Your balance is too low to withdraw " + amountToWithdraw + ", please try again");
					withdraw();
				}

			}else if(accountChosen == "Savings"){

				//withdraw the money as long as it doesn't take the account into the negatives
				if ((user.getSavingsBalance() - amountToWithdraw) >= 0) {
					user.setSavingsBalance(user.getSavingsBalance() - amountToWithdraw);
				} else {
					// cant withdraw that much
					System.out.println("Your balance is too low to withdraw " + amountToWithdraw + ", please try again");
					withdraw();
				}

			}else {//account chosen == "Joint"

				//withdraw the money as long as it doesn't take the account into the negatives
				if ((user.getJointBalance() - amountToWithdraw) >= 0) {
					user.setJointBalance(user.getJointBalance() - amountToWithdraw);
				} else {
					// cant withdraw that much
					System.out.println("Your balance is too low to withdraw " + amountToWithdraw + ", please try again");
					withdraw();
				}

			}

			System.out.println("Withdrawal successful!  You withdrew $" + amountToWithdraw + " from your " + accountChosen + " account!");
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

	public void transferFunds() {

		System.out.println("This feature is not yet available, please try again later.");
		homePage();
	}

	public void viewBalance() {

		String userInput;

		System.out.println("\n-----------VIEW BALANCE------------");
		if (user.getHasCheckingAccount()) {
			System.out.println("Your current Checking Account balance is: " + user.getCheckingBalance());
		}
		if (user.getHasSavingsAccount()) {
			System.out.println("Your current Savings Account balance is: " + user.getSavingsBalance());
		}
		if (user.getHasJointAccount()) {
			System.out.println("Your current Joint Account balance is: " + user.getJointBalance());
		}		
		System.out.println("-----------------------------------");
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

	public void createNewAccount() {

		// string to store user input
		String userInput;
		String accountType = "";
		System.out.println("\n-------------Create New Account-------------");
		System.out.println("What type of account would you like to open?");
		System.out.println("[1] - Checking");
		System.out.println("[2] - Savings");
		System.out.println("[3] - Joint");
		System.out.println("[4] - Back to Home Page");
		System.out.print("Selection: ");

		try {
			// get user input from home page
			userInput = br.readLine();

			switch (userInput) {
			case "1":
				if(!user.getHasCheckingAccount()) {
					accountType = "Checking";
				}
				else {
					System.out.println("You already have a Checking account!  Please try again");
					createNewAccount();
				}
				break;
			case "2":
				if(!user.getHasSavingsAccount()) {
					accountType = "Savings";
				}
				else {
					System.out.println("You already have a Savings account!  Please try again");
					createNewAccount();
				}
				break;
			case "3":
				if(!user.getHasJointAccount()) {
					accountType = "Joint";
				}
				else {
					System.out.println("You already have a Joint account!  Please try again");
					createNewAccount();
				}
				break;
			case "4":
				//back to home
				homePage();
				break;
			default:
				System.out.println("Invalid selection, please try again!\n");
				// back to home page
				createNewAccount();
			}

		} catch (IOException ioe) {
			System.out.println("An error occured with your selection");
			// e.printStackTrace();
			homePage();
		}


		// check if the user is sure they want to open a new account
		String userConfirmationInput = "";

		System.out.println("Are you sure you want to open a new " + accountType + " account?");
		System.out.println("[1] - Yes");
		System.out.println("[2] - No");
		System.out.print("Selection: ");
		try {
			// get user input from logout
			userConfirmationInput = br.readLine();

			switch (userConfirmationInput) {
			case "1":
				// user wants to create account, break switch
				break;
			case "2":
				// user doesnt want to create account, return to create account screen
				createNewAccount();
				break;
			default:
				System.out.println("Invalid selection, please try again!\n");
				// back to create account
				createNewAccount();
			}

		} catch (IOException ioe) {
			System.out.println("Invalid selection, please try again!\n");
			// e.printStackTrace();
			createNewAccount();
		}

		if(accountType == "Checking"){
			//create checking account
			user.setHasCheckingAccount(true);
			homePage();
		}else if(accountType == "Savings"){
			//create savings account
			user.setHasSavingsAccount(true);
			homePage();
		}else {		
			//create joint account
			user.setHasJointAccount(true);
			//get joint user info
			try {

				// get user input to fill in joint user info
				String firstName, lastName, username, password, email;

				System.out.print("First name of Joint member: ");
				firstName = br.readLine();

				System.out.print("Last name of Joint member: ");
				lastName = br.readLine();

				System.out.print("Username of Joint member: ");
				username = br.readLine();

				System.out.print("Password of Joint member: ");
				password = br.readLine();

				System.out.print("Email Address of Joint member: ");
				email = br.readLine();

				User jointUser = new User();
				jointUser.setJointFirstName(firstName);
				jointUser.setJointLastName(lastName);
				jointUser.setJointUsername(username);
				jointUser.setJointPassword(password);
				jointUser.setJointEmail(email);
				homePage();
			} catch (IOException ioe) {
				// System.out.println("[LOG] - Error while reading from console");
				// e.printStackTrace();
				mainMenu();
			}
		}

	}

	public void logout() {

		String userInput;

		System.out.println("\n---------------LOGOUT--------------");
		System.out.println("Are you sure you want to log out?");
		System.out.println("[1] - Yes");
		System.out.println("[2] - No");
		System.out.print("Selection: ");
		try {
			// get user input from logout
			userInput = br.readLine();

			switch (userInput) {
			case "1":
				// re serialization here before logout to store the user object back in the file			
				Serialize.serializeUser(user);
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
