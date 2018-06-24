package test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import answers.Question8;

public class Question8Test {
	
	@Test
	public void testIsPalindrome() {
		HashMap<String, Boolean> testCases = new HashMap<>();
		testCases.put("racecar", true);
		testCases.put("mom", true);
		testCases.put("not a a palindrome", false);
		testCases.put("alula", true);
		testCases.put("avid diva", true);
		testCases.put("another not palindrome", false);
		
		for(Map.Entry<String, Boolean> entry : testCases.entrySet())
			assertEquals("Testing palindromes", entry.getValue(), Question8.isPalindrome(entry.getKey()));
	}

}
