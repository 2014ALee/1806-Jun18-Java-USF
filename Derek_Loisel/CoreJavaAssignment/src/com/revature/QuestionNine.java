package com.revature;

import java.util.ArrayList;

public class QuestionNine {

	// Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all
	// the prime numbers to the console.

	public static void main(String[] args) {

		// create an ArrayList of numbers 1 - 100
		ArrayList<Integer> numsArrayList = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++)
			numsArrayList.add(i);

		// run the prime method on the ArrayList
		primes(numsArrayList);

	}

	public static void primes(ArrayList<Integer> list) {
		//loop through each number in the ArrayList
		for (int num : list) {
			//set a counter to determine how many times a number was divisible by the num being checked
			int counter = 0;
			//set i equal to the number being checked, then decrement i down from there for each iteration. 
			//each iteration checks if the number being checked is divisible by i and adds to the counter if it is.
			//if the number is prime, the counter is equal to 2 then only 2 numbers were divisible (the number itself and 1) so its prime
			for (int i = num; i >= 1; i--)
				//see if the number is divisible by i
				if (num % i == 0)
					counter = counter + 1;
			//if the counter is 2 its prime because the number being checked was only divisible by 2 numbers (the number itself and 1)
			if (counter == 2)
				System.out.println(num);
		}
	}

}
