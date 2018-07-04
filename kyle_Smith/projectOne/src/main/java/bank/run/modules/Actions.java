package bank.run.modules;

import java.text.DecimalFormat;

import bank.run.dao.AccountDAOImpl;
import bank.run.dao.JointAccDAOImpl;
import bank.run.dao.UserDAOImpl;
import bank.run.util.Account;

public class Actions extends Validate{
	private static UserDAOImpl userImpl = new UserDAOImpl();
	private static AccountDAOImpl accountImpl = new AccountDAOImpl();
	private static JointAccDAOImpl jointImpl = new JointAccDAOImpl();
	
	public static void deposit() {
		double deposit = 0;
		System.out.println("Deposit to Checking or Savings?");
		System.out.println("[1] Checking: $" + Account.getChecking());
		System.out.println("[2] Savings: $" + user.getSavings());
		System.out.println("[3] Cancel");
		int read = 0;
		if(sc.hasNextInt()) {
			read = sc.nextInt();
		}else {
			System.out.println("Invalid input please try again...");
			sc.nextLine();
			deposit();
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
							user.setChecking(user.getChecking() + Double.valueOf(df.format(Math.abs(deposit))));
							System.out.println("Deposited $" + Double.valueOf(df.format(Math.abs(deposit))) + " successfully.");
							System.out.println("New Balance: $" + user.getChecking());
							break;
						}else if (read == 2) {
							user.setSavings(user.getSavings() + Double.valueOf(df.format(Math.abs(deposit))));
							System.out.println("Deposited $" + Double.valueOf(df.format(Math.abs(deposit))) + " successfully.");
							System.out.println("New Balance: $" + user.getSavings());
							break;
						}
					}else if(i == 3) {
						System.out.println("To many atempts please try again");
						deposit();
					}else {
					System.out.println("Please enter money in correct format...");
					sc.next();
					}
				}
			case 3:
				Menu.mainMenu(1);
			default: 
				System.out.println("Invalid selection, please try again.");
				deposit();
		}
	}

	public static void withdraw() {
		double withdraw = 0;
		System.out.println("Withdraw from Checking or Savings?");
		System.out.println("[1] Checking: $" + user.getChecking());
		System.out.println("[2] Savings: $" + user.getSavings());
		System.out.println("[3] Cancel");
		int read = 0;
		if(sc.hasNextInt()) {
			read = sc.nextInt();
		}else {
			System.out.println("Invalid input please try again...");
			sc.nextLine();
			withdraw();
		}
		DecimalFormat df = new DecimalFormat("###.##");
		switch(read) {
			case 1:
			case 2:

				for(int i = 0; i <=3; i++) {
					System.out.print("Enter Amount to Withdraw: ");
					if(sc.hasNextDouble()) {
						withdraw = sc.nextDouble();
						if(((read==1 ? user.getChecking() : user.getSavings()) - Double.valueOf(df.format(Math.abs(withdraw)))) < 0) {
							System.out.println("Cannot overdraft account try again...");
							continue;
						}
						if(read == 1) {
							user.setChecking(user.getChecking() - Double.valueOf(df.format(Math.abs(withdraw))));
							System.out.println("Withdrawen $" + Double.valueOf(df.format(Math.abs(withdraw))) + " successfully.");
							System.out.println("New Balance: $" + user.getChecking());
							break;
						}else if (read == 2){
							user.setSavings(user.getSavings() - Double.valueOf(df.format(Math.abs(withdraw))));
							System.out.println("Withdrawen $" + Double.valueOf(df.format(Math.abs(withdraw))) + " successfully.");
							System.out.println("New Balance: $" + user.getSavings());
							break;
						}
					}else if(i == 3) {
						System.out.println("To many atempts please try again");
						withdraw();
					}else {
					System.out.println("Please enter money in correct format...");
					sc.next();
					}
				}
				System.out.println("too many attempts...");
			case 3:
				Menu.mainMenu(1);
				break;
			default: 
				System.out.println("Invalid selection, please try again.");
				withdraw();
		}
	}

	public static void balanceCheck () {
		System.out.println("Checking Balance: " + user.getChecking());
		System.out.println("Savings Balance: " + user.getSavings());
	}
	
	public static void transferFunds() {
		int from = 0;
		int to = 0;
		System.out.println("-----------------Transfer Funds-----------------");
		System.out.println("From: ");
		if(sc.hasNextInt())
			from = sc.nextInt();
		else {
			System.out.println("invalid selection");
			sc.next();
			transferFunds();
		}
		System.out.println("\t[1] Checking: $" + user.getChecking());
		System.out.println("\t[2] Savings: $" + user.getSavings());
		System.out.println("\t[3] Cancel");
		if(from == 3)
			Menu.mainMenu(1);
		System.out.println("To: ");
		if(sc.hasNextInt())
			to = sc.nextInt();
		else {
			System.out.println("invalid selection");
			sc.next();
			transferFunds();
		}
		System.out.println("\t[1] Checking: $" + user.getChecking());
		System.out.println("\t[2] Savings: $" + user.getSavings());
		System.out.println("\t[3] Cancel");
		if(to == 3)
			Menu.mainMenu(1);
		
		
		
	}
}
