package com.revature;

import java.util.Scanner;

public class EvenInteger {

	public static void evenInteger() {
		// Any number divide by two has 0 as remainder is even number
		System.out.println("Enter a number to check if it is even");
		
		Scanner getInput = new Scanner(System.in);
		
		int quotient, number;
		number = getInput.nextInt()	;
		quotient = number/2;
		
		if(quotient*2 == number) {
			System.out.println(number + " is an even number");
		}
		else {
			System.out.println(number + " is NOT an even number");
		}
	}
}

