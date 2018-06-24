package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6 {
	public static void main(String[] args)
	{
		//intro to the program, tells user what to do, prepares the inputs
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String inputNum ="";
		System.out.println("Put a number in and I'll tell you if it's  even or odd!");
		//gets the input, turns the string into an int
		try {
			inputNum = input.readLine();
		}
		//in case someone puts the wrong thing in
		catch(NumberFormatException e)
		{
			System.out.println("Please put a number in");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Bad input");
			e.printStackTrace();
		}

		//final if statement to tell if it is even or odd
		if(evenOrOdd(inputNum))
		{
			System.out.println(inputNum + " is an even number");
		}
		else
		{
			System.out.println(inputNum + " is not an even number");
		}
	}
	public static boolean evenOrOdd(String inputNum )
	{
		//int to check the inputted number
		int theCheck;
		//boolean to give the result
		boolean theResult;
		int theInt = Integer.parseInt(inputNum);
		//the check divides the number by two.
		theCheck = (theInt/2);
		return theResult = (theInt ==(theCheck*2)) ? true : false;
	}

}
