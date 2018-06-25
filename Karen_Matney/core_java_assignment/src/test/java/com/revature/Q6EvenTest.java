package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q6EvenTest {

	@Test
	public void positiveEven() {
		assertEquals("Postive even returns true",true,Q6Even.isEven(46));
	}
	
	@Test
	public void negativeEven() {
		assertEquals("Postive even returns true",true,Q6Even.isEven(-56));
	}
	
	@Test
	public void positiveOdd() {
		assertNotEquals("Postive even returns true",true,Q6Even.isEven(37));
	}
	
	@Test
	public void negativeOdd() {
		assertNotEquals("Postive even returns true",true,Q6Even.isEven(-345));
	}
	
	@Test
	public void zero() {
		assertEquals("Postive even returns true",true,Q6Even.isEven(0));
	}
}
