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
import java.util.HashSet;
import java.util.Set;

import com.revature.models.BankUser;

public class BankUserDriver {

	static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
	static File userInfoFile = new File("C:\\batch-repos\\1806-Jun18-Java-USF\\Brandon_Scoggins_Code\\console_bank\\src\\main\\resources\\Bank_Users");
	static File serializedUserInfoFile = new File("C:\\batch-repos\\1806-Jun18-Java-USF\\Brandon_Scoggins_Code\\console_bank\\src\\main\\resources\\Bank_Users_Serialized.ser");
	
	public static void main(String[] args) {
		
		Set<BankUser> userInfoSet = new HashSet<>();
		
		userInfoSet = getSerializedBankUsers(userInfoSet);
		
		displayUnLoggedInMenu(userInfoSet);
	}

	public static void displayWelcome() {

		System.out.println("--Welcome to Console Bank!--");
	}

	public static void displayWelcome(String name) {

		System.out.println("-Welcome, " + name + ", to Console Bank!-");
	}
	
	public static void displayUnLoggedInMenu(Set<BankUser> userInfoSet) {
		
		String input = null;

		displayWelcome();
		
		System.out.println("---------------------------");
		System.out.println("| [1] - Log In            |");
		System.out.println("| [2] - Register New User |");
		System.out.println("| [3] - Quit              |");
		System.out.println("---------------------------");
		do {
			input = getIntInput();			
			if(!input.equals("1") && !input.equals("2") && !input.equals("3"))
				System.out.println("\nPlease enter a valid menu option.");
		}while(!input.equals("1") && !input.equals("2") && !input.equals("3"));

		System.out.println();

		switch(input) {
		case "1":
			logInUser(userInfoSet);
			break;
		case "2":
			registerNewUser(userInfoSet);
			break;
		case "3":
			System.out.println("Thank you for using Console Bank!");
			serializeBankUsers(userInfoSet);
			System.exit(0);
			break;
		default:
			System.out.println("Un-anticipated error in displayUnLoggedInMenu()");
			System.exit(0);				
		}
	}

	public static void displayLoggedInMenu(Set<BankUser> userInfoSet, BankUser activeUser) {
		
		String input = null;
		
		displayWelcome(activeUser.getUserName());
		
		System.out.println("---------------------------");
		System.out.println("| [1] - Check Balance     |");
		System.out.println("| [2] - Withdraw          |");
		System.out.println("| [3] - Deposit           |");
		System.out.println("| [4] - Log Out           |");
		System.out.println("| [5] - Quit              |");
		System.out.println("---------------------------");
		do {	
			input = getIntInput();	
			if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5"))
				System.out.println("\nPlease enter a valid menu option.");
		}while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5"));

		System.out.println();

		switch(input) {
		case "1":
			checkBalance(userInfoSet, activeUser);
			break;
		case "2":
			withdraw(userInfoSet, activeUser);
			break;
		case "3":
			deposit(userInfoSet, activeUser);
			break;
		case "4":
			logOutUser(userInfoSet);
			break;
		case "5":
			System.out.println("Thank you for using Console Bank!");
			serializeBankUsers(userInfoSet);
			System.exit(0);
			break;
		default:
			System.out.println("Un-anticipated error in displayLoggedInMenu()");
			System.exit(0);				
		}
	}
	
	public static void checkBalance(Set<BankUser> userInfoSet, BankUser activeUser) {
		
		System.out.println("Current Balance: $" + activeUser.getBalance());
		System.out.println();
		
		displayLoggedInMenu(userInfoSet, activeUser);
	}
	
	public static void withdraw(Set<BankUser> userInfoSet, BankUser activeUser) {	
		
		System.out.println("Withdraw Amount: ");
		activeUser.setBalance(("" + ((Double.parseDouble(activeUser.getBalance())) - getCashInput())));
		System.out.println();
		checkBalance(userInfoSet, activeUser);
	}
	
	public static void deposit(Set<BankUser> userInfoSet, BankUser activeUser) {
		
		System.out.println("Deposit Amount: ");
		activeUser.setBalance(("" + ((Double.parseDouble(activeUser.getBalance())) + getCashInput())));
		System.out.println();
		checkBalance(userInfoSet, activeUser);
	}
	
	public static void logOutUser(Set<BankUser> userInfoSet) {
		
		System.out.println("Log Out Successful");
		System.out.println();
		
		displayUnLoggedInMenu(userInfoSet);
	}

	public static void registerNewUser(Set<BankUser> userInfoSet) {

		boolean isUnique;
		String userName = null;
		String passWord = null;
		
		System.out.println("To register a new user, please enter a username and password\n");
		do {
			System.out.println("Username: ");
			userName = getStringInput();
			
			isUnique = true;
			
			for(BankUser user : userInfoSet) {
				if (user.getUserName().equals(userName)) {
					System.out.println("\nThat username already exist. Please try again.\n");	 		
					isUnique = false;
					break;
				}
			}
		}while(!isUnique);

		do {
			System.out.println("Password: ");
			passWord = getStringInput();
			System.out.println("Confirm Password: ");
			if (!passWord.equals(getStringInput()))
				System.out.println("\nPasswords do not match. Try again.\n");
			else
				break;
		}while(true);

		System.out.println();

		System.out.println("Registration Successful!");
		String balance = "0.00";
		
		BankUser user = new BankUser(userName, passWord, balance);
		userInfoSet.add(user);
		
		System.out.println();		
		displayUnLoggedInMenu(userInfoSet);
	}

	public static void logInUser(Set<BankUser> userInfoSet) {

		System.out.println("To login, please enter a username and password\n");

		System.out.println("Username: ");
		String userName = getStringInput();
		System.out.println("Password: ");
		String passWord = getStringInput();
		
		boolean credentialsCorrect = false;
		BankUser activeUser = null;
		
		for (BankUser user : userInfoSet) {
			if (user.getUserName().equals(userName)) {
				if (user.getPassWord().equals(passWord)){
					credentialsCorrect = true;
					activeUser = user;
					break;
				}
			}
		}
		
		if (!credentialsCorrect) {
			System.out.println("\nThat information is not in our database.\n");
			displayUnLoggedInMenu(userInfoSet);
		}

		System.out.println();
		System.out.println("Login Successful!");
		System.out.println();
		
		displayLoggedInMenu(userInfoSet, activeUser);
	}
	
	public static double getCashInput() {
		
		boolean validInput = true;
		
		System.out.println();
		System.out.println("Enter a cash value (##.##)");
		String input = getStringInput();
		char[] charInputArray = input.toCharArray();
		if(charInputArray.length == 0) {
			System.out.println("\nNo input was entered. Try again.");
			getCashInput();
		}else if(charInputArray.length < 3) {	
			System.out.println("\nInput too short. Please try again.");
			getCashInput();
		}else if(charInputArray[charInputArray.length - 3] != '.') {		
			System.out.println("\nIncorrect format. Please try again.");
			getCashInput();
		}else {
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

	public static boolean charIsNumber(char character) {
		switch(character) {
		case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
			return true;
		default:
			return false;
		}
	}

	public static String getIntInput() {
		String stringInput = getStringInput();
		boolean isIntInput = true;
		if(stringInput.length() == 0) {
			System.out.println("\nNo input was entered. Try again.");
			stringInput = null;
			isIntInput = false;
		}else if(stringInput.length() > 1) {
			System.out.println("\nInput too long. Please try again.");
			stringInput = null;
			isIntInput = false;
		}else if(!stringIsNumber(stringInput)) {
			System.out.println("\nInput must be a number. Please try again.");
			stringInput = null;
			isIntInput = false;
		}

		if(!isIntInput) {
			stringInput = "";
			getIntInput();
		}
		return stringInput;
	}

	public static boolean stringIsNumber(String stringInput) {
		switch(stringInput) {
		case "0": case "1": case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9":
			return true;
		default:
			return false;
		}
	}
	
	public static String getStringInput() {	
		try {
			System.out.print("Input:     ");
			return consoleReader.readLine();
		} catch (IOException e) {
			System.out.println("Failed reading console input. (getStringInput())");
			e.printStackTrace();
		}
		return "";
	}

	public static void serializeBankUsers(Set<BankUser> userInfoSet) {
		
		try(FileOutputStream fos = new FileOutputStream(serializedUserInfoFile);
				ObjectOutputStream oos = new ObjectOutputStream(fos);){
			
			for(BankUser user : userInfoSet) {
				oos.writeObject(user);	
			}			
			
		} catch (FileNotFoundException e) {
			System.out.println("[Log] - Error while accessing the file.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[Log] - Error while writing to the file.");
			e.printStackTrace();
		}
	}

	public static Set<BankUser> getSerializedBankUsers (Set<BankUser> userInfoSet) {
		
		try {
			if(!serializedUserInfoFile.exists())
				serializedUserInfoFile.createNewFile();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
			
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serializedUserInfoFile));){

			
			BankUser user = (BankUser) ois.readObject();		// Could i just store to Set instead of each individual user?
			while(user != null) {
				userInfoSet.add(user);
				user = (BankUser) ois.readObject();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("[Log] - Error while accessing the file.");
			e.printStackTrace();
		} catch (IOException e) {
//			System.out.println("[Log] - Error while reading the file.");				// I am still not sure why this is being thrown. The program runs regardless
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("[Log] - Error while deserializing the object.");
			e.printStackTrace();
		}
		
		return userInfoSet;
	}
}
