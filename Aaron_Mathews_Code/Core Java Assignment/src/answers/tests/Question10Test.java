package answers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import answers.Question10;

class Question10Test {

	@Test
	public void testMin() {
		int a = 78;
		int b = 23;
		
		assertEquals(23, Question10.findMin(a, b));
	}

}
