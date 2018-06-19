package com.revature;

public class ReverseStringDriver {

	public static void main(String[] args) {
		String forwardString = "This is my string forward.";
		reverseString(forwardString);
	}
	
	public static void reverseString(String forwardString) {
		char[] forwardCharArray = forwardString.toCharArray();
		char[] reverseCharArray = new char[forwardCharArray.length];
		for(int i = 0; i < forwardCharArray.length; i++)
			reverseCharArray[forwardCharArray.length - i - 1] = forwardCharArray[i];
		System.out.println(reverseCharArray);
	}
}
