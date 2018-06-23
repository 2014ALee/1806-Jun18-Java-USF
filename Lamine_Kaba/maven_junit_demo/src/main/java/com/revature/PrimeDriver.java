package com.revature;

import java.math.BigInteger;
import java.util.HashSet;

public class PrimeDriver {
	
	/*
	 * if y = y^x % x, then x is probably prime
	 */
	
	public static void main(String[] args) {
		
		BigInteger testNum = BigInteger.valueOf(13);
		System.out.println(isPrime(testNum));
	}
	
	public static boolean isPrime(BigInteger candidate) {
		boolean isPrime = false;
		HashSet<BigInteger> testSet = populateSet(candidate);
		
		return isPrime;
	}
	
	public static HashSet<BigInteger> populateSet(BigInteger candidate) {
		HashSet<BigInteger> populatedSet = new HashSet<>();
		return populatedSet;
	}
	

}
