package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

//the test cases for the Q15 question
public class Q15Test {
	@Test
	public void addTest()
	{
		assertEquals("4+5 = 9", 9, Q15Interface.addition(4, 5));
	}
	@Test
	public void subtractTest()
	{
		assertEquals("5-4 = 1", 1, Q15Interface.subtraction(5, 4));
	}
	@Test
	public void multipltyTest()
	{
		assertEquals("4*5 = 20", 20, Q15Interface.multiplication(4, 5));
	}
	@Test
	public void divideTest()
	{
		assertEquals("20/5 = 4", 4, Q15Interface.division(20, 5));
	}

	

}
