package com.revature;

import java.util.ArrayList;

public class QuestionNineteen {

	//	Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList. 
	//	Add all the even numbers up and display the result. Add all the odd numbers up and display the result. 
	//	Remove the prime numbers from the ArrayList and print out the remaining ArrayList.

	public static void main(String[] args) {

		//create ArrayList of numbers 1 - 10
		ArrayList<Integer> numsArrayList = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++)
			numsArrayList.add(i);

		//Display the ArrayList
		System.out.println(numsArrayList);

		//Add even numbers from ArrayList and display the result
		System.out.println(addEvenNums(numsArrayList));

		//Add odd numbers from ArrayList and display the result
		System.out.println(addOddNums(numsArrayList));		

		//remove prime numbers from the ArrayList
		numsArrayList = removePrimes(numsArrayList);
		
		//print out the ArrayList of primes
		System.out.println(numsArrayList);
	}


	public static int addEvenNums (ArrayList<Integer> intArrayList) {

		int evenSum = 0;

		for (int num : intArrayList) {			
			if(num % 2 == 0) {
				evenSum += num;				
			}
		}

		return evenSum;
	}

	public static int addOddNums (ArrayList<Integer> list) {

		int oddSum = 0;

		for (int num : list) {			
			if(num % 2 != 0) {
				oddSum += num;				
			}
		}

		return oddSum;
	}
	
	public static ArrayList<Integer> removePrimes (ArrayList<Integer> list) {
		
		ArrayList<Integer> tempArrayList = new ArrayList<Integer>();;
		
		//find the primes and add them to tempArrayList
		//loop through each number in the ArrayList
		for (int num : list) {
			//set a counter to determine how many times a number was divisible by the num being checked
			int counter = 0;
			//set i equal to the number being checked, then decrement i down from there for each iteration. 
			//each iteration checks if the number being checked is divisible by i and adds to the counter if it is.
			//if the number is prime, the counter is equal to 2 so only 2 numbers were divisible (the number itself and 1) so its prime
			for (int i = num; i >= 1; i--)
				//see if the number is divisible by i
				if (num % i == 0)
					counter = counter + 1;
			//if the counter is 2 its prime because the number being checked was only divisible by 2 numbers (the number itself and 1)
			if (counter == 2)
				tempArrayList.add(num);
		}
		
		return tempArrayList;
	}
}
