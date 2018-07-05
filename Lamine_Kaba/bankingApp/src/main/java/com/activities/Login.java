package com.activities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.Scanner;

import com.revature.models.User;

public class Login {
	
	static Scanner userInput = new Scanner(System.in);
	static User user = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void login() {
		
		String username, password;
		
		System.out.println("\n    +--------------LOGIN--------------+");
		
		try {
			
			System.out.print("Username: ");
			username = br.readLine();
			
			System.out.print("Password: ");
			password = br.readLine();
			
			if(HelperMethods.credentialsValidation(username, password)) {
				
				System.out.println("Login successful!");
				user = new User();
				user.setUsername(username);
				Activity.activities();
			} else {
				System.out.println("User not found!");
				System.out.println("First time user, please select option 2\n");
				Main.mainMenu();
			}
			
		} catch (IOException e) {
			System.out.println("User not fund! \nFirst time user, please select option 2");
			System.out.println("[LOG] - Error while reading from console");
			e.printStackTrace();
		}
	}

}
