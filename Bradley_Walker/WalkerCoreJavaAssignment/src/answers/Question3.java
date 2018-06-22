package answers;

import java.util.ArrayList;

public class Question3 {
	// Reversing a String

	public static void main(String[] args) {
		String s = "This is a string";
		System.out.println("Original: " + s);
		// Reverse the string
		s = reverseString(s);
		System.out.println("Reversed: " + s);
		ArrayList<String> str = new ArrayList<String>();
	}
	
	public static String reverseString(String s) {
		// Loop through the characters in the string and add them to the beginning of the original string
		for(char c : s.toCharArray())
			s = c + s;
		// Return the first half of the string
		return s.substring(0, s.length() / 2);
	}

}
