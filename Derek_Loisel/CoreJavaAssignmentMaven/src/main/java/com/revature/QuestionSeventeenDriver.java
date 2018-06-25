package com.revature;

import java.util.Scanner;

public class QuestionSeventeenDriver {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		double principal = 0.0;
		double rate = 0.0;
		double years = 0.0;

		try {
		//gather user input with scanner
		System.out.println("Please enter the principal: ");	
		principal = scan.nextDouble();
	
		System.out.println("Please enter the rate: ");		
		rate = scan.nextDouble();

		System.out.println("Please enter the number of years: ");
		years = scan.nextDouble();

		//close the scanner after use
		scan.close();

		//calculate interest		
		double interest = calculateInterest(principal, rate, years);

		//print interest
		System.out.println(interest);
		}catch(Exception e) {
			System.out.println("Invalid input");
		}
		
	}

	public static double calculateInterest(double principal, double rate, double years) {

		double interest = principal * rate * years;

		return interest;
	}
}
