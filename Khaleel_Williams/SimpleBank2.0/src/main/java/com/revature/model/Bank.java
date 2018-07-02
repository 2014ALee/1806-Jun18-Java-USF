package com.revature.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Bank {

	private int numOfCustomers = 0;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


	public Bank() {}
 
	public Bank(int numOfCustomers) {
		super();
		this.numOfCustomers = numOfCustomers;
	}

	public int getNumOfCustomers() {
		return numOfCustomers;
	}

	public void setNumOfCustomers(int numOfCustomers) {
		this.numOfCustomers = numOfCustomers;
	}

	public static void mainMenu() {
		String userInput;

		System.out.println("		MAIN MENU		");

		System.out.println("\r\n[1] - Login");
		System.out.println("[2] - Register");
		System.out.println("[3] - Cancle");

		System.out.print("Selection: ");

		try {
			userInput = reader.readLine();

			switch(userInput) {
			case "1":
				login();
				break;
			case "2":
				register();
				break;
			case "3":
				System.out.println("Exiting bank program");
				break;
			default:
				System.out.println("Incorrect Inuput - Please Enter 1 or 2");
				mainMenu();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





	}

	public static void login() {
		System.out.println("		LOGIN		");

		try {

			System.out.println("Enter Username and Password");
			System.out.print("Username: ");
			String username = reader.readLine();

			System.out.print("Password: ");
			String password = reader.readLine();

			Customers cus = checkCredentials(username, password);

			if(cus != null) {
				action(cus);
			}else {
				System.out.println("Username or Password is Incorrect");
				mainMenu();
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void register() {

		System.out.println("		REGISTER		");
		System.out.println("Choose Username and Password");


		try {

			System.out.print("Username: ");
			String username = reader.readLine();

			System.out.print("Password: ");
			String password = reader.readLine();

			if(isUsernameAvailable(username)) {
				Customers cus = new Customers(username, password);
				serializeUser(cus);
				System.out.println("Congradulations! Your Account was created successfully.");
				mainMenu();

			}else {
				System.out.println("....Username is NOT available....");
				register();
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void action(Customers cus) {
		System.out.println("You are now logged in.");

		System.out.println("[1] - Deposit");
		System.out.println("[2] - Withdraw");
		System.out.println("[3] - Show Balance");
		System.out.println("[4] - Log Out");
		System.out.print("Selection: ");
		try {
			String userInput = reader.readLine();

			switch(userInput) {
			case "1":
				deposite(cus);
				break;
			case "2":
				withdraw(cus);
				break;
			case "3":
				System.out.println("Current Balance = " + cus.getBalance());
				action(cus);
				break;
			case "4":
				mainMenu();
			default:
				System.out.println("Incorrect Input: ");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public static void deposite(Customers cus) {
		System.out.println("How much would you like to Deposite?");
		System.out.print("Enter amount: ");

		Scanner scan = new Scanner(System.in);
		int userInput = scan.nextInt();

		if (userInput >= 0) {
			cus.setBalance((cus.getBalance()  + userInput));
			System.out.println("You just added " + userInput + " to your account");
			serializeUser(cus);
			action(cus);


		}else {
			System.out.println("Incorrect Input /n Enter 0 or a positive number.");
			deposite(cus);
			
		}

		

	}

	public static void withdraw(Customers cus) {
		System.out.println("How much would you like to Withdraw?");
		System.out.print("Enter amount: ");


		Scanner scan = new Scanner(System.in);
		int userInput = scan.nextInt();

		if (userInput >= 0) {
			cus.setBalance(cus.getBalance()  - userInput);
		}else if(userInput > cus.getBalance()) {
			System.out.println("You don't have enough funds to withdraw: " + userInput);
			withdraw(cus);

		}else {
			System.out.println("Incorrect Input /n Enter 0 or a positive number.");
			withdraw(cus);
		}

		serializeUser(cus);
		action(cus);

	}

	public static boolean isUsernameAvailable(String username) {

		String fileName = username + ".acct";
		File file = new File(fileName);

		if(file.exists()) {
			return false;
		}else {
			return true;
		}

	}

	public static Customers checkCredentials(String username, String password) {

		String fileName = username + ".acct";

		ObjectInputStream inputStream;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(fileName));
			Customers cus = (Customers) inputStream.readObject();

			if (cus != null) {

				if(username.equals(cus.getUserName()) & password.equals(cus.getPassword())) {
					inputStream.close();
					return cus;
				}else {
					inputStream.close();
					return null;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Incorrect username or password");
			mainMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Incorrect username or password");
			mainMenu();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Incorrect username or password");
			mainMenu();
		}

		return null;
	}

	private static void serializeUser(Customers cus) {

		String fileName = cus.getUserName() + ".acct";

		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			//oos.flush();
			oos.writeObject(cus);
			oos.close();


		} catch (FileNotFoundException e) {
			System.out.println("[LOG] - An error occurred while accessing the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occurred while writing the file");
			e.printStackTrace();
		}
	}








	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numOfCustomers;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (numOfCustomers != other.numOfCustomers)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bank [numOfCustomers=" + numOfCustomers + "]";
	}


}
