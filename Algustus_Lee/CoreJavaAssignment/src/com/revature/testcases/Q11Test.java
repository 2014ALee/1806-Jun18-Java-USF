package com.revature.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.models.Q11FloatHolder;

class Q11Test {

	@Test
	void test() {
		Q11FloatHolder testFloatHolder = new Q11FloatHolder();
		assertEquals("The test can call from instantiated objects too. the f1 value is 22.4",22.4f,testFloatHolder.f1,0);
	}

}
