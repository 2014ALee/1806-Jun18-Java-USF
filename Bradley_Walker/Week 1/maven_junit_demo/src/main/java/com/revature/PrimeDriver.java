package com.revature;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

/*
 * If y = y^x %x, then x is probably prime
 */

public class PrimeDriver {
	
	public static void main(String[] args) {
		BigInteger testNum = BigInteger.valueOf(561);
		System.out.println(isPrime(testNum));
	}

	public static boolean isPrime(BigInteger candidate) {
		HashSet<BigInteger> testSet = populateSet(candidate);
		
		System.out.println("Prime candidate: " + candidate);
		
		/*
		 * Test for primality using Fermat's Little Theorem
		 */
		for(BigInteger testElement : testSet) {
			System.out.println("Test element: " + testElement);
			
			BigInteger result = testElement.pow(candidate.intValue()).mod(candidate);
			
			if(!result.equals(testElement))
				return false;
		}
		
		return true;
	}

	public static HashSet<BigInteger> populateSet(BigInteger candidate) {
		HashSet<BigInteger> populatedSet = new HashSet<>();
		
		for(int i = 0; i < 25; i++) {
			int val = ThreadLocalRandom.current().nextInt(2,candidate.intValue());
			BigInteger randomValue = BigInteger.valueOf(val);
			populatedSet.add(randomValue);
		}
		
		return populatedSet;
	}
}
