package com.revature;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class PalindromesTest {

	@Test
	public void testPalindromes() {
		ArrayList<String> result = new ArrayList<>();
		result.add("racecar");
		assertEquals("Should return word if it is a palindrome.", result, Palindromes.checkPalindrome("racecar"));
	}

}
