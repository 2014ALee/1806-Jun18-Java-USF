/*
 * Karen Matney
 * July 2, 2018
 * SimpleBank.java
 * Project 0 Revature Training
 * This class emulates a simple bank. A user can register or log in and their user information is saved.
 * In addition, it keeps track of one account, allowing the user to withdraw or deposit money, as well as
 * view their balance.
 * 
 * validity checks (at least username)
 */
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
import com.revature.models.User;

public class SimpleBankBak {
	// br is used by all methods but main(args)
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void registerMenu() {
		// Capitalized e-mail this way because it's an abbreviated version of 'electronic mail'.
		String username, password, firstName, lastName, eMail;

		System.out.println("Register");

		try {
			// Getting Registration info
			System.out.println("First Name: ");
			firstName = br.readLine();

			System.out.println("Last Name: ");
			lastName = br.readLine();
			
			// Checking if first name and last name contain only valid characters
			if(!firstName.matches("^[A-Za-z ]+$") || !lastName.matches("[A-Za-z]+(-[A-Za-z ]+)?")) {
				System.out.println("Invalid name");
				registerMenu();
			}

			System.out.println("Username: ");
			username = br.readLine();

			System.out.println("Password: ");
			password = br.readLine();

			System.out.println("E-mail: ");
			eMail = br.readLine();
			
			// Checking if e-mail contains only valid characters, and has the required characters
			if(!eMail.matches("^[A-Za-z][\\w-_\\.]*@[a-z0-9]+\\.[a-z]+")) {
				System.out.println("Invalid email");
				registerMenu();
			}

			User user = new User(username,password,firstName,lastName,eMail);

			// Username availability checking, registerMenu() is called again if not
			// If the username is available, mainMenu() called so they can log in right away
			if(usernameAvailable(user)) {
				createUpdateUser(user);
				System.out.println("Created user");
				mainMenu();
			} else {
				System.out.println("Username unavailable. Please try again.");
				registerMenu();
			}
		} catch (IOException e) {
			System.out.print("Input Error");
			e.printStackTrace();
		}
	}

	public static boolean usernameAvailable(User u) {
		String fileName = u.getUsername() + ".ser";
		File file = new File(fileName);

		if(file.exists()) {
			return false;
		} else {
			return true;
		}
	}

	public static void loginMenu() {
		String username, password;
		User user;

		System.out.println("Login");

		try {
			System.out.println("Username: ");
			username = br.readLine();

			System.out.println("Password: ");
			password = br.readLine();

			// Checking Credentials
			user = validateUser(username,password);
			if(user != null) {
				clientMenu(user);
			} else {
				System.out.print("Login Credentials Incorrect. Please try again.");
				mainMenu();
			}
		} catch(IOException e) {
			System.out.println("Input Error");
			e.printStackTrace();
		}
	}

	public static void createUpdateUser(User u) {
		String fileName = u.getUsername() + ".ser";

		// If creating user
		if (u.getAccount() == null){
			// TODO: why random() is generating 0.
			Account account = new Account((int) Math.random() * 504,0);
			u.setAccount(account);
		}
		
		// Writing u to the user's own file
		/*
		 * Used instead of BufferReader/Scanner for serialization, otherwise, it wouldn't be serialized.
		 * 
		 * For the future, remember, if an object contains another object whose class is not Serializable, it will throw
		 * an exception/error.
		 * 
		 * A try-with-resources block ensures the resource will be closed.
		 */
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));) {
			oos.writeObject(u);
		} catch (FileNotFoundException e) {
			System.out.println("File Access Error");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Writing File Error");
			e.printStackTrace();
		}
	}
	
	public static User validateUser(String username,String password) {
		String fileName = username + ".ser";
		User user;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			user = (User) ois.readObject();

			// Check validity of username and e-mail
			if(user != null) {
				if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
					return user;
				}
				else {
					return null;
				}
			}
		} catch (FileNotFoundException e1) {
			System.out.println("Login Credentials incorrect. Please try again.");
			mainMenu();
		} catch (IOException e1) {
			System.out.println("File Read Error");
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("File Write Error");
			e.printStackTrace();
		}

		return null;
	}

	public static void clientMenu(User u) {
		Account account = u.getAccount();
		String doubleCheck;
		double amount;

		System.out.println("[1] Deposit");
		System.out.println("[2] Withdrawl");
		System.out.println("[3] View Balance");
		System.out.println("[4] Logout");

		try {
			switch(br.readLine()) {
			// Deposit
			case "1":
				System.out.println("Enter the amount you wish to deposit:");

				doubleCheck = br.readLine();

				// Check to see if a double
				if(numCheck(doubleCheck)) {
					amount = Double.parseDouble(doubleCheck);
					if(amount > 0) {
						account.deposit(amount);
						createUpdateUser(u);
						System.out.println("Balance:\n" + account.getBalance());
					}
				} else {
					System.out.println("Invalid input");
				}
				break;
				// Withdrawal: Same as deposit, but different setter for balance
			case "2":
				System.out.println("Enter the amount you wish to withdraw:");

				doubleCheck = br.readLine();
				if(numCheck(doubleCheck)) {
					amount = Double.parseDouble(doubleCheck);
					if(amount > 0  && (account.getBalance() - amount) >= 0) {
						account.withdrawl(amount);
						createUpdateUser(u);
						System.out.println("Balance:\n" + account.getBalance());
					} else { 
						System.out.println("Not enough currency to make transaction.");
					}
				} else {
					System.out.println("Invalid input");
				}
				break;
				// Balance
			case "3":
				System.out.println("Your Balance");
				System.out.println(account.getBalance());
				break;
			case "4":
				System.out.println("Logged Out");
				return;
			default:
				System.out.println("Invalid input. Please try again.");
				clientMenu(u);
				break;
			}
		} catch (IOException e) {
			System.out.println("Input Error");
			e.printStackTrace();
		}

		clientMenu(u);
	}

	public static boolean numCheck(String str) {
		// Checks for a double
		if(str.matches("^\\d*\\.?\\d\\d?$")) {
			return true;
		} else {
			return false;
		}
	}
}