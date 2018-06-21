package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleReadDriver {

	public static void main(String[] args) {
		System.out.println("Let's use buffer reader first to read from the console");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String userInput;
		
		System.out.println("Enter text: ");
		
		try {
			userInput = br.readLine();
		} catch (IOException e) {
			userInput = "invalid input!";
			e.printStackTrace();
			main(args);
		}
System.out.println("You entered: " + userInput);		
		

System.out.println("------------------------------------------------");

System.out.println("Now let's work with the scanner object");

Scanner scan = new Scanner(System.in);

System.out.println("Please enter some text again: ");
String value = scan.nextLine();
System.out.println("The value you entered is: " + value);a

	}	
}
