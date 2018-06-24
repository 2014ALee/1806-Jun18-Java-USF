package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import answers.Question4;

public class Question4Test {
	
	@Test
	public void testFactorial() {
		int num = 5;
		int numFactorial = 120;
		assertEquals("Testing the factorial method", numFactorial, Question4.factorial(num));
	}

}
