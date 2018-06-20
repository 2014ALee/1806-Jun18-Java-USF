package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleReadDriver {
	public static void main(String[] args) {
		
		System.out.println("lets use BufferedReader to read from the console, first");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		System.out.print("enter some text: ");

		try {
			userInput = br.readLine();
		}catch(IOException ioe) {
			userInput = "invalid input!";
			ioe.printStackTrace();
			main(args);
		}

		System.out.println("you entered: " + userInput);


		System.out.println("----------------------------------------------------------");

		System.out.println("now lets work with the scanner object");

		Scanner scan = new Scanner(System.in);
		System.out.println("please enter some text, again: ");
		String value = scan.nextLine();
		System.out.println("the value you entered is: " + value);
	}
}
