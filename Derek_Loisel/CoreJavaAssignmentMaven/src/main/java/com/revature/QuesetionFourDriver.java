package com.revature;

public class QuesetionFourDriver {

	//Q4. Write a program to compute N factorial.

	public static void main(String args[]){  

		int factorial = computeFactorial(4);
		System.out.println(factorial);

	}  

	private static int computeFactorial(int number) {

		//start the factorial at 1
		int fact = 1;     

		///multiply the factorial by every number leading up to it starting from 1
		for(int i = 1;i <= number; i++){    
			fact *= i; 
		}  

		return fact;
	}
} 


