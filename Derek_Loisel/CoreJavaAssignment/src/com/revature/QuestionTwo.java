package com.revature;

public class QuestionTwo {

	//Q2. Write a program to display the first 25 Fibonacci numbers starting at 0.

	public static void main(String[] args) {
		//method to print the first 25 fibonacci numbers
		printFibonacciNumbers();
	}
	
	private static void printFibonacciNumbers() {
		
		//create an array to hold the values
		int[] fibonacciIntArray = new int[25]; 

		//create first 2 array values
		fibonacciIntArray[0] = 0; 
		fibonacciIntArray[1] = 1; 

		//start the third value and add the previous 2 numbers to get the current array iterations value
		for(int i=2; i < fibonacciIntArray.length; i++) 
		{ 
			fibonacciIntArray[i] = fibonacciIntArray[i-1] + fibonacciIntArray[i-2]; 
		}
		
		//print the array
		for(int i=0; i< fibonacciIntArray.length; i++) 
		{ 
		System.out.print(fibonacciIntArray[i] + " "); 
		} 
	}

	
}
