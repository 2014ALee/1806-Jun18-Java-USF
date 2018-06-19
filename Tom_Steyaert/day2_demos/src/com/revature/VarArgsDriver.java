package com.revature;

public class VarArgsDriver {

	
	
	public static void main(String... args) {
	String myString="abcd";
	int size = myString.length();
	
		
		
		System.out.println(reverseString("loop"));
		
	}
	
	public static String reverseString(String str) {
		int size = str.length();	
		String reversedString = "";
		
		for (int i = 0; i < size; i++) {
			reversedString += str.charAt(size - 1 - i);
		}
	
		return reversedString;	
	}
	
	
	public static void display(String value, int... arr) {
		
		for(int number: arr) {
			System.out.println(number);
		}
	}
	
}
