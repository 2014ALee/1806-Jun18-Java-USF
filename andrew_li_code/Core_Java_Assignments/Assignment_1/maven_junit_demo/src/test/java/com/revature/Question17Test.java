package com.revature;

import static org.junit.Assert.*;
import static com.revature.Question17.getPrintedStatement;

import org.junit.Test;

public class Question17Test {

	@Test
	public void testGetPrintedStatement() {
		String negatives = getPrintedStatement("-100", "-0.02", "-12");
		assertEquals("invalid: -100 exists", negatives.indexOf(
				"invalid: -100") >= 0, true);
		assertEquals("invalid: -0.02 exists", negatives.indexOf(
				"invalid: -0.02") >= 0, true);
		assertEquals("invalid: -12 exists", negatives.indexOf(
				"invalid: -12") >= 0, true);
		
		String invalidNumber = getPrintedStatement("plain", "0.1", "10");
		assertEquals("invalid: plain", invalidNumber.indexOf(
				"invalid: plain") >= 0, true);
		assertEquals("invalid: 0.1", invalidNumber.indexOf(
				"invalid: 0.1") >= 0, false);
		assertEquals("invalid: 10", invalidNumber.indexOf(
				"invalid: 10") >= 0, false);
		
		String spacing = getPrintedStatement("100000", " ", "");
		assertEquals("invalid:  ", spacing.indexOf(
				"invalid:  ") >= 0, true);
		assertEquals("invalid: ", spacing.indexOf(
				"years") >= 0, true);
		
		assertEquals("Valid numbers, 100000, 0.2, 20",
				getPrintedStatement("100000", "0.2", "20").indexOf(
						"is 400000") >= 0, true);
		System.out.println("Passed test cases for Question 17!");
	}

}
