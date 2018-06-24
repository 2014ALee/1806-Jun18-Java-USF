package com.floatvariable;

import org.junit.Before;
import org.junit.Test;

public class FloatVariableClassTest {
	
	FloatVariableClass checkingB = new FloatVariableClass();
	FloatVariableClass savingsB = new FloatVariableClass();

	@Before
	public void init() {
		checkingB.myCheckingBalance = 3.4f;
		savingsB.mySavingsBalance = 59.33f;
	}

	@Test
	public void testGetVariables() {
		checkingB.getVariables();
		savingsB.getVariables();	
	}

}
