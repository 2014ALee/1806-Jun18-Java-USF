package com.revature.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Q3;

class Q3Test {

	@Test
	void reverseTest() {
		String reverseme = "lol";
		String unreversed = "lol";
		assertEquals("String should be reversed", true, unreversed.equals(Q3.stringReverser(reverseme)));
	}

}
