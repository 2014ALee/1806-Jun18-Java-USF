package com.revature;

import java.util.ArrayList;
import java.util.List;

public class Q9 {
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		//gets the numbers of 1 to 100
		for(int i = 1; i < 101; i++)
		{
			numList.add(i);
		}
		System.out.println(primeList(numList));
	}
	public static List<Integer> primeList(List<Integer> numList)
	{
		List<Integer> secondList = new ArrayList<>();
		int counter = 0; //counter for how many times it counts divisors
		//outer loop, this is where it gets each number in the list
		for (int i = 0; i < numList.size(); i++)
		{
			//makes it easier to see numList.get(i) 
			int placeHolder = numList.get(i);

			//inner loop, used to check if a number is prime by seeing how many times a number
			//can be divided evenly
			for (int j = placeHolder; j > 0; j--) {
				//adds one to the counter if it can't divide evenly
				if(!(Math.sqrt((double)numList.get(i) % j) > 0)) {
					counter++;
				}
				
			}
			//if the counter or placeholder hit two and does not go past it, the associated
			//number is prime, and is printed out. The counter is then reset.
			if (counter == 2 || placeHolder == 2) {
				secondList.add(numList.get(i));
				counter = 0;
			}
			//if it goes past two, the counter is reset and the number is not printed.
			else if(counter > 2) {
				counter = 0;
			}

		}
		return secondList;

	}

}
