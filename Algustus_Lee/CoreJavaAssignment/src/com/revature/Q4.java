package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4 { 
	public static void main(String[] args)
	{
		System.out.println("Put in a number to get its factorial: ");
		//the input
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		try {
			//gets the input and has it read into the computer as an int, rather than a string.
			String numtoBefactored = input.readLine();
			int factorNum = Integer.parseInt(numtoBefactored);
			//prints out the number given to it as well as the factorial of it
			System.out.println("The factorial of " + numtoBefactored + " is : " + getFactorial(factorNum));
		} 
		//catch in case a bad input is given i.e: a letter
		catch (IOException e) {
			System.out.println("Input error.");
			e.printStackTrace();
		}
	}
	public static int getFactorial(int factorNum)
	{
		//for loop to get the factorial
		for(int i = factorNum-1; i > 0; i--)
		{
			factorNum *= i;
		}
		return factorNum;
	}

}
