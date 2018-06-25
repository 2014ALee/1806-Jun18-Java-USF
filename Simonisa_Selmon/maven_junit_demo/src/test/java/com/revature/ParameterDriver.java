package com.revature;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Fermats Little Theorem  if y= y^x % x, then x is PROBABLY prime
 */

public class ParameterDriver {
	
	public static void main(String[] args) {
		
		BigInteger testNum= BigInteger.valueOf(13);
		System.out.println(isPrime(testNum));
		
		for (BigInteger testElement: testSet) {
			System.out.println("Test element:" + testElement);
		}
		
	}
	
	public static boolean isPrime(BigInteger candidate) {
		
		boolean isPrime= false;
		
		HashSet<BigInteger> testSet= populateSet(candidate);
		
		return isPrime;
	}
	
	public static HashSet<BigInteger> populateSet(BigInteger candidate) {
		
		HashSet<BigInteger> populatedSet= new HashSet<>();
		
		for(int i= 0; i<25; i++) {
			
			int val= ThreadLocalRandom.current().nextInt(2, candidate.intValue());
			BigInteger randomValue= BigInteger.valueOf(val);
			populatedSet.add(randomValue);
			
			return populatedSet;
			
			}
	}

}
