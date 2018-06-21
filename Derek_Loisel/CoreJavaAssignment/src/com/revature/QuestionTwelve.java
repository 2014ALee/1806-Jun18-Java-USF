package com.revature;

public class QuestionTwelve {

	//Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. 
	//Use the enhanced FOR loop for printing out the numbers.
	
	public static void main(String[] args) {
		
		//create an array with index of 100
		int[] myIntArray = new int[100];
		
		//loop 100 times and add the iteration to the array to get 1 - 100
		for(int i = 1; i <= myIntArray.length; i++)
		{
			myIntArray[i - 1] = i;
		}
		
		//foreach to print the array values
		for(int num : myIntArray)
		{
			System.out.println(num);
		}
	}
}
