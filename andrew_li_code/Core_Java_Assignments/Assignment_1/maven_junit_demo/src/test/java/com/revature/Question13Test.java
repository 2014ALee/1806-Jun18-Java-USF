package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question13Test {

	@Test
	public void testMain() {
		Question13.main(new String[0]);
		assertEquals("0\n10\n101\n0101\n is printed",
				Question13.getPrinted(),
				"0\n10\n101\n0101\n");
		System.out.println("Question 13 test case passed!");
	}

}
