package J_Unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import homework_week1.questions.Question15;

public class Question15Test {

	Question15 problemSolver = new Question15();	
	
	@Test
	public void testAddition() {
		assertEquals("9 + 4 equals 13", 13, problemSolver.addition(9, 4));
	}
	
	@Test
	public void testSubtraction() {
		assertEquals("100 - 45 equals 55", 55, problemSolver.subtraction(100, 45));
	}
	
	@Test
	public void testMultiplication() {
		assertEquals("10 * 5 equals 50", 50, problemSolver.multiplication(10, 5));
	}
	
	@Test
	public void testDivision() {
		assertEquals("100 / 10 equals 10", 10, problemSolver.division(100, 10));
	}
	
}
