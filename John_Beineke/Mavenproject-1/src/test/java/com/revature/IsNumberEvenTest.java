package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IsNumberEvenTest {

	@Test
	public void is2238Even() {
		IsNumberEven tester = new IsNumberEven();
		assertEquals("2238 is Even", true, tester.testEven(2238));
	}
	
	@Test
	public void is1377Even() {
		IsNumberEven tester = new IsNumberEven();
		assertEquals("1377 is Even", false, tester.testEven(1377));
	}

}
