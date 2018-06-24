package J_Unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import homework_week1.questions.Question2;

public class Question2Test {

	@Test
	public void is0plus1EqualTo1() {
		
		assertEquals("Checking if 0 + 1 equals 1", 2, Question2.computeNextNumber(0, 1));
		
	}

}
