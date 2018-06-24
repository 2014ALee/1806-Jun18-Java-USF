package com.revature.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Q16;

class Q16Test {

	@Test
	void test() {
		assertEquals("\"You Say run\" has a total of 9 char values.", 9, Q16.charCounter("You Say Run"));
	}

}
