package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Question6Test {

	@Test
	public void isItEvenTest1() {
		assertEquals(true , Question6.isItEven(6));
	}
	
	@Test
	public void isItEvenTest2() {
		assertEquals(false, Question6.isItEven(9));
	}
}
