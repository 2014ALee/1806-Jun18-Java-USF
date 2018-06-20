package com.revature;

public class reverseString {

	public static void main(String[] args) {
		String str = "Hello";
		String reverseString = "";
		for (int i = str.length() - 1; i>=0; --i) {
			reverseString += str.charAt(i);
		}
		System.out.print(reverseString);

	}

}
