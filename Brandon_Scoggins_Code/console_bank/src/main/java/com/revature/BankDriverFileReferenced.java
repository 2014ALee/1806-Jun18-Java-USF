package com.revature;

/*
 * A Console based banking app. Users are able to register with unique usernames, log in and out, withdraw and deposit
 * money, and check their balance. All data is persisted in a text file.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * forget collections. Check all input against the file
 */

/*
 *  double formatting to end with .##
 *  
 *  format printing to console
 *  
 *  figure out how maps work
 */

/*
 * issue with map. It looks like its pass by reference..
 */

public class BankDriverFileReferenced {

	/*
	 * Declare and initialize some static variables that will be used in methods throughout the class
	 */
	
	// Initialize one reader to get console input
	static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
	static String input = "";
	// Initialize a File to hold user information
	static File userInfoFile = new File("C:\\batch-repos\\1806-Jun18-Java-USF\\Brandon_Scoggins_Code\\console_bank\\src\\main\\resources\\Bank_Users");
	// These String objects are referenced throughout the bank app, and are saved to the file on log out and exit
	static String userName, passWord, balance;

	public static void main(String[] args) {
		// This kicks of the application
		displayUnLoggedInMenu();
	}

	/*
	 * A welcome method that prints the Bank name to generic/unlogged in users
	 */
	
	public static void displayWelcome() {

		System.out.println("--Welcome to Console Bank!--");
	}

	/*
	 * A welcome that includes the logged in users name.
	 * 
	 * Displaying a username may be insecure, but this could be changed to a first name
	 */
	
	public static void displayWelcome(String name) {

		System.out.println("-Welcome, " + name + ", to Console Bank!-");
	}

	/*
	 * Displays options appropriate for an unlogged in user
	 */
	
	public static void displayUnLoggedInMenu() {
		// Display generic welcome and clear user info variables
		displayWelcome();
		userName = "";
		passWord = "";
		balance = "";
		// Print menu with appropriate options for an unknown user
		System.out.println("---------------------------");
		System.out.println("| [1] - Log In            |");
		System.out.println("| [2] - Register New User |");
		System.out.println("| [3] - Quit              |");
		System.out.println("---------------------------");
		// Loop that calls a method to get integer input, then verifies that it is a menu option
		// Continues until successful input is entered
		do {
			input = ("" + getIntInput());
			if(!input.equals("1") && !input.equals("2") && !input.equals("3"))
				System.out.println("\nPlease enter a valid menu option.");
		}while(!input.equals("1") && !input.equals("2") && !input.equals("3"));

		System.out.println();
		// Switch statement that checks input then directs the user to the corresponding menu
		switch(input) {
		case "1":
			logInUser();
			break;
		case "2":
			registerNewUser();
			break;
		case "3":
			System.out.println("Thank you for using Console Bank!");
			// Updates the current user info into the user info file 
			updateUserInfoFile();
			// Exits the application
			System.exit(0);
			break;
		default:
			System.out.println("Un-anticipated error in displayUnLoggedInMenu()");
			System.exit(0);	
		}
	}

	/*
	 * Displays options appropriate for a logged in user
	 */
	
	public static void displayLoggedInMenu() {
		// Welcomes the user with a personal touch
		displayWelcome(userName);
		// Displays options for a logged in user
		System.out.println("---------------------------");
		System.out.println("| [1] - Check Balance     |");
		System.out.println("| [2] - Withdraw          |");
		System.out.println("| [3] - Deposit           |");
		System.out.println("| [4] - Log Out           |");
		System.out.println("| [5] - Quit              |");
		System.out.println("---------------------------");
		// Loop that calls a method to get integer input, then verifies that it is a menu option
		// Continues until successful input is entered
		do {
			input = ("" + getIntInput());			
			if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5"))
				System.out.println("\nPlease enter a valid menu option.");
		}while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5"));

		System.out.println();
		// Switch statement that checks input then directs the user to the corresponding menu
		switch(input) {
		case "1":
			checkBalance();
			break;
		case "2":
			withdraw();
			break;
		case "3":
			deposit();
			break;
		case "4":
			logOutUser();
			break;
		case "5":
			System.out.println("Thank you for using Console Bank!");
			// Updates the current user info into the user info file 
			updateUserInfoFile();
			// Exits the application
			System.exit(0);
			break;
		default:
			System.out.println("Un-anticipated error in displayLoggedInMenu()");
			System.exit(0);			
		}
	}

	/*
	 * Display the static variable balance which reflects the current users account balance
	 */
	
	public static void checkBalance() {
		// Could look into formatting of balance to display 2 decimals
		System.out.println("Current Balance: $" + balance);
		System.out.println();
		// Returns the user to the logged in menu
		displayLoggedInMenu();
	}

	/*
	 * Allows the user the withdraw any desired 
	 * 
	 * Could add functionality to prevent overdrafts
	 */
	
	public static void withdraw() {	
		// Gets cash input (##.##) from the user and deducts it from balance
		System.out.println("Withdraw Amount: ");
		balance = ("" + (Double.parseDouble(balance) - getCashInput()));
		
		System.out.println();
		// Gives the user an updated balance
		checkBalance();
	}
	
	/*
	 * Allows user to deposit money into their account
	 */
	
	public static void deposit() {
		// Gets cash input (##.##) from the user and adds it to balance
		System.out.println("Deposit Amount: ");
		balance = ("" + (Double.parseDouble(balance) + getCashInput()));
		
		System.out.println();
		// Gives the user an updated balance
		checkBalance();
	}
	
	/*
	 * Logs the user out
	 * This updates the userInfoFile, then returns the user to the unLoggedInMenu where static user info is cleared
	 */
	
	public static void logOutUser() {
		// Informs the user that the log out was successful
		System.out.println("Log Out Successful.");
		System.out.println();
		// Updates static user info variables into the user info file
		updateUserInfoFile();
		// Returns the user to the unlogged in menu
		displayUnLoggedInMenu();
	}

	/*
	 * Registers a new user with a unique username
	 */
	
	public static void registerNewUser() {
		
		System.out.println("To register a new user, please enter a username and password\n");
		// Ask the user for a unique username
		// Loops until successful - Could allow an option to break out and attempt to login
		do {
			System.out.println("Username: ");
			userName = getStringInput();
			// Check to see if userName exist in the user info file
			if (userNameExist()) 
				System.out.println("\nThat username already exist. Please try again.\n");	 		
			else
				break;
		}while(true);
		// If the username is available, ask the user for a password
		do {
			System.out.println("Password: ");
			passWord = getStringInput();
			System.out.println("Confirm Password: ");
			// Checks to see if the passwords match - Loops until successful
			if (!passWord.equals(getStringInput()))
				System.out.println("\nPasswords do not match. Try again.\n");
			else
				break;
		}while(true);

		System.out.println();
		// Informs the user that they've successfully registered
		System.out.println("Registration Successful!");
		System.out.println();
		// Gives the newly registered user an initial balance of $0.00
		balance = "0.00";
		// Writes the user to the user info file
		updateUserInfoFile();
		// Directs the user to the unlogged in menu
		displayUnLoggedInMenu();
	}

	/*
	 * Gets the users log in information and see if it exist
	 */
	
	public static void logInUser() {
		// Ask for the users log in information
		System.out.println("To login, please enter a username and password\n");

		System.out.println("Username: ");
		userName = getStringInput();
		System.out.println("Password: ");
		passWord = getStringInput();
		// Call methods to see if either the username does not exist, or if it does, if the password matches it
		if (!userNameExist() || !passWordMatches()) {			
			System.out.println("That information is not in our database.");
			// If username does not exist, or the password is incorrect, the user is returned to the unlogged in menu
			displayUnLoggedInMenu();
		}
		// Lets the user know they were successfully logged in
		System.out.println();
		System.out.println("Login Successful!");
		System.out.println();
		// Gets the user's balance from the user info file for use in their session
		updateBalance();
		// Sends the user to the logged in menu
		displayLoggedInMenu();
	}

	/*
	 * Gets monetary input from the user. This similar to int input but checks
	 * that the third from last character is '.'
	 */
	
	public static double getCashInput() {
		
		// Initialize a boolean to indicate success. This is only used if the for loop is broken out of (for loops behave weirdly when used recursively)
		boolean validInput = true;
		
		System.out.println();
		// Shows the user the expected format
		System.out.println("Enter a cash value (##.##)");
		// Gets String input then cast it to a char[]
		input = getStringInput();
		char[] charInputArray = input.toCharArray();
		// Run some checks to verify that input is the expected format
		// Check for empty input
		if(charInputArray.length == 0) {
			System.out.println("\nNo input was entered. Try again.");
			getCashInput();
			// Check for input less than three characters. Three character is minimum for expected format
		}else if(charInputArray.length < 3) {	
			System.out.println("\nInput too short. Please try again.");
			getCashInput();
			// Verifies that the third from last character is a decimal
		}else if(charInputArray[charInputArray.length - 3] != '.') {		
			System.out.println("\nIncorrect format. Please try again.");
			getCashInput();
		}else {
			// Verifies that each other character is a number
			for(int i = 0; i < charInputArray.length; i++) {
				if (i != (charInputArray.length - 3)) {
					if(!charIsNumber(charInputArray[i])) {
						System.out.println(input);
						System.out.println("\nInput must be a number. Please Try again.");
						validInput = false;
						break;
					}
				}
			}
			if (!validInput) {
				getCashInput();
			}
		}
		return Double.parseDouble(input);
	}

	/*
	 * Gets an integer input. Usually for menu navigation
	 */
	
	public static int getIntInput() {
		// Calls getStringInput, then verifies that it is a number 
		input = getStringInput();
		char[] charInputArray = input.toCharArray();
		// Runs some checks to verify that the input is a number
		// Checks for empty input
		if(charInputArray.length == 0) {
			System.out.println("\nNo input was entered. Try again.");
			getIntInput();
			// Menu input is expected to be one digit
			// Checks that input is one digit
		}else if(charInputArray.length > 1) {
			System.out.println("\nInput too long. Please try again.");
			getIntInput();
			// Verifies that input is a number
		}else if(!charIsNumber(charInputArray[0])) {
			System.out.println("\nInput must be a number. Please try again.");
			getIntInput();
		}
		return Integer.parseInt(input);
	}
	
	/*
	 * Checks that a characters is a digit 0-9
	 */
	
	public static boolean charIsNumber(char character) {
		switch(character) {
		case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
			return true;
		default:
			return false;
		}
	}

	/*
	 * Gets String input from the user using a BufferedReader
	 * I use a distinct method for reading input to reduce the number of try/catch statements
	 */
	
	public static String getStringInput() {	
		try {
			System.out.print("Input:     ");
			// This BufferedReader was defined static so it would not be recreated
			// every time input is needed
			// If console input was read successfully, it is returned.
			return consoleReader.readLine();
		} catch (IOException e) {
			// BufferedReader may throw IOException so it is caught here
			System.out.println("Failed reading console input. (getStringInput())");
			e.printStackTrace();
		}
		return "";
	}

	/*
	 * Reads the user info file and checks if the userName exist
	 */
	
	public static boolean userNameExist() {
		// Initialize a BufferedReader
		BufferedReader fileReader = null;
		try {
			// Checks if the file exist, and creates it if needed
			if(!userInfoFile.exists())
				userInfoFile.createNewFile();
			// Initializes a BufferedReader to read the user info file
			fileReader = new BufferedReader(new FileReader(userInfoFile));
			// Initializes a String variable to hold each line of the user info file
			String line = fileReader.readLine();
			// Rather than use a delimiter, store one parameter per line in a specific sequence
			// Initialize a variable to count the line being read
			int counter = 1;
			// Loop to read each line of the file as long as the line is not empty
			while(line != null) {	
				// Usernames are stored on every third line, beginning on the first line
				// Checks if the input username matches a name in the file
				if(counter % 3 == 1 && userName.equals(line)) {
					return true;
				}
				// Reads the next line of the file
				line = fileReader.readLine();
				// Increments the line counter
				counter++;
			}

		} catch (IOException e) {
			// BufferedReader may throw IOException
			e.printStackTrace();
		}finally {
			// Closes the BufferedReader so the file can be accessed by other methods
			if(fileReader != null)
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return false;
	}
	
	/*
	 * Checks if an input password matches the input username
	 */
	
	public static boolean passWordMatches() {
		// Initialize a BufferedReadre
		BufferedReader fileReader = null;
		try {
			// Checks if the file exist, and creates it if needed
			if(!userInfoFile.exists())
				userInfoFile.createNewFile();
			// Initializes a BufferedReader to read the user info file
			fileReader = new BufferedReader(new FileReader(userInfoFile));
			// Initializes a String variable to hold each line of the user info file
			String line = fileReader.readLine();
			// Initialize a counter to track the line being read
			int counter = 1;
			// Loop to read each line of the user info file
			while(line != null) {	
				// Finds the line that contains the current userName
				if(counter % 3 == 1 && userName.equals(line)) {
					break;
				}
				// Reads the next line
				line = fileReader.readLine();
				counter++;
			}
			// Reads the next line which should contain the password corresponding to the current userName
			line = fileReader.readLine();
			// Checks that the found password matches the input password
			if(passWord.equals(line)) {
				return true;
			}
		} catch (IOException e) {	
			// BufferedReader may throw an IOException
			e.printStackTrace();
		}finally {
			if(fileReader != null)
				try {
					// Closes the BufferedReader
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return false;
	}

	/*
	 * Method to update user information into the user info file
	 */
	
	public static void updateUserInfoFile() {
		// Initialize a List of Strings to hold data from a file
		List<String> userInfoList = null;
		userInfoList = new ArrayList<>();
		// Initialize a BufferedReader and BufferedWriter
		BufferedReader fileReader = null;
		BufferedWriter fileWriter = null;
		// BufferedReader and Writer may throw IOExceptions so use them in a try/catch statement
		try {
			// Checks if file exist and creates it if it doesn't
			if(!userInfoFile.exists())
				userInfoFile.createNewFile();
			// Assign the fileReader as a BufferedReader object to read from a file
			fileReader = new BufferedReader(new FileReader(userInfoFile));
			// Initialize a String to hold each line of the file
			String line = fileReader.readLine();
			// Loop to read each line of the file
			while(line != null) {	
				// Adds each line to the List
				userInfoList.add(line);
				// Reads the next line in the file
				line = fileReader.readLine();
			}
			// Checks if current static userName exist in the list
			// If it does, update the corresponding balance 
			if (userNameExist()) {
				for(int i = 0; i < userInfoList.size(); i++) {
					// Looks for userName in the List
					if (userInfoList.get(i).equals(userName)) {
						// If userName is found, remove the corresponding balance (2 indexes down)
						userInfoList.remove(i + 2);
						// Then add the current static balance value in the same index
						userInfoList.add(i + 2, balance);
					}
				}
			}else {
				// If the userName is not in the list, add all the current static user info to the list
				userInfoList.add(userName);
				userInfoList.add(passWord);
				userInfoList.add(balance);
			}
		} catch (IOException e) {							
			e.printStackTrace();
		}finally {
			if(fileReader != null)
				try {
					// Close the file reader so the file can be accessed
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		// Try/catch statement for writing to a file
		try {
			// Initialize the BufferedReader to read a file
			fileWriter = new BufferedWriter(new FileWriter(userInfoFile));
			// An enhanced for loop writes each entry in the list to a new line in user info file 
			for(String s : userInfoList)
				// This leaves a blank line at the end of the file that will cause the populate method to read an 
				// additional username. This shouldnt be a problem (potentially compounding lines) since the 
				// file is written new each time, and only users with passwords and balances are written
				fileWriter.write(s + "\n");	 	
		} catch (IOException e) {							
			e.printStackTrace();
		}finally {
			if(fileWriter != null)
				try {
					// Close BufferedWriter so file can be accessed if needed
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/*
	 * Updates the user balance in the user info file
	 */
	
	public static void updateBalance() {
	
		BufferedReader fileReader = null;
		try {
			// Checks if file exist and creates it if it doesn't
			if(!userInfoFile.exists())
				userInfoFile.createNewFile();
			// Initialize the BufferedReader to read the user info file
			fileReader = new BufferedReader(new FileReader(userInfoFile));
			// Initialize a String to hold each line of the file
			String line = fileReader.readLine();
			// Initialize a counter to track each line of the file
			int counter = 1;
			// Loop to read through each line of the file
			while(line != null) {	
				// Finds the username in the file
				if(counter % 3 == 1 && userName.equals(line)) {
					break;
				}
				// If username is not found, read the next line
				line = fileReader.readLine();
				counter++;
			}
			// Read two more lines to get the balance that corresponds the the found username
			line = fileReader.readLine();
			line = fileReader.readLine();
			balance = line;
		} catch (IOException e) {							
			e.printStackTrace();
		}finally {
			if(fileReader != null)
				try {
					// Close file reader
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
