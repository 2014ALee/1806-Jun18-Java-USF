package com.revature;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Q8PalindromeTest {

	@Test
	public void originalList() {
		String[] words = {"karan","madam","tom","civic","radar","jimmy","kayak","john","refer","billy","did"};
		String[] palindromes = {"madam","civic","radar","kayak","refer","did"};
		ArrayList<String> palindromeList = new ArrayList<>();
		
		for(String word : palindromes) {
			palindromeList.add(word);
		}
		
		assertEquals("Only Palindromes",palindromeList,Q8Palindrome.palindrome(words));
	}

	@Test
	public void onlyPalindromes() {
		String[] words = {"madam","civic","radar","kayak","refer","did"};
		String[] palindromes = {"madam","civic","radar","kayak","refer","did"};
		ArrayList<String> palindromeList = new ArrayList<>();
		
		for(String word : palindromes) {
			palindromeList.add(word);
		}
		
		assertEquals("Only Palindromes",palindromeList,Q8Palindrome.palindrome(words));
	}
	
	@Test
	public void noPalindromes() {
		String[] words = {"karan","tom","jimmy","john","billy"};
		String[] palindromes = { };
		ArrayList<String> palindromeList = new ArrayList<>();
		
		for(String word : palindromes) {
			palindromeList.add(word);
		}
		
		assertEquals("Only Palindromes",palindromeList,Q8Palindrome.palindrome(words));
	}
}
