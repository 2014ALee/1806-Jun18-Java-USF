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
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.dao.ImplementCustomerInt;

public class Bank {

	private int numOfCustomers = 0;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static ImplementCustomerInt db = new ImplementCustomerInt();

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

	//MAINMENU
	public static void mainMenu() {
		String userInput;

		System.out.println("                      ---------");
		System.out.println("                      MAIN MENU");
		System.out.println("                      ---------");

		System.out.println("\r\n[1] - Login");
		System.out.println("[2] - Register");
		System.out.println("[3] - Exit");

		System.out.print("Selection: ");

		try {
			userInput = reader.readLine();

			switch(userInput) {
			case "1":
				wipeScreen();
				login();
				break;
			case "2":
				wipeScreen();
				register();
				break;
			case "3":
				wipeScreen();
				System.out.println("Exiting bank app...");
				break;
			default: 
				wipeScreen();
				System.out.println("       Incorrect Inuput - Please Enter 1, 2 or 3\n");
				mainMenu();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//LOGIN
	public static void login() {
		System.out.println("                    ---------");
		System.out.println("                      LOGIN");
		System.out.println("                    ---------");

		try {

			System.out.println("Enter Username and Password");
			System.out.print("Username: ");
			String username = reader.readLine();

			System.out.print("Password: ");
			String password = reader.readLine();

			Customers cus = checkCredentials(username, password);

			if(cus != null) {

				if (cus.getUserName().equals("admin")) {
					adminView();
				} else {
					wipeScreen();
					action(cus);
				}
			}else {
				wipeScreen();
				System.out.println("Username or Password is Incorrect\n");
				mainMenu();
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

					//REGISTER
	public static void register() {
		System.out.println("                      --------");
		System.out.println("                      REGISTER");
		System.out.println("                      --------\n");
		System.out.println("Choose Username and Password");


		try {

			System.out.print("Username: ");
			String username = reader.readLine();

			System.out.print("Password: ");
			String password = reader.readLine();

			if(isUsernameAvailable(username)) {
				Customers cus = new Customers(username, password);
				db.addCustomer(cus);
				wipeScreen();
				System.out.println("Congradulations! Your Account was created successfully.\n");
				mainMenu();

			}else {
				wipeScreen();
				System.out.println("....Username is NOT available....\n");
				mainMenu();
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

					//ACTION CUSTOMERS CAN DO
	public static void action(Customers cus) {
		//System.out.println("                      -------");
		System.out.println("                      WELCOME "+ cus.getUserName());
		//System.out.println("                      -------");

		System.out.println("[1] - Deposit");
		System.out.println("[2] - Withdraw");
		System.out.println("[3] - Show Balance");
		System.out.println("[4] - Log Out");
		System.out.print("Selection: ");
		try {
			String userInput = reader.readLine();

			switch(userInput) {
			case "1":
				wipeScreen();
				deposite(cus);
				break;
			case "2":
				wipeScreen();
				withdraw(cus);
				break;
			case "3":
				wipeScreen();
				System.out.println("Current Balance = $" + cus.getBalance() + "\n");

				action(cus);
				break;
			case "4":
				wipeScreen();
				mainMenu();
				break;
			default:
				System.out.println("\r\nChoose from numbers 1-4: \n");
				action(cus);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
					//DEPOSITE CASH
	public static void deposite(Customers cus) {
		System.out.println("How much would you like to Deposite?");
		System.out.print("Enter amount: ");

		Scanner scan = new Scanner(System.in);

		//check for inputMismatch
		try {
			float userInput = scan.nextFloat();

			userInput = Math.abs(userInput);
			cus.setBalance((cus.getBalance()  + userInput));
			System.out.println("You just added " + userInput + " to your account\n");
			db.updateBalance(cus);
			action(cus);

		} catch (InputMismatchException i) {
			System.out.println("Enter a valid number\n");
		} 


	}

						//WITHDRAW
	public static void withdraw(Customers cus) {
		System.out.println("How much would you like to Withdraw?");
		System.out.print("Enter amount: ");


		Scanner scan = new Scanner(System.in);

		float userInput = Math.abs(scan.nextFloat());


		if(userInput > cus.getBalance()) {
			System.out.println("\r\nYou don't have enough funds to withdraw: $" + userInput +"\n");
			action(cus);
		} else {
			cus.setBalance(cus.getBalance()  - userInput);
			System.out.println("\r\nYou just withdrew $" + userInput + " from your account\n");
			db.updateBalance(cus);
			action(cus);
		}

	}

						//CHECK IF USERNAME IS AVAILABLE
	public static boolean isUsernameAvailable(String username) {

		if(db.getCustomerByUsername(username) == null) {
			return true;
		} else {return false;}

	}

						//CHECK IF USERNAME AND PASSWORD MATCH
	public static Customers checkCredentials(String username, String password) {

		Customers cus = new Customers();

		if((cus = db.getCustomerByUsername(username)) != null) {
			if ((cus.getUserName().equals(username)) && (cus.getPassword().equals(password)) ){

				return cus;
			} else {return null;}
		} else {return null;}


	}
	
				//ADMINISTRATOR VIEW
	private static void adminView() {
		int counter = 0;
		ArrayList<Customers> allCustomers = db.getAllCustomers();
		
		wipeScreen();
		System.out.println("                      WELCOME ADMINISTRATOR");
		
		try {
			System.out.println("[1] - Total Customers");
			System.out.println("[2] - Display All Customers");
			System.out.println("[3] - Log Out");
			System.out.print("Selection: ");
			String input = reader.readLine();
			
			switch(input) {
				case "1":
					wipeScreen();
					for (Customers cus : allCustomers) {
						if (cus.getUserName().equals("admin")) continue;
						counter++;
					}
					System.out.println("There are "+counter+" customers register to this bank.\n");
					adminView();	
					break;
				case "2":
					wipeScreen();
					System.out.println("Customers List: ");
					for (Customers cus : allCustomers) {
						if (cus.getUserName().equals("admin")) continue;
						System.out.println("				"+cus.getUserName());		
					}
					adminView();
					break;
				case "3":
					wipeScreen();
					mainMenu();
					break;
				default:
					System.out.println("Choose numbers between 1-3\n");
					adminView();
					
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void wipeScreen() {
		for (int i = 0; i < 4; i++) {
			System.out.println();
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
