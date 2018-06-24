package com.revature;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Q14 {
	public static void main(String[] args) {
		
		//gets inputs
		Scanner input = new Scanner(System.in);
		//String caseNum = new String();
		int theCase;
		
		System.out.println("Enter a number between 1 and 3 to pick a case!");
		
		try
		{
			//the number to get the square root taken
			double squareNum = 9d;
			//it was at this moment, twelve questions in, that I realized I could get an int normally instead of in a roundabout method.
			//Progress is beautiful.
			theCase = input.nextInt();
			switch(theCase){
			case 1:
				System.out.println("The square root of "+squareNum+ " = "+ Math.sqrt(squareNum));
				break;
			case 2:
				Date theDate = new Date();
				System.out.println("The Date: "+ theDate);
			case 3:
				String strToSplit = "I am learning Core Java";
				System.out.println("This will print out an array that says I am learning Core Java");
				System.out.println(Arrays.toString(stringSplitter(strToSplit)));	
			default:
				System.out.println("Please enter numbers 1, 2, or 3");
				main(args);
			}
		}
		//in case of screwups with the input
		catch(IllegalArgumentException e){
			System.out.println("Please enter numbers 1, 2, or 3");
			e.printStackTrace();
			main(args);
		}
		input.close();
		
		
	}
	public static String[] stringSplitter(String splitMe)
	{
		//makes a string array
		String[] newSplitString = new String[5];
		
		//sets the string array equal to a string array made by using the split function
		newSplitString = splitMe.split(" ");
		
		//returns the string array
		return newSplitString;
		
	}

}
