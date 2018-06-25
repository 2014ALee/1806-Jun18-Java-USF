package com.revature;
// return a substring between two indices 
public class Question5 {

	public static void main (String[] args) {
		System.out.println(subString("My full length string.", 8));
	}
	// return char[] instead of string?
	private static char[] subString(String str, int idx) {
		char[] subCharArray = new char[str.length()];
		str.getChars(0, idx, subCharArray, 0);
		return subCharArray;
	}
}
