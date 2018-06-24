package com.revature;

import java.util.Scanner;

public class TernaryOperator {
	
	public static void ternaryOperator() {
		
		int num1, num2, num3;
		
		Scanner getInput = new Scanner(System.in);
		
		System.out.println("Enter tow number to compare");

		num1 = getInput.nextInt();
		num2 = getInput.nextInt();
		
		// Choose the minimum value for num3
		
		num3 = num1 < num2 ? num1 : num2;
		
		System.out.println(num3 +" is the minimum value you entered");
	
	}
}
