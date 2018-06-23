package com.revature;

public class QuestionTwelveDriver {

	//Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. 
	//Use the enhanced FOR loop for printing out the numbers.
	
	public static void main(String[] args) {
		
		printEvensFromArray(createArray());	
	}
	
	//returns an array of ints 1-100
	private static int[] createArray() {

		int[] myIntArray = new int[100];
		
		//loop 100 times and add the iteration to the array to get 1 - 100
		for(int i = 1; i <= myIntArray.length; i++)
		{
			myIntArray[i - 1] = i;
		}
		
		return myIntArray;
	}
	
	//takes in an array of ints as a parameter and prints out the evens
	private static void printEvensFromArray(int[] intArray) {
		//enhanced for loop to print the array values
		for(int num : intArray)
		{
			//check if it's an even number before printing
			if( num % 2 == 0){
			System.out.println(num);
			}
		}
	}
}
