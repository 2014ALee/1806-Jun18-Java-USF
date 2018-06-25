/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q19ArrayPrintEven.java
 * Code for Q19 of Core Java Assignment. Print out an array from one to 10 in an ArrayList.
 *  Add up the even numbers. Add up the odd numbers. Take out the primes. Displays the results.
 */
package com.revature;

import java.util.ArrayList;

public class Q19ArrayMethods {
	public static void main(String[] args) {
		int evenSum = 0;
		int oddSum = 0;
		int idx = 0;
		boolean[] isPrime;
		ArrayList<Integer> intArray = new ArrayList<>();

		// setting up array
		for(int i = 0; i < 10; i++) {
			intArray.add(i+1);
		}

		// intializing array for primes
		isPrime = new boolean[intArray.size()];

		// setting up array for primes
		for(int i = 0; i < isPrime.length; i++) {
			isPrime[i] = true;
		}

		System.out.print("Array: ");
		for(int i : intArray) {
			System.out.print(i + " ");

			// Summing with the same if statement
			if((i % 2) == 0) {
				evenSum += i;
			} else {
				oddSum += i;
			}

			if(i == 1) {
				isPrime[idx] = false;
			}
			else {
				for(int j = 2; j <= i/2; j++) {
					if((i % j) == 0) {
						isPrime[idx] = false;
						break;
					}
				}
			}

			idx++;
		}

		System.out.print("\n");

		System.out.println("The sum of evens: " + evenSum);
		System.out.println("The sum of odds: " + oddSum);

		// Couldn't remove in the enhanced for loop. Had to be done separately.
		for(int i = isPrime.length-1; i >= 0; i--) {
			if(isPrime[i]) intArray.remove(i);
		}

		System.out.print("Primeless Array: ");
		for(int i : intArray) {
			System.out.print(i + " ");
		}
	}
}