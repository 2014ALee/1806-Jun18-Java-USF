package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Pattern;

import com.revature.dao.AccountDAOImpl;
import com.revature.dao.UserDAOImpl;
import com.revature.models.Account;
import com.revature.models.User;

public class BankDriver {

	private static User user;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static UserDAOImpl userDAO = new UserDAOImpl();
	private static AccountDAOImpl accountDAO = new AccountDAOImpl();

	public static void main(String[] args) {
		mainMenu();
	}

	public static void mainMenu() {
		String input = "3";

		System.out.println("-------------------------- MAIN MENU --------------------------");

		System.out.println("[1] - Login");
		System.out.println("[2] - Register");
		System.out.println("[3] - Exit");
		System.out.print(":> ");

		try {
			input = br.readLine();

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
				invalidInput();
				mainMenu();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static void register() {
		user = new User();
		String username = "", password = "", conf = "", email = "", phone = "";

		System.out.println("-------------------------- REGISTER --------------------------");

		try {
			while(true) {
				System.out.print("Username :> ");
				username = br.readLine();

				// No empty usernames
				if(username.equals("")) {
					System.out.println("Invalid username. Please try again.");
					continue;
				}

				// Test to see if another user already has that username
				if(userDAO.getUserByUsername(username) == null)
					break;
				else
					System.out.println("A user with that username already exists. Please select a different username.");
			}

			while(true) {
				System.out.print("Password :> ");
				password = br.readLine();

				// No empty passwords
				if(password.equals("")) {
					System.out.println("Invalid password. Please try again.");
					continue;
				}

				System.out.print("Confirm Password :> ");
				conf = br.readLine();

				if(password.equals(conf))
					break;
				else
					System.out.println("Passwords didn't match. Please try again.");
			}

			// For convenience, i decided not to make email addresses or phone numbers unique. In a real life application
			// you would make both unique so that if you have to contact a user, there's no ambiguity.
			while(true) {
				System.out.print("Email Address :> ");
				email = br.readLine();

				// Test if their email address is actually an email address
				// Source: http://emailregex.com/
				String emailRegex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
				if(Pattern.compile(emailRegex).matcher(email).find())
					break;
				else
					System.out.println("Invalid email address. Please try again.");
			}

			while(true) {
				System.out.print("Phone Number :> ");
				phone = br.readLine();

				// Test if their phone number is actually a phone number
				String phoneRegex = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$";
				if(Pattern.compile(phoneRegex).matcher(phone).find())
					break;
				else
					System.out.println("Invalid phone number. Please try again.");
			}

			user.setUsername(username);

			// Hash the password
			// Generate salt
			RandomString rs = new RandomString(16);
			String salt = rs.nextString();

			// Call the hashing function
			String pwHash = hashPassword(password, salt);

			user.setPwHash(pwHash);
			user.setPwSalt(salt);
			user.setEmail(email);
			user.setPhone(phone);

			// Add the user to the database. We have to set user to the return value to get the user_id
			user = userDAO.addUser(user);

			if(user == null)
				System.out.println("Unable to create user in database.");
			else {
				// User has been created. Now we just need to create checking and savings accounts for them.
				Account checking = new Account();
				checking.setAccountName("Checking");
				checking.setBalance(0);
				checking.setFrozen(false);

				checking = accountDAO.addAccount(user.getUserID(), checking);

				if(checking == null)
					System.out.println("Unable to create checking account in the database.");
				else {
					Account savings = new Account();
					savings.setAccountName("Savings");
					savings.setBalance(0);
					savings.setFrozen(false);

					savings = accountDAO.addAccount(user.getUserID(), savings);

					if(savings == null)
						System.out.println("Unable to create savings account in the database.");
					else {
						System.out.println("User created");
						userMenu();
					}
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private static void login() {
		String username = "", password = "";

		System.out.println("-------------------------- LOGIN --------------------------");

		try {
			while(true) {
				System.out.print("Username :> ");
				username = br.readLine();

				// No empty usernames
				if(username.equals("")) {
					System.out.println("Invalid username. Please try again.");
					continue;
				} else
					break;
			}

			while(true) {
				System.out.print("Password :> ");
				password = br.readLine();

				// No empty passwords
				if(password.equals("")) {
					System.out.println("Invalid password. Please try again.");
					continue;
				} else
					break;
			}

			User u;
			if((u = userDAO.getUserByUsername(username)) != null) {
				// The user exists. Do the passwords match?
				String salt = u.getPwSalt();

				if(u.getPwHash().equals(hashPassword(password, salt))){
					// Successful login
					System.out.println("Login successful");
					user = u;
					userMenu();
				} else {
					System.out.println("Invald login credentials.");
					mainMenu();
				}
			} else {
				System.out.println("Invald login credentials.");
				mainMenu();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void userMenu() {
		String input = "";

		System.out.println("-------------------------- USER MENU --------------------------");

		System.out.println("[1] - Manage Accounts");
		System.out.println("[2] - Create Account");
		System.out.println("[3] - Create Joint Account");
		System.out.println("[4] - Apply For A Loan");
		System.out.println("[5] - Logout");

		System.out.print(":> ");

		try {
			input = br.readLine();

			switch(input) {
			case "1":
				manageAccounts();
				break;
			case "2":
				createAccount();
				break;
			case "3":
				createJointAccount();
				break;
			case "4":
				applyForLoan();
				break;
			case "5":
				logout();
				break;
			default:
				invalidInput();
				userMenu();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void logout() {
		user = null;
		mainMenu();
	}

	private static void applyForLoan() {
		// TODO Auto-generated method stub

	}

	private static void createJointAccount() {
		// TODO Auto-generated method stub

	}

	private static void createAccount() {
		// TODO Auto-generated method stub

	}

	private static void manageAccounts() {
		ArrayList<Account> accounts = userDAO.getUserAccounts(user);
		String input = "";

		System.out.println("\nSelect account to view details\n");

		for(int i = 0; i < accounts.size(); i++)
			System.out.println("[" + (i+1) + "] - " + accounts.get(i).getAccountName());

		System.out.println(":> ");

		try {
			input = br.readLine();

			int i = Integer.parseInt(input);

			if(i > 0 && i <= accounts.size()) {
				Account account = accounts.get(i-1);
				accountMenu(account);
			} else {
				invalidInput();
				manageAccounts();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			invalidInput();
			manageAccounts();
		} catch(NumberFormatException e) {
			invalidInput();
			manageAccounts();
		}
	}

	private static void accountMenu(Account account) {
		String input = "";

		System.out.println("-------------------------- ACCOUNT MENU --------------------------");

		System.out.println("[1] - View Balance");
		System.out.println("[2] - View Transaction History");
		System.out.println("[3] - Deposit");
		System.out.println("[4] - Withdraw");
		System.out.println("[5] - Transfer");
		System.out.println("[6] - Back");

		System.out.print(":> ");

		try {
			input = br.readLine();

			switch(input) {
			case "1":
				viewBalance(account);
				break;
			case "2":
				viewTransactionHistory(account);
				break;
			case "3":
				deposit(account);
				break;
			case "4":
				withdraw(account);
				break;
			case "5":
				transfer(account);
				break;
			case "6":
				userMenu();
				break;
			default:
				invalidInput();
				accountMenu(account);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Transfer money to another user

	private static void transfer(Account account) {
		ArrayList<User> users = new ArrayList<>();
		ArrayList<Account> accounts = new ArrayList<>();
		String input = "";

		// Get a list of users except for the current user
		users = userDAO.getAllUsersExcept(user.getUserID());

		System.out.println("\nSelect user to transfer to\n");
		for(int i = 0; i < users.size(); i++)
			System.out.println("[" + (i+1) + "] - " + users.get(i).getUsername());
		System.out.print(":> ");

		try {
			input = br.readLine();
			int i = Integer.parseInt(input);

			User u = users.get(i-1);

			accounts = userDAO.getUserAccounts(u);

			System.out.println("\nSelect account to transfer to\n");
			for(int j = 0; j < accounts.size(); j++)
				System.out.println("[" + (i+1) + "] - " + accounts.get(i).getAccountName());
			System.out.print(":> ");

			input = br.readLine();
			i = Integer.parseInt(input);

			Account to_account = accounts.get(i-1);

			while(true) {
				viewBalance(account);
				System.out.print("Amount to transfer :> ");

				input = br.readLine();
				double amount = Double.parseDouble(input);

				if(amount >= 0 && amount <= account.getBalance()) {
					account.setBalance(account.getBalance() - amount);
					to_account.setBalance(to_account.getBalance() + amount);

					accountDAO.updateAccount(account);
					accountDAO.updateAccount(to_account);

					System.out.println("Transfer complete");
					accountMenu(account);
					break;
				} else
					System.out.println("Invalid amount. Please try again.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			invalidInput();
			transfer(account);
		} catch (NumberFormatException e) {
			invalidInput();
			transfer(account);
		}
	}

	private static void withdraw(Account account) {
		String input = "";
		
		while(true) {
			try {
				viewBalance(account);
				System.out.print("Amount to withdraw :> ");
				input = br.readLine();
				double amount = Double.parseDouble(input);
				
				if(amount >= 0 && amount <= account.getBalance()) {
					account.setBalance(account.getBalance() - amount);
					accountDAO.updateAccount(account);
					System.out.println("Withdrawal complete");
					accountMenu(account);
				} else
					System.out.println("Invalid amount. Please try again.");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				invalidInput();
			}
		}
	}

	private static void deposit(Account account) {
		String input = "";

		while(true) {
			try {
				System.out.print("Amount to deposit :> ");
				input = br.readLine();
				double amount = Double.parseDouble(input);
				
				if(amount >= 0) {
					account.setBalance(account.getBalance() + amount);
					accountDAO.updateAccount(account);
					System.out.println("Deposit complete");
					accountMenu(account);
				} else
					System.out.println("Invalid amount. Please try again.");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				invalidInput();
			}
		}
	}

	private static void viewTransactionHistory(Account account) {
		// TODO Auto-generated method stub

	}

	private static void viewBalance(Account account) {
		System.out.printf("\nCurrent amount available: $%.2d\n", account.getBalance());
	}

	private static String hashPassword(String password, String salt) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			return bytesToHex(digest.digest((password + salt).getBytes("UTF-8")));
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			return null;
		}
	}
	
	private static void invalidInput() {
		System.out.println("Invalid input. Please try again.");
	}
	

	// Source: https://stackoverflow.com/questions/9655181/how-to-convert-a-byte-array-to-a-hex-string-in-java

	public static String bytesToHex(byte[] bytes) {
		char[] hexArray = "0123456789ABCDEF".toCharArray();
		char[] hexChars = new char[bytes.length * 2];
		for ( int j = 0; j < bytes.length; j++ ) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}


	// Source: https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string#
	private static class RandomString {

		/**
		 * Generate a random string.
		 */
		public String nextString() {
			for (int idx = 0; idx < buf.length; ++idx)
				buf[idx] = symbols[random.nextInt(symbols.length)];
			return new String(buf);
		}

		public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		public static final String lower = upper.toLowerCase(Locale.ROOT);

		public static final String digits = "0123456789";

		public static final String alphanum = upper + lower + digits;

		private final Random random;

		private final char[] symbols;

		private final char[] buf;

		public RandomString(int length, Random random, String symbols) {
			if (length < 1) throw new IllegalArgumentException();
			if (symbols.length() < 2) throw new IllegalArgumentException();
			this.random = Objects.requireNonNull(random);
			this.symbols = symbols.toCharArray();
			this.buf = new char[length];
		}

		/**
		 * Create an alphanumeric string generator.
		 */
		public RandomString(int length, Random random) {
			this(length, random, alphanum);
		}

		/**
		 * Create an alphanumeric strings from a secure generator.
		 */
		public RandomString(int length) {
			this(length, new SecureRandom());
		}
	}
}
