package com.revature;


public class loginDriver extends menuDriver {
	public static String userName;
	public static String password;
	public static void login() {

		System.out.println("====================Enter Username=====================");
		System.out.print("User >");
		userName = input.nextLine();

		System.out.println("====================Enter Password=====================");
		System.out.print("User >");
		password = input.nextLine();

		if(registerDriver.userdao.validLogin(userName, password))
		{
			System.out.println("========================Logging In=========================");
			loggedInMenu(userName,password);
		}
		else
		{
			System.out.println("========================Invalid Login======================");
			mainMenu();
		}
	}

}
