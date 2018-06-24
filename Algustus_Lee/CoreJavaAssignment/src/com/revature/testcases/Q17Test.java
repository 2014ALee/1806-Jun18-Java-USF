package com.revature.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Q17;

class Q17Test {

	@Test
	void test() {
		assertEquals("20% interest on $20 after a year is $4.",4f,Q17.interestCalculator(20f, 1f, .2f),0);
	}

}
