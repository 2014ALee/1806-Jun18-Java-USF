package com.revature;

public class Question5 {

	public static void main(String[] args) {
		System.out.println(cutString("Hello, World", 5));

	}
	public static String cutString(String string, int size) {
		/*
		 * If the given int is bigger than the String size,
		 * we can't give any more characters from the string.
		 */
		if (size >= string.length()) {
			return string;
		}
		
		// Without substring, just use charAt from 0
		// to index.
		String shortString = "";
		for (int i = 0; i < size; i++) {
			shortString += string.charAt(i);
		}
		return shortString;
	}

}