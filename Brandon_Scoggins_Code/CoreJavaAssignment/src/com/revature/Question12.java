package com.revature;
// put numbers 1-100 in an array and print the even numbers using an enhanced for loop

public class Question12 {

	public static void main(String[] args) {

		int[] numArr = new int[100];
		
		for(int i = 0; i < 100; i++)
			numArr[i] = i + 1;
			
		for(int number : numArr) {
			if(number % 2 == 0)
				System.out.print(number + "  ");
		}
			
		
	}
}
