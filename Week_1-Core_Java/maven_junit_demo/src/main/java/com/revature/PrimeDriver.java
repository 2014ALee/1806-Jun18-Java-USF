package com.revature;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class PrimeDriver {

	public static void main(String[] args) {
		// Working with BigInteger when working with massive numbers (larger than what long allows for)
		BigInteger testNum = BigInteger.valueOf(561); // 561 is the first Carmichael number (composite number that passes primality tests)
		System.out.println(isPrime(testNum));
	}

	public static boolean isPrime(BigInteger number) {

		boolean isPrime = false;
		HashSet<BigInteger> testSet = populateSet(number);

		System.out.println("Prime candidate: " + number);

		/*
		 * Tests number for primality using Fermat Little Theorem
		 * 
		 * Prime candidate: x, where x > 1
		 * Test element: y, where y < x && y > 1
		 * 
		 * If y = y^x % x, then x is prime. Otherwise, x is composite.
		 */
		for (BigInteger testElement : testSet) {
			System.out.println("Test element: " + testElement);

			BigInteger testResult = testElement.pow(number.intValue()).mod(number);

			if(testResult.equals(testElement)) {
				isPrime = true;
			} else {
				return false;
			}
		}
		return isPrime;
	}

	/*
	 * For this probablistic primality test to work, we need to collect a random set of numbers smaller than the
	 * candidate number, but larger than 1. In this case, we are grabbing 25 random values to use in the primality
	 * test.
	 */
	public static HashSet<BigInteger> populateSet(BigInteger number) {
		HashSet<BigInteger> populatedSet = new HashSet<>();
		for (int i = 0; i < 25; i++) {
			BigInteger randValue = BigInteger.valueOf(ThreadLocalRandom.current().nextInt(2, number.intValue()));
			populatedSet.add(randValue);
		}
		return populatedSet;
	}

}
