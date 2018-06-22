package answers;

import java.util.ArrayList;
import java.util.Arrays;

public class Question8 {
	// Detecting Palindromes

	public static void main(String[] args) {
		// Create the lists
		String[] w = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"};
		ArrayList<String> words = new ArrayList<String>(Arrays.asList(w));
		ArrayList<String> palindromes = new ArrayList<String>();
		
		// Go throught the words and add the palindromes to the palindrome list
		for(String word : words)
			if(isPalindrome(word))
				palindromes.add(word);
		
		// Print them out
		for(String word : palindromes)
			System.out.println(word);
		
	}
	
	// This function tests whether a string is a palindrome
	public static boolean isPalindrome(String string) {
		// Get the reverse of the string...
		StringBuilder reverse = new StringBuilder(string).reverse();
		// and compare it to the original.
		return string.equals(reverse.toString());
	}

}
