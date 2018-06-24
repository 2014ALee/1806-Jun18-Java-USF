package J_Unit_tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import homework_week1.questions.Question8;

public class Question8Test {

	
	
	@Test
	public void returnsPalindromes() {
		ArrayList<String> input = new ArrayList<String>();
		input.add("bob");
		input.add("tom");
		input.add("andrew");
				
		ArrayList<String> palindromes = new ArrayList<String>();
		palindromes.add("bob");		
		
		assertEquals("an array list with bob, tom and andrew only returns bob", palindromes, Question8.getPalindromes(input));
	}
	
	@Test
	public void isCivicAPalindromes() {
		assertEquals("civic is a palindrome, we should get true", true, Question8.isPalindrome("civic"));
	}
	

}
