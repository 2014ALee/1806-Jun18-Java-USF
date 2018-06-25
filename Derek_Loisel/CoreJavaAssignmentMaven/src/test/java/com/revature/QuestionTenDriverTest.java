package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;


public class QuestionTenDriverTest {

	@Test
	public void test() {

		//create ints to test
		int minimum1 = 1;
		int testMinimum1 = 1;
		int testMinimum2 = 9;
		//use the findMinimumInt() function
		int minimum2 = QuestionTenDriver.findMinimumInt(testMinimum1, testMinimum2);
		//test the function result with the minimum
		assertEquals("The findMinimumInt() function didn't return the correct value", minimum1, minimum2);

	}

}
