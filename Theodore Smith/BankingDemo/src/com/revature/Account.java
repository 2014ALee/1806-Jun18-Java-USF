package com.revature;

import java.util.Scanner;

public class Account {
	
	
	public static void main(String[] args) {
		
		BankAccount obj1 = new BankAccount();
		obj1.showMenu();
		
	}
}
	
	class BankAccount {
		
		int balance1;
		//int previousTransaction;
		//String customerName;
		//String customerId;
		
		void deposit(int amount)
		{
			if(amount != 0)
			{
				balance1 = balance1 + amount;
				//previousTransaction = amount;
			}
		}
		
		void withdraw(int amount) {
			
			if(amount != 0)
			{
				balance1 = balance1 - amount;
				//previousTransaction = amount;
			
			}
			
		}
	
	void showMenu()
	{
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("A. Check My Balance ");
		System.out.println("B. Deposit My Funds ");
		System.out.println("C. Withdraw My Funds ");
		System.out.println("E. Exit Application ");
		
		do
		{
			System.out.println("+---------------------------+");
			System.out.println("Choose from the following ");
			System.out.println("+---------------------------+");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch(option)
			{
			case 'A' :
				System.out.println("Your Current Balance = " + balance1);
				System.out.println("+---------------------------+");
				System.out.println("\n");
				break;
				
			case 'B' :
				System.out.println(" How much will you be depositing ");
				System.out.println("+---------------------------+");
				int amount1 = scanner.nextInt();
				deposit(amount1);
				System.out.println("\n");
				break;
			
			case 'C' :
				System.out.println(" How much will you be withdrawing ");
				System.out.println("+---------------------------+");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'E' :
				System.out.println(" Thank you and have a good day ");
				break;
				
			
				
			default :
				System.out.println(" You have choose an invalid option please try again ");
				break;
			}
		} while(option != 'f');
		System.out.println("Thank You for using MyBank please come again");
	}
	
	}