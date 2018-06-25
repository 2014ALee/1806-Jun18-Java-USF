package com.revature;
// Reverse a string without using a temporary variable
public class Question3 {

	public static void main(String[] args) {
		String forwardString = "This is my string forward.";
		System.out.println(forwardString);
		reverseString(forwardString);
	}
	
	public static void reverseString(String forwardString) {
		char[] forwardCharArray = forwardString.toCharArray();
		char[] reverseCharArray = new char[forwardCharArray.length];
		for(int i = 0; i < forwardCharArray.length; i++)
			reverseCharArray[forwardCharArray.length - i - 1] = forwardCharArray[i];
		System.out.println(reverseCharArray);
	}
	
	// made a charArrayToString method in question8
}
