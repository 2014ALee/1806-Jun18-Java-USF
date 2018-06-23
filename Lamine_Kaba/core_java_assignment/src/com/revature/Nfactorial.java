package com.revature;

import java.util.Scanner;

public class Nfactorial {

	private static final String getInput = null;

	public static void factorial() {
		
		System.out.println("Enter a number to find it factorial");

			Scanner getInput = new Scanner(System.in);
			int count;
			int result = 1;

			//Check for number input
			if(!getInput.hasNextInt()) {
				System.out.println("Please enter an integer number");
				return;
			}
			else {
				count = getInput.nextInt();
				// Check for positive input
				if(count < 0) {
					System.out.println("Please enter a positive number");
				}
				//print the calculated factorial
				else {
					if(count == 0 || count ==1) {
						System.out.println("Factorial of " + count + " is: " + count);
					}
					//calculate the factorial value
					else {
						for(int i = 1; i <= count; i++) {
							result = result * i;
						}
						System.out.print("\nFactorial of  "+ count +" is: " + result);
					}
				}

			}

	}
}

