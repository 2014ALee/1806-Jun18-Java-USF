package com.revature;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

/*
 * testing for primality
 * 
 * if y = y^x% x, then x is probably prime // dont need to know primality algs, just an example
 */
public class PrimeDriver {
	public static void main(String[] args) {

		BigInteger testNum = BigInteger.valueOf(13);
		System.out.println(isPrime(testNum));
	}

	public static boolean isPrime(BigInteger candidate) {
		boolean isPrime = false;

		HashSet<BigInteger> testSet = populateSet( candidate	);
		return isPrime;
	}
	
	public static HashSet<BigInteger> populateSet(BigInteger candidate){
		HashSet<BigInteger> populatedSet = new HashSet<>();
		
		int val = ThreadLocalRandom.current()	.nextInt(2, candidate.intValue());
		BigInteger randomValue = BigInteger.valueOf(val1);
		
		return populatedSet;
	}

}
