package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import answers.Question3;

public class Question3Test {
	
	@Test
	public void testReverseString() {
		String testString = "This is a test string";
		String reversedString = "gnirts tset a si sihT";
		assertEquals("Testing the reverse string method", true, reversedString.equals(Question3.reverseString(testString)));
	}

}
