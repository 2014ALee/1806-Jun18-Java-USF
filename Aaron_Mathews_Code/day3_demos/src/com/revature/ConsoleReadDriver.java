package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleReadDriver {
	
	public static void main(String[] args) {
		System.out.println("Let's use buffered reader to read from the console first");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String userInput;
		System.out.print("Enter some text: ");
		
		try {
			userInput = br.readLine();
		} catch (IOException e) {
			userInput = "Invalid Input.";
			e.printStackTrace();
			main(args);
		}
		
		System.out.println("You entered: " + userInput);
		
		System.out.println("---------------------");
		
		System.out.println("Now, let's work with the scanner object.");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter some text");
		String value = scan.nextLine();
		
		System.out.println("The value you entered in: " + value);
	}

}
