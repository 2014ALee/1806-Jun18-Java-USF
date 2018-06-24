package J_Unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import homework_week1.questions.Question4;

public class Question4Test {

	@Test
	public void factorialTest() {
		assertEquals("5! equals 120", 120, Question4.computeFactorial(5));
	}

}
