/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q8Palindromes.java
 * Code for Q8 of Core Java Assignment. Stores specified strings in a list array. Saves palindromes to another ArrayList.
 */
package com.revature;

import java.util.ArrayList;
import java.util.Arrays;

public class Q8Palindrome {
	public static void main(String[] args) {
		ArrayList<String> list;
		ArrayList<String> palindromes = new ArrayList<>();
		StringBuilder reverse;

		String[] words = {"karan","madam","tom","civic","radar","jimmy","kayak","john","refer","billy","did"};

		// Storing in Array list
		list = new ArrayList<>(Arrays.asList(words));

		// Checking to see if palindrome
		for(String word : list) {
			reverse = new StringBuilder(word).reverse();

			if(word.equals(reverse.toString())) {
				palindromes.add(word);
			}
		}

		// Printing out palindrome
		for(String palindrome : palindromes) {
			System.out.println(palindrome);
		}
	}
}
