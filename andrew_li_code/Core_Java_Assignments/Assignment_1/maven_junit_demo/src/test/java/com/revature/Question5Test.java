package com.revature;

import static com.revature.Question5.cutString;
import static org.junit.Assert.*;

import org.junit.Test;

public class Question5Test {

	@Test
	public void testCutString() {
		assertEquals("\"My name\", 4 should be cut to \"My n\"",
				cutString("My name", 4), "My n");
		assertEquals("\"Art gallery\", 3 should be cut to \"Art\"",
				cutString("Art gallery", 3), "Art");
		assertEquals("\"birthday cake\", 5 should be cut to \"birth\"",
				cutString("birthday cake", 5), "birth");
		assertEquals("\"CamelCase\", 7 should be cut to \"CamelCa\"",
				cutString("CamelCase", 7), "CamelCa");
		assertEquals("\"JoJo\", 4 should be cut to \"JoJo\"",
				cutString("JoJo", 4), "JoJo");
		System.out.println("Question 5 Test cases passed!");
	}

}
