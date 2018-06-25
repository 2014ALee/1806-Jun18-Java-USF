package answers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import answers.Question6;

class Question6Test {

	@Test
	public void testIsEven4() {
		assertTrue(Question6.isEven(4));
	}
	
	@Test
	public void testIsEven5() {
		assertFalse(Question6.isEven(5));
	}

}
