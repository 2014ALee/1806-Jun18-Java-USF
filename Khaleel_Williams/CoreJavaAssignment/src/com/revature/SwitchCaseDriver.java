package com.revature;

import java.util.Date;
import java.util.Scanner;

public class SwitchCaseDriver {
	
	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("[1] - Find the square root of 2078.");
		System.out.println("[2] - Display today's date.");
		System.out.println("[3] - Split string 'I am learning Core Java'");
		System.out.print("Your Selection: ");
		int userInput = read.nextInt();
		
		switch(userInput) {
		case 1:
			System.out.print("The sqaure root of 2078 is = ");
			System.out.print(Math.sqrt(2078));
			break;
		case 2:
			System.out.print("Today's date is: ");
			Date date = new Date();
			System.out.print(date);
			break;
		case 3:
			System.out.println("String was split");
			String stringArray[] = "I am learning Core Java".split(" ");
			break;
		default:
			System.out.println("Pick from the options provided");
		}
	}

}
