package com.revature;

import java.util.InputMismatchException;
import java.util.Scanner;

// calculate interest based on a rate, principal, and time input by a user via the Scanner class
public class Question17 {

	public static void main(String[] args) {
		System.out.println("Let's calculate interest.\n");

		Scanner scan = new Scanner(System.in);

		double rate = 0d;
		double principal = 0d;
		int years = 0;
		
		try {
			System.out.print("Enter an interest rate (%): ");
			rate = scan.nextDouble();

			System.out.println();
			System.out.print("Enter the principal: ");
			principal = scan.nextDouble();

			System.out.println();
			System.out.print("Enter the years of interest: ");
			years = scan.nextInt();
		}catch(InputMismatchException ime) {
			System.out.println("Expected a numerical value.");
			ime.printStackTrace();
		}


		System.out.println("\nThe interest on $" + principal + " for " + years + " years at a"
				+ " rate of " + rate + "% is $" + (principal * (rate / 100) * years));
	}
}
