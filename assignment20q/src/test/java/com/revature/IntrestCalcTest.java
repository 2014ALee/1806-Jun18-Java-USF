package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntrestCalcTest {

	@Test
	public void testintrestCalc() {

		IntrestCalc intC = new IntrestCalc();
		double principal = 10000;
		double rate =  0.1;
		int years = 10;
		assertTrue("true",10000d == intC.intrestCalc(principal, rate, years));
		
	}

}
