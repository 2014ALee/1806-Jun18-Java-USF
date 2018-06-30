// TODO: Fix
package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q10TernaryTest {

	@Test
	public void minFirst() {
		assertEquals("Works with min first",10.0d,Q10Ternary.minimum(10,30),0.0001);
	}
	
	@Test
	public void minLast() {
		assertEquals("Works with min last",10.0d,Q10Ternary.minimum(30, 10),.0001);
	}
	
	@Test
	public void bothEqual() {
		assertEquals("Works with both being equals", 10.0d, Q10Ternary.minimum(10, 10),0.0001);
	}

}
