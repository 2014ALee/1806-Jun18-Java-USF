package answers.tests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import answers.Question9;

class Question9Test {

	@Test
	public void testIsPrimeTrue() {
		int num = 17;
		assertTrue(Question9.isPrime(num));
	}
	
	@Test
	public void testIsPrimeFalse() {
		int num = 16;
		assertFalse(Question9.isPrime(num));
	}

}
