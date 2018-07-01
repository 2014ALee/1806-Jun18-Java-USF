package com.revature;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.revature.models.userData;

public class mainDriver {
	private static Scanner input = new Scanner(System.in);
	private static Scanner loggedInput = new Scanner(System.in);
	private static userData theUser = null;

	public static void main(String[] args) {

		System.out.println("============Welcome to the Big Buford Bank=============");
		System.out.println("=======================================================");
		mainMenu();
	}

	private public static void mainMenu() {
		String userInput;

		System.out.println("======================Main Menu========================");
		System.out.println("=======================================================");

		System.out.println("==================Enter \"1\" to log in==================");
		System.out.println("==================Enter \"2\" to Register================");
		System.out.println("===========Enter \"3\" to Terminate the Program==========");
		System.out.print("User >");
		userInput = input.nextLine();
		switch(userInput) {
		case "1":
			System.out.println("===================Logging in=======================");
			login();
			break;
		case "2":
			System.out.println("============Loading Registration Menu===============");
			register();
			break;
		case "3":
			System.out.println("===================Goodbye==========================");
			System.exit(0);
			break;
		default:
			System.out.println("============Invalid input, try again================");
			mainMenu();

		}
	}

	private static void logout() {
		theUser = null;
		mainMenu();

	}

	private static void register() {
		String firstName;
		String lastName;
		String userName;
		String password;
		String email;

		System.out.println("=======================================================");
		System.out.println("======================First Name=======================");
		System.out.print("User >");
		firstName = input.nextLine();

		System.out.println("=======================================================");
		System.out.println("=======================Last Name=======================");
		System.out.print("User >");
		lastName = input.nextLine();

		System.out.println("=======================================================");
		System.out.println("========================Username=======================");
		System.out.print("User >");
		userName = input.nextLine();

		System.out.println("=======================================================");
		System.out.println("========================Password=======================");
		System.out.print("User >");
		password = input.nextLine();

		System.out.println("=======================================================");
		System.out.println("======================== E-mail =======================");
		System.out.print("User >");
		email = input.nextLine();

		theUser = new userData(firstName,lastName,userName,password,email);
		if(checkAvailability(theUser))
		{
			System.out.println("===================Creating User========================");
			serializeUser(theUser);
			mainMenu();
		}
		else
		{
			System.out.println("================Username Unavailible=====================");
			register();
		}

	}

	private static void serializeUser(userData user) {
		String fileName = user.getUserName()+".txt";
		try(FileOutputStream fos = new FileOutputStream(fileName); ObjectOutputStream oos = new ObjectOutputStream(fos);)
		{
			oos.writeObject(user);
		} catch (FileNotFoundException e) {
			System.out.println("=================ERROR-File Not Found===================");
			e.printStackTrace();
			mainMenu();
		} catch (IOException e) {
			System.out.println("=================ERROR-Input Failure====================");
			e.printStackTrace();
			mainMenu();
		}

	}

	private static boolean checkAvailability(userData user) {
		String fileName =user.getUserName()+".txt";
		File theFile = new File(fileName);
		if(theFile.exists())
		{
			return false;
		}
		else
		{
			return true;
		}

	}

	private static void login() {
		String userName;
		String password;
		// TODO Auto-generated method stub
		System.out.println("====================Enter Username=====================");
		System.out.print("User >");
		userName = input.nextLine();

		System.out.println("====================Enter Password=====================");
		System.out.print("User >");
		password = input.nextLine();

		if(validLogin(userName, password))
		{
			System.out.println("========================Logging In=========================");
			loggedInMenu();
		}
		else
		{
			System.out.println("========================Invalid Login======================");
		}
	}

	private static void loggedInMenu() {
		double inputNum;
		System.out.println("======================Welcome "+ theUser.getFirstName()+"========================");

		System.out.println("==================Enter \"1\" to view balance==================");
		System.out.println("==================Enter \"2\" to make deposits=================");
		System.out.println("==================Enter \"3\" to make withdrawls===============");
		System.out.println("=====================Enter \"4\" to Log Out====================");
		System.out.print(theUser.getUserName()+" >");
		String userInput = input.nextLine();
		switch(userInput) {
		case "1":
			System.out.println("====================BALANCE========================");
			System.out.println("Balance: $"+theUser.getBalance());
			loggedInMenu();
			break;
		case "2":
			System.out.println("==============ENTER DEPOSIT AMOUNT=================");
			System.out.print(theUser.getUserName()+" >");
			inputNum =loggedInput.nextDouble();
			deposit(theUser, inputNum);
			System.out.println("============Current Balance: $"+theUser.getBalance()+"==============");
			loggedInMenu();
			break;
		case "3":
			System.out.println("============ENTER WITHDRAWL AMOUNT=================");
			System.out.print(theUser.getUserName()+" >");
			inputNum = loggedInput.nextDouble();
			withdraw(theUser, inputNum);
			System.out.println("============Current Balance: $"+theUser.getBalance()+"==============");
			loggedInMenu();
			break;
		case "4":
			System.out.println("===================Goodbye "+theUser.getUserName()+"==========================");
			logout();
			break;
		default:
			System.out.println("=========Please select one of the options.==========");
			System.out.println("============Invalid input, try again================");
			loggedInMenu();

		}

	}
	private static void serializeData(userData user) {
		String fileName = user.getUserName()+".txt";
		try(FileOutputStream fos = new FileOutputStream(fileName); ObjectOutputStream oos = new ObjectOutputStream(fos);)
		{
			oos.writeObject(user);
		} catch (FileNotFoundException e) {
			System.out.println("=================ERROR-File Not Found===================");
			e.printStackTrace();
			mainMenu();
		} catch (IOException e) {
			System.out.println("=================ERROR-Input Failure====================");
			e.printStackTrace();
			mainMenu();
		}

	}

	private static double withdraw(userData user, double withdrawnAmount) {
		double temp = user.getBalance();
		if((temp - withdrawnAmount) >= 0)
		{
			System.out.println("==========$"+withdrawnAmount+"====WITHDRAWN.========");
			user.setBalance(temp - withdrawnAmount);
		}
		else
		{
			System.out.println("==============Insufficient Funds===================");
		}
		serializeData(user);
		return user.getBalance();

	}

	private static double deposit(userData user, double withdrawnAmount) {
		double temp = user.getBalance();

		System.out.println("==========$"+withdrawnAmount+"====DEPOSITED.========");
		user.setBalance(temp + withdrawnAmount);
		serializeData(user);
		return user.getBalance();	
	}

	private static boolean validLogin(String userName, String password) {
		String fileName = userName+".txt";

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))
		{
			theUser = (userData) ois.readObject();
			if(theUser != null)
			{
				if(userName.equals(theUser.getUserName()) & password.equals(theUser.getPassword()))
				{
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("=================ERROR-File Not Found===================");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("=================ERROR-Class Not Found==================");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("=================ERROR-Input Failure====================");
			e.printStackTrace();
		}
		return false;
	}

}
