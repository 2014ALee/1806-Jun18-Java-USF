package com.revature.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Q6;

class Q6Test {

	@Test
	void test() {
		assertEquals("7 is not an even number",false,Q6.evenOrOdd("7"));
	}

}
