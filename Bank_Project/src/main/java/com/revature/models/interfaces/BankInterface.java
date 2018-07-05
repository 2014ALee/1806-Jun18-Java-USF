package com.revature.models.interfaces;


public interface BankInterface  {

	public void startApplication();

	public static void registerAccount() {};
	public static void logIn() {};

	public static void mainMenu() {};
	public static void loggedInMenu(String userName) {};
			
	public static void withdrawMoney(String userName) {};
	public static void depositMoney(String userName) {};
	
}
