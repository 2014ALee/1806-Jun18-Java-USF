package com.revature;

import java.util.Scanner;

public class Q16 { 
	public static void main(String[] args) {
		//gets input
		System.out.println("Put in a word or two and I will tell you how many letters are in it.");
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		
		charCounter(userInput);
		input.close();
		System.out.println("Total of " + charCounter(userInput) + " chars passed in.");
	}
	public static int charCounter(String getString)
	{
		//makes an int to hold the total number of characters
		int totalChars = 0;
		
		//splits the userInput so that it can fill the string array
		String[] splitMe = getString.split(" ");
		
		//iterates through the array and adds the length of each word in the array to the total chars
		for (int i = 0; i < splitMe.length; i++)
		{
			totalChars += splitMe[i].length();
		}
		return totalChars;
	}

}
