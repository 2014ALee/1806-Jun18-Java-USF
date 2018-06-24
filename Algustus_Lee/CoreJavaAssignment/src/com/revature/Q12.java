package com.revature;

import java.util.Arrays;

public class Q12 {
	public static void main(String[] args) {
		//initializes the int array, uses 101 to grab numbers 1 to 100
		int[] fiftyInts = new int[51];

		System.out.println(Arrays.toString(fiftyIntFiller(fiftyInts)));
	}
	public static int[] fiftyIntFiller(int[] fiftyInts)
	{
		int hundredInts[] = new int[101];
		//for loop to fill the array
		for(int i = 1; i < 101; i++)
		{
			hundredInts[i] = i;
		}
		//foreach loop to print out the even numbers
		for(int i : fiftyInts)
		{
			System.out.println(hundredInts[i]);
			if((hundredInts[i] % 2) == 0)
			{
				fiftyInts[i]= hundredInts[i];
				//System.out.println(hundredInts[i]);
			}
		}
		return fiftyInts;
	}

}
