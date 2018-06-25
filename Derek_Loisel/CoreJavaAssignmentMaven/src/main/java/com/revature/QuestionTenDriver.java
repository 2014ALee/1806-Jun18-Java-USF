package com.revature;

public class QuestionTenDriver {

	// Q10. Find the minimum of 2 numbers using ternary operators
	
	public static void main(String[] args) {
		
		//call the method with 2 int parameters to print the minimum
		System.out.println(findMinimumInt(3,1));
	}
	
	public static int findMinimumInt(int a, int b) {
		
		int minimum;
		
		//check which one is the minimum, if they're equal it still prints one of them because they're tied for minimum
		minimum = (a < b) ? a : b;

		return minimum;

	}
}
