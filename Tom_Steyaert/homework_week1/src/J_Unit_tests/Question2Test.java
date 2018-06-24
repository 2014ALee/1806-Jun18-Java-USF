package J_Unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import homework_week1.questions.Question2;

public class Question2Test {

	@Test
	public void fibNumber25Is46368() {
	
		assertEquals("this method returns the 25th Fibonacci number, 46368", 46368, Question2.showFibonacci(0, 1, 23));

	}


	@Test
	public void is0plus1EqualTo1() {

		assertEquals("Checking if 0 + 1 equals 1", 1, Question2.computeNextNumber(0, 1));

	}

}
