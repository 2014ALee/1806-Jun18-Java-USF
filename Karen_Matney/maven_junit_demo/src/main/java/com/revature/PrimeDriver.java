package com.revature;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

/*
 * if y = y^x %x, then x is PROBABLY prime
 */
public class PrimeDriver {
	public static void main(String[] args) {
		BigInteger testNum = BigInteger.valueOf(561); // Carmichael number (composite, but passes)
		System.out.println(isPrime(testNum));
	}
	
	public static boolean isPrime(BigInteger candidate) {
		boolean isPrime = false;
		
		HashSet<BigInteger> testSet = populateSet(candidate);
		/*
		 * Test the candidate for primality using Fermat's Little Theorem
		 * 
		 * Prime candidate: x, where x > 1
		 * Test element: y, where y < x && y > 1
		 * 
		 * If y  = y^x %x, then x is Probably prime. Otherwise, it is composite.
		 */
		
		for(BigInteger testElement : testSet) {
			System.out.println("Test element: " + testElement);
			
			BigInteger result = testElement.pow(candidate.intValue()).mod(candidate);
			
			if(result.equals(testElement)) {
				isPrime = true;
			} else {
				return false;
			}
		}
		return isPrime;
	}
	
	public static HashSet<BigInteger> populateSet(BigInteger candidate) {
		HashSet<BigInteger> populatedSet = new HashSet<>();
		
		for(int i = 0; i < 25; i++) {
			
			long val = ThreadLocalRandom.current().nextInt(2, candidate.intValue());
			BigInteger randomValue = BigInteger.valueOf(val);
			populatedSet.add(randomValue);
		}
		
		return populatedSet;
	}
}
