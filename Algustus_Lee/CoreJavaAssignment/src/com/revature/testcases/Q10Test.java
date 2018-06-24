package com.revature.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Q10;

class Q10Test {

	@Test
	void test() {
		assertEquals("2 is the minimum.",2,Q10.minFinder(6, 2));
	}

}
