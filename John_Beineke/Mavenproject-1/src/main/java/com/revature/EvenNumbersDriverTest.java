package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EvenNumbersDriverTest {

	@Test
	public void testisEven268() {
		EvenNumbersDriver tester = new EvenNumbersDriver();
		assertEquals("Should return true.", true, tester.isEven(268));
	}
	
	@Test
	public void testisEven475() {
		EvenNumbersDriver tester = new EvenNumbersDriver();
		assertEquals("Should return false.", false, tester.isEven(475));
	}

}
