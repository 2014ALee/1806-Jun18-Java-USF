package com.revature;

import java.util.ArrayList;

public class Question8 {
	public static void main(String[] args) {
		String[] words = new String[] {"karan", "madam", "tom", "civic",
				"radar", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		/*
		 * ArrayListHolder holds two ArrayLists since we're
		 * using two ArrayLists.
		 */
		ArrayListHolder results = distinguish(words);
		System.out.println(results.strings);
		System.out.println(results.palindromes);
	}
	
	/*
	 * Since we want a method that gives us two
	 * ArrayLists, let's create a small class to contain
	 * the two ArrayLists.
	 */
	private static class ArrayListHolder {
		private ArrayList<String> strings;
		private ArrayList<String> palindromes;
		
		private ArrayListHolder() {
			this.strings = new ArrayList<String>();
			this.palindromes = new ArrayList<String>();
		}
	}
	
	/*
	 * Takes in a list of strings, stores all of them
	 * in one ArrayList, and the palindromes in another.
	 */
	private static ArrayListHolder distinguish(String...strings) {
		ArrayListHolder ourArrayLists = new ArrayListHolder();
		/*
		 * Strings are automatically added to one ArrayList,
		 * but conditionally added to another.
		 */
		for (String string : strings) {
			ourArrayLists.strings.add(string);
			if (isPalindrome(string)) {
				ourArrayLists.palindromes.add(string);
			}
		}
		return ourArrayLists;
	}
	private static boolean isPalindrome(String test) {
		/*
		 * The number of checks is half of the length.
		 * Integer division is fine, since we don't
		 * need to check the middle character.
		 */
		int halfLength = test.length() / 2;
		
		/*
		 * Easier to create a partner variable to show the index
		 * of the other character we're checking.
		 * Last index is length - 1, so we start there and go downward.
		 */
		for (int i = 0, j = test.length() - 1; i < halfLength; i++, j--) {
			/*
			 * One instance of non-matching in the reverse direction 
			 * is a palindrome failure.
			 */
			if (test.charAt(i) != test.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
