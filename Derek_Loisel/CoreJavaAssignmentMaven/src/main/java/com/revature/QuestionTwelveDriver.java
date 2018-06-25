package com.revature;

public class QuestionTwelveDriver {

	//Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. 
	//Use the enhanced FOR loop for printing out the numbers.

	public static void main(String[] args) {

		int[] arr = createArray();	

		//enhanced for loop to print the array values
		for(int num : arr)
		{
			//check if it's an even number before printing
			if( num % 2 == 0){
				System.out.println(num);
			}
		}
	}

	//returns an array of ints 1-100
	public static int[] createArray() {

		int[] myIntArray = new int[100];

		//loop 100 times and add the iteration to the array to get 1 - 100
		for(int i = 1; i <= myIntArray.length; i++)
		{
			myIntArray[i - 1] = i;
		}

		return myIntArray;
	}

}
