package homework_week1.questions;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question9Test {

	@Test
	public void is53PrimeTest() {
		
	assertEquals("53 is prime, so we should return true", true, Question9.isPrime(53));
		
	}
}
