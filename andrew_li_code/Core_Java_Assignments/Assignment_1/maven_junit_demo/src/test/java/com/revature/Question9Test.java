package com.revature;

import static com.revature.Question9.isPrime;
import static org.junit.Assert.*;

import org.junit.Test;

public class Question9Test {

	@Test
	public void test() {
		assertEquals("Testing for prime", isPrime(47), true); 
		assertEquals("Testing for prime", isPrime(53), true); 
		assertEquals("Testing for prime", isPrime(59), true); 
		assertEquals("Testing for prime", isPrime(61), true); 
		assertEquals("Testing for prime", isPrime(67), true); 
		assertEquals("Testing for prime", isPrime(71), true); 
		assertEquals("Testing for prime", isPrime(73), true); 
		assertEquals("Testing for prime", isPrime(79), true); 
		assertEquals("Testing for prime", isPrime(83), true); 
		assertEquals("Testing for prime", isPrime(89), true); 
		assertEquals("Testing for prime", isPrime(97), true); 
		assertEquals("Testing for prime", isPrime(62), false); 
		assertEquals("Testing for prime", isPrime(65), false); 
		assertEquals("Testing for prime", isPrime(87), false); 
		assertEquals("Testing for prime", isPrime(49), false); 
		assertEquals("Testing for prime", isPrime(77), false); 
		assertEquals("Testing for prime", isPrime(54), false);
		System.out.println("Question 9 tests passed!");
	}

}
