package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleReadDriver {
	
	public static void main(String[] args) {
		System.out.println("Let's use the BufferedReader to read from the console first...");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String userInput;
		System.out.println("Enter some text: ");
		
		try {
			userInput = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			userInput = "invalid input";
			e.printStackTrace();
			main(args);
		}
		System.out.println("You entered: " + userInput);
		
		System.out.println("--------------------------------------------");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter some text: ");
		String value = scan.nextLine();
		System.out.println("The value you entered is " + value);
	}

}
