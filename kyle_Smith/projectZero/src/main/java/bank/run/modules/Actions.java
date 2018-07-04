package bank.run.modules;

import java.text.DecimalFormat;
import java.util.Scanner;

import bank.run.dao.AccountDAOImpl;
import bank.run.dao.JointAccDAOImpl;
import bank.run.dao.UserDAOImpl;
import bank.run.util.Account;
import bank.run.util.User;

public class Actions{
	private static UserDAOImpl userImpl = new UserDAOImpl();
	private static AccountDAOImpl accountImpl = new AccountDAOImpl();
	private static JointAccDAOImpl jointImpl = new JointAccDAOImpl();
	private static Scanner sc = new Scanner(System.in);
	
	public static void deposit(Object...args) {
		Account acc = new Account();
		acc = accountImpl.getAccountByUserId(((User)args[0]).getUserID());
		double deposit = 0;
		System.out.println("Deposit to Checking or Savings?");
		System.out.println("[1] Checking: $" + acc.getChecking());
		System.out.println("[2] Savings: $" + acc.getSavings());
		System.out.println("[3] Cancel");
		int read = 0;
		if(sc.hasNextInt()) {
			read = sc.nextInt();
		}else {
			System.out.println("Invalid input please try again...");
			sc.nextLine();
			deposit(args);
		}
		DecimalFormat df = new DecimalFormat("###.##");
		switch(read) {
			case 1:
			case 2:
				for(int i = 0; i <=3; i++) {
					System.out.print("Enter Amount to Deposit: ");
					if(sc.hasNextDouble()) {
						deposit = sc.nextDouble();
						if(read == 1) {
							acc.setChecking(acc.getChecking() + Double.valueOf(df.format(Math.abs(deposit))));
							System.out.println("Deposited $" + Double.valueOf(df.format(Math.abs(deposit))) + " successfully.");
							System.out.println("New Balance: $" + acc.getChecking());
							break;
						}else if (read == 2) {
							acc.setSavings(acc.getSavings() + Double.valueOf(df.format(Math.abs(deposit))));
							System.out.println("Deposited $" + Double.valueOf(df.format(Math.abs(deposit))) + " successfully.");
							System.out.println("New Balance: $" + acc.getSavings());
							break;
						}
					}else if(i == 3) {
						System.out.println("To many atempts please try again");
						deposit(args);
					}else {
					System.out.println("Please enter money in correct format...");
					sc.next();
					}
				}
				accountImpl.updateAccount(acc);
			case 3:
				Menu.mainMenu(1, args);
			default: 
				System.out.println("Invalid selection, please try again.");
				deposit(args);
		}
	}

	public static void withdraw(Object...args) {
		DecimalFormat df = new DecimalFormat("###.##");
		Account acc = new Account();
		acc = accountImpl.getAccountByUserId(((User)args[0]).getUserID());
		double withdraw = 0;
		System.out.println("Withdraw from Checking or Savings?");
		System.out.println("[1] Checking: $" + df.format(acc.getChecking()));
		System.out.println("[2] Savings: $" + df.format(acc.getSavings()));
		System.out.println("[3] Cancel");
		int read = 0;
		if(sc.hasNextInt()) {
			read = sc.nextInt();
		}else {
			System.out.println("Invalid input please try again...");
			sc.nextLine();
			withdraw(args);
		}
		
		switch(read) {
			case 1:
			case 2:
				for(int i = 0; i <=3; i++) {
					System.out.print("Enter Amount to Withdraw: ");
					if(sc.hasNextDouble()) {
						withdraw = sc.nextDouble();
						if(((read==1 ? acc.getChecking() : acc.getSavings()) - Double.valueOf(df.format(Math.abs(withdraw)))) < 0) {
							System.out.println("Cannot overdraft account try again...");
							continue;
						}
						if(read == 1) {
							acc.setChecking(acc.getChecking() - Double.valueOf(df.format(Math.abs(withdraw))));
							System.out.println("Withdrawen $" + Double.valueOf(df.format(Math.abs(withdraw))) + " successfully.");
							System.out.println("New Balance: $" + acc.getChecking());
							break;
						}else if (read == 2){
							acc.setSavings(acc.getSavings() - Double.valueOf(df.format(Math.abs(withdraw))));
							System.out.println("Withdrawen $" + Double.valueOf(df.format(Math.abs(withdraw))) + " successfully.");
							System.out.println("New Balance: $" + acc.getSavings());
							break;
						}
					}else if(i == 3) {
						System.out.println("To many atempts please try again");
						withdraw(args);
					}else {
					System.out.println("Please enter money in correct format...");
					sc.next();
					}
				}
				accountImpl.updateAccount(acc);
			case 3:
				Menu.mainMenu(1, args);
				break;
			default: 
				System.out.println("Invalid selection, please try again.");
				withdraw(args);
		}
	}

	public static void balanceCheck (Object...args) {
		DecimalFormat df = new DecimalFormat("###.##");
		Account acc = new Account();
		acc = accountImpl.getAccountByUserId(((User)args[0]).getUserID());
		System.out.println("Checking Balance: $" + df.format(acc.getChecking()));
		System.out.println("Savings Balance: $" + df.format(acc.getSavings()));
		Menu.mainMenu(1, args);
	}
	public static void adminBalance (Object...args) {
		DecimalFormat df = new DecimalFormat("###.##");
		Account acc = new Account();
		acc = accountImpl.totalBankSum();
		System.out.println("Checking Total Sum: $" + df.format(acc.getChecking()));
		System.out.println("Savings Total Sum: $" + df.format(acc.getSavings()));
	}
	
	public static void transferFunds(Object...args) {
		Account acc = new Account();
		acc = accountImpl.getAccountByUserId(((User)args[0]).getUserID());
		int from = 0;
		int to = 0;
		double transfer = 0;
		System.out.println("-----------------Transfer Funds-----------------");
		System.out.println("From: ");
		if(sc.hasNextInt())
			from = sc.nextInt();
		else {
			System.out.println("invalid selection");
			sc.next();
			transferFunds(args);
		}
		System.out.println("\t[1] Checking: $" + acc.getChecking());
		System.out.println("\t[2] Savings: $" + acc.getSavings());
		System.out.println("\t[3] Cancel");
		if(from == 3)
			Menu.mainMenu(1, args[1]);
		System.out.println("To: ");
		if(sc.hasNextInt())
			to = sc.nextInt();
		else {
			System.out.println("invalid selection");
			sc.next();
			transferFunds(args);
		}
		System.out.println("\t[1] Checking: $" + acc.getChecking());
		System.out.println("\t[2] Savings: $" + acc.getSavings());
		System.out.println("\t[3] Cancel");
		if(to == 3)
			Menu.mainMenu(1, args[1]);
		System.out.println("Amount To Transfer: ");
		
		
		
	}
}
