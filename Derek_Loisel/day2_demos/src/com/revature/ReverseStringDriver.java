package com.revature;

public class ReverseStringDriver {
	
	public static void main(String[] args) {
	
		String reverseThisString = "Derek";
		String reversedString = "";
	
		for (int i = reverseThisString.length() - 1; i >= 0; i--) {
			reversedString += reverseThisString.charAt(i);
		}
	
		System.out.println(reversedString);
	}
}
