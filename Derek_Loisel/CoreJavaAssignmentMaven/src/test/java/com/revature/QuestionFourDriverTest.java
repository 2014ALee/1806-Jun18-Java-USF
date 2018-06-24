package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionFourDriverTest {

	@Test
	public void test() {

		//ints to test the factorial of 5 with the computeFactorial() method
		int fact1 = 1*2*3*4*5;
		int fact2 = 5;
		
		assertEquals("The computeFactorial() method didn't produce the correct int", fact1, QuestionFourDriver.computeFactorial(fact2));
	}

}
