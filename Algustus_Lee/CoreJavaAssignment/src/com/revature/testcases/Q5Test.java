package com.revature.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Q5;

class Q5Test {

	@Test
	void test() {
		String testString = "hype";
		assertEquals("If you take the first four letters of hyperbole, you get \"hype\"", true,testString.equals(Q5.stringMaker("hyperbole", 4)));
	}

}
