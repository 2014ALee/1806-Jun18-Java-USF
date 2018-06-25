package com.revature;

import java.util.Scanner;

public class reverseString {

	public static void main(String[] args) {
		
		// Create Scanner object to take input from console
		Scanner input = new Scanner(System.in);
		
		// prompt user to enter string to be reversed, store that string in a variable
		System.out.println("Please enter a string to be reversed: ");
		String str1 = input.nextLine();
		
		StringReversal(str1);		
	}
	
	// Create method to reverse the string without using a temporary variable
	public static String StringReversal(String str2) {
		
		/*
		 *  starting at the end of the string and moving to the front of the string,
		 *  append the character at index i to the end of our original string. Basically,
		 *  appending the same string backwards. Then, create a substring that takes 
		 *  the second half (backwards half) of the string.
		 */
		for (int i = str2.length()-1; i>=0; i--) {
			str2 += str2.charAt(i);
		}
		str2 = str2.substring((str2.length() / 2), str2.length() );
		System.out.println(str2);
		return str2;		
		
	}

}
