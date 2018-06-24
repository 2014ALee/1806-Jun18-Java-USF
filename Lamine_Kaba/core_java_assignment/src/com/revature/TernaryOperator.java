package com.revature;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TernaryOperator {
	
	public static void ternaryOperator() {
		
		int num1 = 0, num2 = 0, num3;
		
		Scanner getInput = new Scanner(System.in);
		
		System.out.println("Enter tow number to compare");

		
		
		try {
			num1 = getInput.nextInt();
			num2 = getInput.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Only integer value is accepted");
			return;
			//e.printStackTrace();
		}
		
		// Choose the minimum value for num3
		
		num3 = num1 < num2 ? num1 : num2;
		
		System.out.println(num3 +" is the minimum value you entered");
	
	}
}
