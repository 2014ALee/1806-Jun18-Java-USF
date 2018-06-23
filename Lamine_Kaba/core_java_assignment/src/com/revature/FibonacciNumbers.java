package com.revature;

import java.util.Scanner;

public class FibonacciNumbers {

	public void display() {

		// Get input from user

		System.out.println("Enter how many Fibonacci number you want to display?");
		int count;
		Scanner getInput = new Scanner(System.in);
		
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
			//print the required fibonacci number
			else {
				int n0 = 0;
				int n1 = 1;
				System.out.print("Below is your  "+ count +" Fibonacci Number \n" + n0 + " + " + n1 +" =...." );

				for(int i = 0; i < count; i++) {
					int n2 = n0 + n1;
					System.out.print(" " + n2);
					n0 = n1;
					n1 = n2;
				}
			}

		}

	}

}
