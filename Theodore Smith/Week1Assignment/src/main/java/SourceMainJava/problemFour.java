package SourceMainJava;

import java.util.Scanner;

public class problemFour {

	public static void main(String[] args) {
		
		int n;
		int y; 
		int factorial = 1;
		
		System.out.println("Enter a value so we can check it's Factorial");
		
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		
		// Suppose to say it is a non negative
		if (n < 0) 
		System.out.println("number can not be a non- negative...sorry :) ");
		else {
			for (y = 1; y <= n; y++)
				
				factorial = factorial * y;
			
			System.out.println("Factorial of " + n + " is = " + factorial);
			
		}

	}

}
