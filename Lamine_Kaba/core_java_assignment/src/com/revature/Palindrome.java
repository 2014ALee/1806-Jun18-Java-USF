package com.revature;

import java.util.ArrayList;
import java.util.Collections;

public class Palindrome {

	public static void palindrome(){

		ArrayList<String> originalList = new ArrayList<String>();

		originalList.add("karan");  
		originalList.add("madam");  
		originalList.add("tom");  
		originalList.add("civic"); 
		originalList.add("radar");  
		originalList.add("kayak");  
		originalList.add("john");  
		originalList.add("refer");  
		originalList.add("jimmy");  
		originalList.add("billy");  
		originalList.add("did"); 

		System.out.println("Before Sorting: ");

		for(String obj:originalList)  
			System.out.print(", " +obj); 

		//Copy the sorted list in new list

		ArrayList<String> sortedList = new ArrayList<String>();

		Collections.sort(originalList);

		sortedList = originalList;

		System.out.println("\nAfer Sorting: ");

		for(String obj:sortedList)  
			System.out.print(", " +obj);  

		// Write the palindrome list; 

		ArrayList<String> palindromes = new ArrayList<String>();

		for(String words: sortedList) {
			if(isPalindrome(words)) {
				palindromes.add(words);
			}
		}

		System.out.println("\nPalindrome are: ");

		for(String obj:palindromes)  
			System.out.print(", " +obj);
	}

	public static boolean isPalindrome(String myPalindrome) {
		// Reverse the String
		StringBuilder reverse = new StringBuilder(myPalindrome).reverse();
		// Return the compared string
		return myPalindrome.equals(reverse.toString());
	}
}
