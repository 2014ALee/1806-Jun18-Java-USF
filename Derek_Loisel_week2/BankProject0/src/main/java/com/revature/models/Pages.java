package com.revature.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.JointAccountDAO;
import com.revature.dao.JointAccountDAOImpl;
import com.revature.dao.UsersDAO;
import com.revature.dao.UsersDAOImpl;

public class Pages{

	// create a User object to store manipulate user data
	private static User user = null;

	// create a BufferedReader to read user input
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
				loginPage();
				break;
			case "2":
				registrationPage();
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

	public void registrationPage() {

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
			if (Validation.usernameAndEmailAvailable(user)) {
				// username available, create new user and 

				// create new user in database
				UsersDAO usersDAO = new UsersDAOImpl();
				User u = usersDAO.addUser(user);

				//add account record to database for user
				AccountDAO accountDAO = new AccountDAOImpl();
				Account account = new Account();
				// set the users pk as the accounts fk
				account.setUserID(u.getUserID());
				Account accountObj = accountDAO.addAccount(account);

				// go back to main menu
				mainMenu();
			} else {
				System.out.println("Username is not available. Please try again...");
				registrationPage();
			}

		} catch (IOException ioe) {
			// System.out.println("[LOG] - Error while reading from console");
			// e.printStackTrace();
			mainMenu();
		}
	}

	public void loginPage() {

		String username, password;

		System.out.println("\n---------------LOGIN---------------");
		try {

			System.out.print("Username: ");
			username = br.readLine();
			System.out.print("Password: ");
			password = br.readLine();

			if (Validation.credentialsValid(username, password)) {
				// login successful
				System.out.println("Login Successful!");
				// set the class scoped static user object username so it's available after
				// login
				user = new User();
				user.setUsername(username);
				// go to home page after successful login
				homePage();

				return;
			} else {
				System.out.println("Login failed!\n");
				// back to main menu after failed login
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
				depositPage();
				break;
			case "2":
				withdrawPage();
				break;
			case "3":
				viewBalancePage();
				break;
			case "4":
				transferFundsPage();
				break;
			case "5":
				createAccountsPage();
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

	public void depositPage() {

		// update the user object with all user and account info from the database
		user = Helpers.updateUserObject(user);

		double amountToDeposit = 0d;
		String userInput = "";
		// variable to set which account the user chose to deposit to
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

			// make sure the user actually has the type of account they're trying to deposit
			// to
			switch (userInput) {
			case "1":
				if (user.getHasCheckingAccount()) {
					accountChosen = "Checking";
				} else {
					System.out.println("You don't have a Checking account!  Please try again");
					depositPage();
				}
				break;
			case "2":
				if (user.getHasSavingsAccount()) {
					accountChosen = "Savings";
				} else {
					System.out.println("You don't have a Savings account!  Please try again");
					depositPage();
				}
				break;
			case "3":
				if (user.getHasJointAccount()) {
					accountChosen = "Joint";
				} else {
					System.out.println("You don't have a Joint account!  Please try again");
					depositPage();
				}
				break;
			case "4":
				homePage();
				break;
			default:
				System.out.println("Invalid selection, please try again!\n");
				// back to home page
				depositPage();
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
				depositPage();
			}

			// make sure user can only input 2 decimal places
			DecimalFormat df = new DecimalFormat(".##");
			amountToDeposit = Double.parseDouble(df.format(amountToDeposit));
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
					// user wants to deposit
					//deposit and return user object
					user = UserActions.deposit(accountChosen, amountToDeposit, user);

					// method that calls DAO implementation methods to update the database
					Helpers.updateAccountsInDatabase(accountChosen, user);

					//back to home after deposit complete
					homePage();
					break;
				case "2":
					// user doesn't want to deposit, return to depositPage()
					depositPage();
					break;
				default:
					System.out.println("Invalid selection, please try again!\n");
					// back to deposit
					depositPage();
				}
			} catch (IOException ioe) {
				System.out.println("Invalid selection, please try again!\n");
				// e.printStackTrace();
				depositPage();
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Please enter a valid number");
			depositPage();
			// nfe.printStackTrace();
		} catch (IOException ie) {
			System.out.println("Please enter a valid number");
			depositPage();
			// ie.printStackTrace();
		}
	}

	public void withdrawPage() {

		// update the user object with all user and account info from the database
		user = Helpers.updateUserObject(user);

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

			// make sure the user actually has the type of account they're trying to
			// withdraw from
			switch (userInput) {
			case "1":
				if (user.getHasCheckingAccount()) {
					accountChosen = "Checking";
				} else {
					System.out.println("You don't have a Checking account!  Please try again");
					withdrawPage();
				}
				break;
			case "2":
				if (user.getHasSavingsAccount()) {
					accountChosen = "Savings";
				} else {
					System.out.println("You don't have a Savings account!  Please try again");
					withdrawPage();
				}
				break;
			case "3":
				if (user.getHasJointAccount()) {
					accountChosen = "Joint";
				} else {
					System.out.println("You don't have a Joint account!  Please try again");
					withdrawPage();
				}
				break;
			case "4":
				homePage();
				break;
			default:
				System.out.println("Invalid selection, please try again!\n");
				// back to home page
				withdrawPage();
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
				withdrawPage();
			}

			// make sure user can only input 2 decimal places
			DecimalFormat df = new DecimalFormat(".##");
			amountToWithdraw = Double.parseDouble(df.format(amountToWithdraw));

			// check if the user is sure they want to withdraw
			String userWithdrawalInput = "";

			System.out.println("Are you sure you want to withdraw " + amountToWithdraw + " from your " + accountChosen
					+ " account?");
			System.out.println("[1] - Yes");
			System.out.println("[2] - No");
			System.out.print("Selection: ");
			try {
				// get user input from logout
				userWithdrawalInput = br.readLine();

				switch (userWithdrawalInput) {
				case "1":
					// user wants to withdraw
					
					//don't allow a withdrawal to go into negatives
					if (Helpers.balanceTooLow(accountChosen, amountToWithdraw, user)) {
						System.out.println("Your balance is too low to withdraw " + amountToWithdraw + ", please try again");
						withdrawPage();
					}
										
					//withdraw the amount from the user
					user = UserActions.withdraw(accountChosen, amountToWithdraw, user);

					// method that calls DAO implementation methods to update the database
					Helpers.updateAccountsInDatabase(accountChosen, user);

					//back to home after withdrawal complete
					homePage();

					break;
				case "2":

					// user doesnt want to withdraw, return to withdrawPage()
					withdrawPage();

					break;
				default:
					System.out.println("Invalid selection, please try again!\n");
					// back to withdraw
					withdrawPage();
				}
			} catch (IOException ioe) {
				System.out.println("Invalid selection, please try again!\n");
				// e.printStackTrace();
				withdrawPage();
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Please enter a valid number");
			withdrawPage();
			// nfe.printStackTrace();
		} catch (IOException ie) {
			System.out.println("Please enter a valid number");
			withdrawPage();
			// ie.printStackTrace();
		}
	}

	public void transferFundsPage() {

		System.out.println("This feature is not yet available, please try again later.");
		homePage();
	}

	public void viewBalancePage() {

		// update the user object with all user and account info from the database
		user = Helpers.updateUserObject(user);

		String accountChosen = "";

		System.out.println("\n-----------VIEW BALANCE------------");
		System.out.println("Which account would you like to view?");
		System.out.println("[1] - Checking");
		System.out.println("[2] - Savings");
		System.out.println("[3] - Joint");
		System.out.println("[4] - Back to Home Page");
		try {
			// get user input from view balance
			accountChosen = br.readLine();
			
			if (accountChosen.equals("4")){
				homePage();
			}
			
		} catch (IOException ioe) {
			System.out.println("An error occured with your selection");
			// e.printStackTrace();
			homePage();
		}

		//check if account exists or if input is invalid
		if(!Helpers.accountExists(accountChosen, user)){			
			viewBalancePage();
		}
		
		//view balance by printing to screen and returning the balance shown as a double 
		UserActions.viewBalance(accountChosen, user);

		String userInput;

		System.out.println("-----------------------------------");
		System.out.println("[1] - Back to Account Balances");
		System.out.println("[2] - Back to Home Page");
		System.out.println("[3] - Logout");
		System.out.print("Selection: ");

		try {
			// get user input from view balance
			userInput = br.readLine();

			switch (userInput) {
			case "1":
				viewBalancePage();
				break;
			case "2":
				homePage();
				break;
			case "3":
				logout();
				break;
			default:
				System.out.println("Invalid selection, please try again!\n");
				// back to view balance
				viewBalancePage();

			}

		} catch (IOException ioe) {
			System.out.println("An error occured with your selection");
			// e.printStackTrace();
			homePage();
		}
	}

	public void createAccountsPage() {

		// update the user object with all user and account info
		user = Helpers.updateUserObject(user);

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
				if (!user.getHasCheckingAccount()) {
					accountType = "Checking";
				} else {
					System.out.println("You already have a Checking account!  Please try again");
					createAccountsPage();
				}
				break;
			case "2":
				if (!user.getHasSavingsAccount()) {
					accountType = "Savings";
				} else {
					System.out.println("You already have a Savings account!  Please try again");
					createAccountsPage();
				}
				break;
			case "3":
				if (!user.getHasJointAccount()) {
					accountType = "Joint";
				} else {
					System.out.println("You already have a Joint account!  Please try again");
					createAccountsPage();
				}
				break;
			case "4":
				// back to home
				homePage();
				break;
			default:
				System.out.println("Invalid selection, please try again!\n");
				// back to home page
				createAccountsPage();
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
				createAccountsPage();
				break;
			default:
				System.out.println("Invalid selection, please try again!\n");
				// back to create account
				createAccountsPage();
			}

		} catch (IOException ioe) {
			System.out.println("Invalid selection, please try again!\n");
			// e.printStackTrace();
			createAccountsPage();
		}

		// update account object info before you pass it to update the database
		AccountDAO accountDAO = new AccountDAOImpl();
		Account a = new Account();
		a.setAccountID(user.getAccountID());
		a.setUserID(user.getUserID());
		a.setCheckingBalance(user.getCheckingBalance());
		a.setSavingsBalance(user.getSavingsBalance());

		// create a checking or savings account by changing the balance from -999999999
		// to 0 in the database
		if (accountType == "Checking") {
			// create checking account
			user.setHasCheckingAccount(true);
			a.setCheckingBalance(0);
			accountDAO.updateAccount(a);
			System.out.println("Checking Account successfully created!");
			// back to home page after account creation
			homePage();
		} else if (accountType == "Savings") {
			// create savings account
			user.setHasSavingsAccount(true);
			a.setSavingsBalance(0);
			accountDAO.updateAccount(a);
			System.out.println("Savings Account successfully created!");
			// back to home page after account creation
			homePage();
		} else {
			// create joint account
			// get joint user info
			try {

				// get user input to fill in joint users username to lookup their id
				String username = "";

				System.out.print("What is the Username of the other member on the Joint Account? ");
				username = br.readLine();

				// get second member of joint accounts userid from their username
				UsersDAO usersDAO = new UsersDAOImpl();
				int user2ID = usersDAO.getUserIDByUsername(username);
				int user1ID = user.getUserID();

				// make sure the username actually exists
				if (user2ID == 0) {
					System.out.println("This username does not exist, please try again!");
					createAccountsPage();
				}

				// check to make sure user2 doesnt already have a joint account with someone
				// else
				JointAccountDAO jointAccountDAO = new JointAccountDAOImpl();
				JointAccount j = jointAccountDAO.getJointAccountByUserID(user2ID);
				if (j.getJointID() != 0) {

					// if the jointid is not 0, then a joint account already exists for this user
					System.out.println("This person already has a Joint Account with somebody else");
					// return to main
					homePage();
				}

				// create joint account using both of the users userid
				JointAccount newJointAccount = new JointAccount();
				newJointAccount.setUser1ID(user1ID);
				newJointAccount.setUser2ID(user2ID);
				newJointAccount.setJointBalance(0);
				newJointAccount = jointAccountDAO.addJointAccount(newJointAccount);
				user.setHasJointAccount(true);

				// go back to home after account successfully created
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
				// set user object to null before logging out
				user = null;
				// back to main menu
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
