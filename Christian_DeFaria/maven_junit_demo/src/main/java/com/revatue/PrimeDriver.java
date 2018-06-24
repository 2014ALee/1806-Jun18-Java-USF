package com.revatue;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

/*
 * if y = y^x%x then x is probably prime
 */
public class PrimeDriver {
	
	public static void main(String[] args) {
		//does not account for Carmicheal numbers
		BigInteger testNum = BigInteger.valueOf(561);
		System.out.println(isPrime(testNum));
		
	}

	public static boolean isPrime(BigInteger canidate) {
		boolean isPrime = false;
		HashSet<BigInteger> testSet = populateSet(canidate);
		
		System.out.println("Prime Canidate is " + canidate);
		
		/*
		 * 
		 */
		for(BigInteger y : testSet) {
			System.out.println("Test element is " + y);
			
			BigInteger result = y.pow(canidate.intValue()).mod(canidate);
			
			if(result.equals(y)) {
				isPrime = true;
			} else {
				return false;
			}
		}
		
		return isPrime;
	}

	public static HashSet<BigInteger> populateSet(BigInteger canidate) {
		HashSet<BigInteger> populatedSet = new HashSet<>();
		for(int i = 0; i < 25; i++) {
			long val = ThreadLocalRandom.current().nextInt(2, canidate.intValue());
			BigInteger randomValue = BigInteger.valueOf(val);
			populatedSet.add(randomValue);
		}
		return populatedSet;
	}

}
