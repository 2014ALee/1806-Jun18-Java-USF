package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import answers.*;

public class QuestionsTest {
	
	// Question 1
	@Test
	public void testBubbleSort() {
		int[] unordered = {4, 7, 1, 8, 5, 4, 5, 6, 7, 8, 7, 9, 2, 0, 0, 1, 7, 2, 1, 1, 3, 4, 0};
		int[] ordered = {0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 4, 4, 4, 5, 5, 6, 7, 7, 7, 7, 8, 8, 9};
		assertEquals("Testing bubble sort", true, Arrays.equals(ordered, Question1.bubbleSort(unordered)));
	}
	
	// Question 2
	@Test
	public void testFibonacci() {
		ArrayList<Integer> fibs = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144));
		assertEquals("The first 13 fibonacci numbers", true, fibs.equals(Question2.fibonacci(13)));
	}
	
	// Question 3
	@Test
	public void testReverseString() {
		String testString = "This is a test string";
		String reversedString = "gnirts tset a si sihT";
		assertEquals("Testing the reverse string method", true, reversedString.equals(Question3.reverseString(testString)));
	}
	
	// Question 4
	@Test
	public void testFactorial() {
		int num = 5;
		int numFactorial = 120;
		assertEquals("Testing the factorial method", numFactorial, Question4.factorial(num));
	}
	
	// Question 5
	@Test
	public void testSubString() {
		int index = 4;
		String string = "This is a string";
		String subString = string.substring(0, index);
		assertEquals("Testing the subString method", true, subString.equals(Question5.subString(string, index)));
	}
	
	// Question 6
	@Test
	public void testIsEven() {
		for(int i = -10; i < 10; i++)
			assertEquals("Testing if the 20 numbers surrounding 0 are even or odd", i % 2 == 0, Question6.isEven(i));
	}
	
	// Question 7
	// COME BACK TO THIS
	
	// Question 8
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
	
	// Question 9
	@Test
	public void testIsPrime() {
		HashMap<Integer, Boolean> testCases = new HashMap<>();
		testCases.put(1, false);
		testCases.put(2, true);
		testCases.put(3, true);
		testCases.put(4, false);
		testCases.put(5, true);
		testCases.put(6, false);
		testCases.put(7, true);
		testCases.put(8, false);
		testCases.put(9, false);
		testCases.put(10, false);
		testCases.put(11, true);
		
		for(Map.Entry<Integer, Boolean> entry : testCases.entrySet())
			assertEquals("Testing primeness", entry.getValue(), Question9.isPrime(entry.getKey()));
	}
	
	// Question 10
	@Test
	public void testMin() {
		int x = (int) (Math.random() * 100);
		int y = (int) (Math.random() * 100);
		assertEquals("Testing min method", Math.min(x, y), Question10.min(x, y));
	}
	
	// Question 11
	@Test
	public void testRetrieveVars() {
		float[] vars = {3.14f, 2.7f};
		assertEquals("Testing variable retrieval", true, Arrays.equals(vars, Question11_2.VariableRetriever.retrieveVars()));
	}
	
	// Question 12
	@Test
	public void testGetEvens() {
		int[] testNums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] evenNums = {0, 2, 4, 6, 8, 10};
		assertEquals("Testing evens", true, Arrays.equals(evenNums, Question12.getEvens(testNums)));
	}
}
