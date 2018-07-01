package com.revature;

import java.io.File;

import com.revature.models.userData;
import com.revature.dao.userDAO;
import com.revature.dao.userDAOImpl;

public class registerDriver extends menuDriver {

//	public static Scanner input = new Scanner(System.in);
//	public static Scanner loggedInput = new Scanner(System.in);
//	public static userData theUser = null;
	static userDAO userdao = new userDAOImpl();
	
	public static void register() {
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
			userdao.createUser(theUser);
			mainMenu();
		}
		else
		{
			register();
		}
	}
	private static boolean checkAvailability(userData user) {
		if(userdao.checkForUser(user)){
			if(userdao.checkForEmails(user)) {
				return true;
			}
			else {
				System.out.println("=====================Email Unavailible=======================");
				return false;
			}
		}
		else{
			System.out.println("===================Username Unavailible=======================");
			return false;
		}
	}
}
