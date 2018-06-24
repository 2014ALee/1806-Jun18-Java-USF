package com.revature;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class PrimeDriver {
	
	/*
	 * Fermats little theorem
	 * if y = y^x%x, then x is Probably prime
	 */
	
	public static void main(String[] args) {
		
		BigInteger testNumber = BigInteger.valueOf(2345453);
		System.out.println(isPrime(testNumber));
	}
	
	public static boolean isPrime(BigInteger num) {
		boolean isPrime = false;
		
		HashSet<BigInteger> testSet = populateSet(num);
		
		System.out.println(num);
		//Test for primality
		//x > 1
		//y < x && y > 1
		//if y = y ^ x % x, x is probably prime
		
		for (BigInteger testElem : testSet) {
			//System.out.println("Test element: " + testElem);
			
			BigInteger result = testElem.pow(num.intValue()).mod(num);
			
			if (result.equals(testElem)) {
				isPrime = true;
			} else {
				return false;
			}
		}
		
		
		return isPrime;
	}
	
	public static HashSet<BigInteger> populateSet(BigInteger num) {
		HashSet<BigInteger> populatedSet = new HashSet<>(); 
		
		for (int i = 0; i < 25; i++) {
			int val = ThreadLocalRandom.current().nextInt(2, num.intValue());
			BigInteger randomVal = BigInteger.valueOf(val);
			populatedSet.add(randomVal);
		}
		return populatedSet;
	}

}
