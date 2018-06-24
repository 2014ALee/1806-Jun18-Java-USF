package com.revature;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class PrimeDriverTest {

	@Test
	public void is113Prime() {
		assertEquals("113 is prime", true, PrimeDriver.isPrime((BigInteger.valueOf(113))));
	}

}