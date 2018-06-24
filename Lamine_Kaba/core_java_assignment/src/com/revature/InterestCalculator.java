package com.revature;

import java.util.Scanner;

public class InterestCalculator {
	
	public static void intCalculator() {
		
		double  principal = 0;
		double rate = 0;
		double time = 0;
		double interest;
		
		System.out.println("Enter your principat ");
		
		Scanner userInput = new Scanner(System.in);
		
		// check for valid principal value
		if(!userInput.hasNextInt()) {
			System.out.println("Please enter a number");
		}
		else {
			principal = userInput.nextDouble();
		}
		
		// Check for valid rate value
		System.out.println("Enter your the rate ");
		
		if(!userInput.hasNextDouble()) {
			System.out.println("Please enter a number");
		}
		else {
			rate = userInput.nextDouble();
		}
		
		// Check for valid date format
		System.out.println("Enter the year in four digit format ");
		
		if(!userInput.hasNextInt()) {
			System.out.println("Please enter a date ");
		}
		else {
			time = userInput.nextDouble();
		}
		
		// Calculate the interest rate
		 
		interest = principal * rate * time;
		
		System.out.println("Your interest is: " + interest);

	}

}
