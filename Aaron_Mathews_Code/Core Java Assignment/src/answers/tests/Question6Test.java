package answers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import answers.Question6;

class Question6Test {

	@Test
	public void testIsEven4() {
		assertEquals(true, Question6.isEven(4));
	}
	
	@Test
	public void testIsEven5() {
		assertEquals(false, Question6.isEven(5));
	}

}
