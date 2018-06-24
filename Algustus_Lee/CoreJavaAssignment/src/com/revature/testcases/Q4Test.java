package com.revature.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Q4;

class Q4Test {

	@Test
	void test() {
		assertEquals("the factorial of 4 is 24", 24, Q4.getFactorial(4));
	}

}
