package com.revature;

import java.util.ArrayList;
import java.util.List;

public class Q19 {
	public static void main(String[] args) {
		List<Integer> theList = new ArrayList<>();
		//fills the list
		for (int i = 1; i < 11; i++)
		{
			theList.add(i);
		}
		System.out.println("Initial List: "+theList);

		//runs through the list to get the sums of the even numbers and the sums of the odd numbers.


		//runs through the list again to remove the prime numbers. this is the same algorithm as Q9

		System.out.println("Sum of the even numbers: "+evenSumGetter(theList));
		System.out.println("Sum of the odd numbers: "+oddSumGetter(theList));
		System.out.println("Final List, all primes removed: "+primeRemover(theList));
	}
	public static int oddSumGetter(List<Integer> theList)
	{
		int oddSum = 0;
		for (int i = 0; i<theList.size();i++)
		{
			if((theList.get(i) % 2) !=0)
			{
				oddSum += theList.get(i);
			}
		}
		return oddSum;
	}
	public static int evenSumGetter(List<Integer> theList)
	{
		int evenSum = 0;
		for (int i = 0; i<theList.size();i++)
		{
			if((theList.get(i) % 2) ==0)
			{
				evenSum += theList.get(i);
			}
		}
		return evenSum;
	}


	public static List<Integer> primeRemover(List<Integer> theList)
	{
		int counter = 0;
		for (int i = 0; i < theList.size(); i++)
		{
			int placeHolder = theList.get(i);

			for (int j = placeHolder; j > 0; j--) {
				//adds one to the counter if 
				if(!(Math.sqrt((double)theList.get(i) % j) > 0)) {
					counter++;
				}

			}
			//instead of printing the number that is prime, this one drops the prime number, and sets i back to zero to check for primes
			//again.
			if (counter == 2 || placeHolder == 2) {
				theList.remove(i);
				i = 0;
				counter = 0;
			}
			else if(counter > 2) {
				counter = 0;
			}

		}
		return theList;
	}
}


