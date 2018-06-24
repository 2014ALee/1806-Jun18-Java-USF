package J_Unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import homework_week1.questions.Question5;

public class Question5Test {

	@Test
	public void testSubstring() {

		assertEquals("Andrew Li","Andrew", Question5.computeSubstring("Andrew Li", 6));
		
	}

}
