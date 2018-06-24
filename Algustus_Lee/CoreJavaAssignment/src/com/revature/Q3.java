package com.revature;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args)
	{
		//gets input
		Scanner input = new Scanner(System.in);
		String theString = new String();
		System.out.println("User input: ");
		theString = input.nextLine();	
		System.out.println(stringReverser(theString));
		input.close();
	}
	public static String stringReverser(String theString)
	{
		//the loop
		for(int i = 0; i < theString.length(); i++)
		{
			//adds the current char on the iterator to the beginning of the word, then adds the char at the end of the string to the next position
			//then adds the letter between them to the next position, and assigns it to be the new String. It then loops until reaching the end 
			//of the word.
			theString = theString.substring(0, i)+theString.charAt(theString.length()-1)+theString.substring(i, theString.length()-1);
		}
		
		return theString;
	}

}
