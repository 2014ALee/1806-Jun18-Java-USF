package com.revature;
// return a substring between two indices 
public class Question5 {

	public static void main (String[] args) {
		System.out.println(subString("My full length string.", 8));		// prints a substring of the entered text up to the given index
	}
	// return char[] instead of string?
	private static char[] subString(String str, int idx) {				// Accepts a String and an index up to which a substring will be returned
		char[] subCharArray = new char[str.length()];					// initializes a char[] the size of the string
		try {
			str.getChars(0, idx, subCharArray, 0);						// gets characters from a string between two indecies and places them in char[] with placement beginning at the final parameter 
		}catch(StringIndexOutOfBoundsException sioobe) {				// can throw StringIndexOutOfBoundsException
			sioobe.printStackTrace();
		}
		
		return subCharArray;
	}
}
