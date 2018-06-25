package com.revature;

import java.util.Scanner;

public class nFactorial {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter an integer you wish to calculate the factorial for: ");
		int n = input.nextInt();
		
		System.out.println("The factorial of the integer you entered is: " + computeFactorial(n));
		
	}
	
	public static int computeFactorial(int n) {
		if (n==0) {
			return 1;
		} else {
			return n * computeFactorial(n - 1);
		}
	}

}
