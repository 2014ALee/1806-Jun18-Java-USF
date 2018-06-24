package com.revature;

import java.util.Arrays;

public class QuestionTwoDriver {

	//Q2. Write a program to display the first 25 Fibonacci numbers starting at 0.

	public static void main(String[] args) {
		
		//method to create array of the first 25 fibonacci numbers
		int[] fibonacciArray = createFibonacciArray();
		
		//display the numbers in the array
		System.out.println(Arrays.toString(fibonacciArray));
		
//		for (int num : fibonacciArray) {
//			System.out.println(num);
//		}
	}

	public static int[] createFibonacciArray() {

		//create an array to hold the values
		int[] intArray = new int[25]; 

		//create first 2 array values
		intArray[0] = 0; 
		intArray[1] = 1; 

		//start the third value and add the previous 2 numbers to get the current array iterations value
		for(int i=2; i < intArray.length; i++) 
		{ 
			intArray[i] = intArray[i-1] + intArray[i-2]; 
		}

		return intArray;
		
	}

}
