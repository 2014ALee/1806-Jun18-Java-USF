package answers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import answers.Question4;

class Question4Test {

	@Test
	public void testFactorial2() {
		assertEquals(2, Question4.factorial(2));
	}
	
	@Test
	public void testFactorial4() {
		assertEquals(24, Question4.factorial(4));
	}

}
