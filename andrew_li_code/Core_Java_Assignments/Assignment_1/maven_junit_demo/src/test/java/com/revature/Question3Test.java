package com.revature;

import static com.revature.Question3.reverseWithoutTempVar;
import static org.junit.Assert.*;

import org.junit.Test;

public class Question3Test {

	@Test
	public void testReverseWithoutTempVar() {
		assertEquals("Test empty String for sanity check", "",
				reverseWithoutTempVar(""));
		assertEquals("Test one-letter String for sanity check", "a",
				reverseWithoutTempVar("a"));
		assertEquals("Test two-letter String for sanity check", "az",
				reverseWithoutTempVar("za"));
		assertEquals("Test three-letter String for sanity check", "tac",
				reverseWithoutTempVar("cat"));
		assertEquals("torrac should be carrot spelled backward.", "carrot",
				reverseWithoutTempVar("torrac"));
		System.out.println("Question 3 test cases passed!");
	}

}
