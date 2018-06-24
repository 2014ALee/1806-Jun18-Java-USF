package com.revature;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args)
	{
		//gets input
		Scanner input = new Scanner(System.in);
		String str = new String();
		String theInt = new String();
		int idx;
		
		//try/catch format in case of bad inputs
		try {
		System.out.print("Input str: ");
		str = input.nextLine();
		System.out.println("Input index: ");
		theInt = input.nextLine();
		idx = Integer.parseInt(theInt);
		System.out.println("The substring is: " + stringMaker(str, (idx - 1)));
		}
		catch(NumberFormatException e)
		{
			System.out.println("Bad number format");
			e.printStackTrace();
		}
		
		
		
		

		input.close();
	}
	
	public static String stringMaker(String str, int idx)
	{
		//makes a new string to hold the string to be returned
		String theSubstring = new String();
		
		//for loop to get the elements in an array from 0 to the specified index passed to this function
		for(int i = 0; i < idx; i++)
		{
			//adds the char at the specified index of the string passed into this function to the new
			//string made in this function.
			theSubstring = theSubstring.concat(String.valueOf(str.charAt(i)));
		}
		//returns the new String
		return theSubstring;
		
	}

}
