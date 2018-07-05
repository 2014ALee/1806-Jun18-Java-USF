package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.revature.dao.AccountDAOImpl;
import com.revature.dao.TransactionDAOImpl;
import com.revature.models.Account;
import com.revature.models.Transaction;

public class TransactionMenu {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static TransactionDAOImpl transDAO = new TransactionDAOImpl();
	private static Account currentAccount = null;
	private static AccountDAOImpl accountDAO = new AccountDAOImpl();
	
	public static void withdrawMenu(Account account) {
		double balance = account.getBalance();
		currentAccount = account;
		System.out.println("Enter the amount you would like to withdraw.");
		
		double withdraw;
		try {
			
			withdraw = Double.valueOf(br.readLine());
			if (withdraw < 0) {
				System.out.println("Invalid input. Please try again.");
				depositMenu(currentAccount);
			}
			
			String text = Double.toString(Math.abs(withdraw));
			int integerPlaces = text.indexOf('.');
			int decimalPlaces = text.length() - integerPlaces - 1;
			
			if (decimalPlaces > 2) {
				System.out.println("Invalid input. Please try again.");
				depositMenu(currentAccount);
			}
			
			if (balance - withdraw < 0) {
				System.out.println("Insuffiecient funds. Returning to account menu.");
				Thread.sleep(2000);
				AccountMenu.accountMenu(currentAccount);
			} else {
				account.setBalance(balance - withdraw);
				
				Transaction transaction = new Transaction(1, currentAccount.getAccountId(), withdraw);
				transaction = transDAO.createTransaction(transaction);
				accountDAO.withdraw(currentAccount.getAccountId(), withdraw);
				System.out.println("Balance is now $" + (balance - withdraw));
				Thread.sleep(2000);
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("Invalid number entered. Please try again.");
			AccountMenu.accountMenu(currentAccount);
		} catch (InterruptedException e) {
			System.out.println("Error occured. Please try again.");
			withdrawMenu(currentAccount);
		}
		anotherTransaction(currentAccount);
	}

	public static void depositMenu(Account account) {
		currentAccount = account;
		double balance = account.getBalance();
		System.out.println("Enter the amount you would like to deposit.");
		
		double deposit;
		try {
			
			deposit = Double.parseDouble(br.readLine());
			if (deposit < 0) {
				System.out.println("Invalid input. Please try again.");
				depositMenu(currentAccount);
			}
			
			String text = Double.toString(Math.abs(deposit));
			int integerPlaces = text.indexOf('.');
			int decimalPlaces = text.length() - integerPlaces - 1;
			
			if (decimalPlaces > 2) {
				System.out.println("Invalid input. Please try again.");
				depositMenu(currentAccount);
			}
			
			if(String.valueOf(deposit).length() > 30) {
				System.out.println("Invalid input.");
				depositMenu(currentAccount);
			}
			
			account.setBalance(balance + deposit);
			transDAO.createTransaction(new Transaction(1, currentAccount.getAccountId(), deposit));
			accountDAO.deposit(currentAccount.getAccountId(), deposit);
			System.out.println("Balance is now $" + (balance + deposit));
			Thread.sleep(2000);
			
		} catch (NumberFormatException | IOException e) {
			System.out.println("Invalid number entered. Please try again.");
			AccountMenu.accountMenu(currentAccount);
		} catch (InterruptedException e) {
			System.out.println("Error occured. Please try again.");
			withdrawMenu(currentAccount);
		}
		anotherTransaction(currentAccount);
	}
	
	private static void anotherTransaction(Account currentAccount) {
		try {
			System.out.println("Would you like to make another transaction?");
			System.out.println("[1] Yes, return to account menu.");
			System.out.println("[2] No, logout and end session.");
			
			String input = br.readLine();
			
			switch(input) {
			case "1":
				AccountMenu.accountMenu(currentAccount);
				break;
			case "2":
				System.out.println("Thank you for your business. Have a nice day!");
				Thread.sleep(2000);
				currentAccount = null;
				MainMenu.mainMenu();
				break;
			default: 
				System.out.println("Invalid input. Please try again.");
				anotherTransaction(currentAccount);
			}			
			
		} catch (IOException ioe) {
			System.out.println("Error occured while reading value. Please try again");
		} catch (InterruptedException e) {
			System.out.println("Error occured. Please try again");
			anotherTransaction(currentAccount);
		}
	}

	public static void displayTransactions(Account account) {
		System.out.println("---------Transactions---------");
		ArrayList<Transaction> transactions = new ArrayList<>();
		transactions = transDAO.getAllTransaction(account);
		
		int counter = 1;
		for (Transaction trans : transactions) {
			System.out.println("[" + counter + "] -(Transaction ID: " + trans.getTransactionid() 
			+ ") Transaction amount: $" + trans.getAmount() + ".");
			counter++;
		}
		anotherTransaction(account);
	}

}
