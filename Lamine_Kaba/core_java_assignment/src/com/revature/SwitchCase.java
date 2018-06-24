package com.revature;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class SwitchCase {
	
	public static void switchCase() {
		
		System.out.println("Welcome to fast processing");
		System.out.println("Choose 1 for maths\nChoose 2 for Date\nChoose 3 for string\n ");
		
		int option = 0;
		Scanner getInput = new Scanner(System.in);
		
		option = getInput.nextInt();
		
		switch(option) {
		case 1:
			System.out.println("Enter a number to find the square root");
			double num;
			num = getInput.nextInt();
			if(num > 0) {
				System.out.println("Square root of " +num +" is: " + Math.sqrt(num));
			}
			else {
				System.out.println("Please enter only a positive number");
			}
			break;
		case 2:
			Date myDate = new Date();
			System.out.println(myDate.toString());
			break;
		case 3:
			String str = "I am learning Core Java";
			System.out.println(Arrays.toString(str.split(" ")));
			break;
		default:
			System.out.println("Nothing to Show!!!1");
				
				
		}
	}
}
