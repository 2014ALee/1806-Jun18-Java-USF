package simple.bank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

import simple.bank.models.User;

public class BankDriver {		

	private static User user = null;
	private static BufferedReader br = br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		bank();
	}


	public static void bank() {
		String userInput;

		System.out.println("-----------MAIN MENU-----------");
		System.out.println("(Enter the number of the option you would like to choose)");
		System.out.println("[1] Create an account\n[2]Login");

		try {
			userInput = br.readLine();
			switch(userInput) {
			case "1":
				createAccount();
				break;
			case "2":
				//login();
				break;
			default:
				System.out.println("Invalid input. Please try again.");
				bank();
			}
		} catch (IOException e) {
			System.out.println("There was an error while reading input.\nPlease try again.");
			bank();
		}
	}
	
	public static void createAccount() {
		String firstName, lastName, username, email, password, unOrE;
		System.out.println("-----------CREATE ACCOUNT-----------\n");
		
		try {
			System.out.print("First name: ");
			firstName = br.readLine();
			
			System.out.print("\nLast name: ");
			lastName = br.readLine();
			
			System.out.print("\nUsername or Email: ");
			unOrE = br.readLine();
			
			System.out.print("\nPassword: ");
			password = br.readLine();
			
			String str = checkUnOrE(unOrE);
			
			if (str.equals("email")) {
				user = new User(firstName, lastName, "", str, password);
			} else {
				user = new User(firstName, lastName, str, "", password);
			}
			
			if (loginAvailable(user)) {
				System.out.println("Successfully created account!");
				serializedUser(user);
				accountMenu();
			} else {
				System.out.println("Login not available. Please try a different username or email.");
				createAccount();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
private static void serializedUser(User user) {
		
		String fileName = user.getUsername() == "" ? user.getEmail() : user.getUsername();
		fileName += ".ser";

		try (FileOutputStream fos = new FileOutputStream(fileName); 
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(user);
			
		} catch (FileNotFoundException e) {
			System.out.println("[LOG] - An error occurred while accessing the file.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occured while writing the file");
			e.printStackTrace();
		}
		
	}
	
	public static String checkUnOrE(String unOrE) {
		if (unOrE.contains("@") && (unOrE.contains(".com") || unOrE.contains(".edu"))) {
			return "email";
		} else {
			return "username";
		}
	}
	
	public static boolean loginAvailable(User user) {
		String loginStr = user.getUsername() == "" ? user.getEmail() : user.getUsername();
		loginStr += ".ser";
		
		File file = new File(loginStr);
		
		if (file.exists()) {
			return false;
		}
		return true;
	}
	
	public static void accountMenu() {
		System.out.println("-----------ACCOUNT MENU-----------\n");
	}
}
