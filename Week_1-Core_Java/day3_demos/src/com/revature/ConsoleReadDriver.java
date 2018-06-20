package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleReadDriver {
	
	public static void main(String[] args) {
		
		System.out.println("Let's use BufferedReader to read from the console, first...");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String userInput;
		
		System.out.print("Enter some text: ");
		
		try {
			userInput = br.readLine();
		} catch (IOException ioe) {
			userInput = "Invalid input!";
			ioe.printStackTrace();
			main(args);
		}
		
		System.out.println("You entered: " + userInput);
		
		System.out.println("-----------------------------------------------------------------");
		
		System.out.println("Now, let's work with the Scanner object!");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter some text, again: ");
		int value = scan.nextInt();
		System.out.println("The value you entered is: " + value);
	}

}
