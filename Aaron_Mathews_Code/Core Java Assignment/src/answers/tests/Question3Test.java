package answers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import answers.Question3;

class Question3Test {

	@Test
	public void testReverseString() {
		String str = "Hello";
		String reverse = "olleH";
		
		assertEquals(String.valueOf(reverse), String.valueOf(Question3.reverseString(str)));
	}

}
