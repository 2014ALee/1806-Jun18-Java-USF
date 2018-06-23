package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrimeArrayListTest {

	@Test
	public void testIsPrime() {
		PrimeArrayList pra = new PrimeArrayList();
		int i = 561;
		assertTrue("It is not Prime",pra.isPrime(i));
	}
}
