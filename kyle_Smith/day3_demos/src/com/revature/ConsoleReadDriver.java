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
		
		System.out.println("Enter some text: ");
		
		try {
			userInput = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			userInput = "invalid input!";
			e.printStackTrace();
			main(args);
		}
		
		System.out.println("You entered: " + userInput);
		
		System.out.println("------------------------------------------------");
		
		System.out.println("Now, let's work with the Scanner object!");
		
		Scanner scan = new Scanner(System.in);
		String value = scan.nextLine(); //un-checked exceptions runtime exception
		System.out.println("The value you entered is " + value);
		
		
	}
	
}
