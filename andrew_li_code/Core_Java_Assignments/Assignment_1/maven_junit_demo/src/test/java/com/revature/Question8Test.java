package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.Question8.ArrayListHolder;

public class Question8Test {
	
	@Test
	public void testIsPalindrome() {
		assertEquals("Testing palindromes for even number", 
				Question8.isPalindrome(
						"repper"), true);
		assertEquals("Testing palindromes for odd number", 
				Question8.isPalindrome(
						"peter"), true);
		assertEquals("Testing failed palindromes for even number", 
				Question8.isPalindrome(
						"laser"), true);
		assertEquals("Testing palindromes for odd number", 
				Question8.isPalindrome(
						"rapper"), true);
		System.out.println("Palindromes worked");
	}

	@Test
	public void testArrayList() {
		ArrayListHolder words = new ArrayListHolder(
				"karan", "madam", "tom", "civic", "radar", "jimmy",
				"kayak", "john",  "refer", "billy", "did");
		assertEquals("Sanity check for arraylist size",
				words.getStrings().size(), 11);
		assertEquals("Check if all of our words are in Array List",
				words.getStrings().contains("karan"), true);
		assertEquals("Check if all of our words are in Array List",
				words.getStrings().contains("madam"), true);
		assertEquals("Check if all of our words are in Array List",
				words.getStrings().contains("tom"), true);
		assertEquals("Check if all of our words are in Array List",
				words.getStrings().contains("civic"), true);
		assertEquals("Check if all of our words are in Array List",
				words.getStrings().contains("radar"), true);
		assertEquals("Check if all of our words are in Array List",
				words.getStrings().contains("jimmy"), true);
		assertEquals("Check if all of our words are in Array List",
				words.getStrings().contains("kayak"), true);
		assertEquals("Check if all of our words are in Array List",
				words.getStrings().contains("john"), true);
		assertEquals("Check if all of our words are in Array List",
				words.getStrings().contains("refer"), true);
		assertEquals("Check if all of our words are in Array List",
				words.getStrings().contains("billy"), true);
		assertEquals("Check if all of our words are in Array List",
				words.getStrings().contains("did"), true);
		assertEquals("Should have six palindromes",
				words.getPalindromes().size(), 6);
		assertEquals("Check if palindrome is in Array List",
				words.getPalindromes().contains("madam"), true);
		assertEquals("Check if palindrome is in Array List",
				words.getPalindromes().contains("civic"), true);
		assertEquals("Check if palindrome is in Array List",
				words.getPalindromes().contains("radar"), true);
		assertEquals("Check if palindrome is in Array List",
				words.getPalindromes().contains("kayak"), true);
		assertEquals("Check if palindrome is in Array List",
				words.getPalindromes().contains("refer"), true);
		assertEquals("Check if palindrome is in Array List",
				words.getPalindromes().contains("did"), true);
		System.out.println("Question 8 test cases passed!");
	}

}
