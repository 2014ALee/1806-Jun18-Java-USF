package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import answers.Question15;

public class Question15Test {
	
	static double x = Question15.x, y = Question15.y;
	
	@Test
	public void testAddition() {
		assertEquals("Testing addition", true, x + y == Question15.addition());
	}
	
	@Test
	public void testSubtraction() {
		assertEquals("Testing subtraction", true, x - y == Question15.subtraction());
	}
	
	@Test
	public void testMultiplication() {
		assertEquals("Testing multiplication", true, x * y == Question15.multiplication());
	}
	
	@Test
	public void testDivision() {
		assertEquals("Testing division", true, x / y == Question15.division());
	}

}
