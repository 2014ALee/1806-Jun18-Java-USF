package com.revature;
// Reverse a string without using a temporary variable
public class Question3 {

	public static void main(String[] args) {
		String forwardString = "This is my string forward.";								// initialize a string to be reversed
		System.out.println(forwardString);
		reverseString(forwardString);														// call a method to print the string reversed
	}
	
	public static void reverseString(String forwardString) {								// a method that prints string in reverse
		char[] forwardCharArray = forwardString.toCharArray();								// stores the string parameter as a char[]
		char[] reverseCharArray = new char[forwardCharArray.length];						// initializes a char[] that is the same length as the forward string, and will hold the reversed string
		for(int i = 0; i < forwardCharArray.length; i++)									// takes every letter, in order, from the forward char[] and copies it into the reverse char[] counting down from the end
			reverseCharArray[forwardCharArray.length - i - 1] = forwardCharArray[i];
		System.out.println(reverseCharArray);												// prints the reversed string as a char[]
	}
	
	// made a charArrayToString method in question8
}
