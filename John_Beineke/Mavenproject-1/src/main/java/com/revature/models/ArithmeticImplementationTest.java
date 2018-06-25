package com.revature.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ArithmeticImplementationTest {

	@Test
	public void testArithmeticImplementationAddition() {
		ArithmeticImplementation tester = new ArithmeticImplementation();
		assertEquals(73, tester.addition(21, 52), 0);
	}
	
	@Test
	public void testArithmeticImplementationSubtraction() {
		ArithmeticImplementation tester = new ArithmeticImplementation();
		assertEquals(819, tester.subtraction(1275,456), 0);
	}
	
	@Test
	public void testArithmeticImplementationMultiplication() {
		ArithmeticImplementation tester = new ArithmeticImplementation();
		assertEquals(1630, tester.subtraction(10,163), 0);
	}
	
	@Test
	public void testArithmeticImplementationDivision() {
		ArithmeticImplementation tester = new ArithmeticImplementation();
		assertEquals(31.5, tester.division(126,4), 0);
	}

}
