package com.revature;

import java.util.ArrayList;

public class Question19 {
	private static Question19 singleton = null;
	private ArrayList<Integer> arrayList;
	private int oddSum;
	private int evenSum;


	private Question19() {}
	// Takes care of creating arraylist from 1 through ten, and
	// calculating the two sums. Returns a value so we can 
	// test it outside of the class
	public static Question19 generate(int number) {
		if (singleton != null) {
			return singleton;
		}
		singleton = new Question19();
		singleton.arrayList = new ArrayList<Integer>(number);
		int index = 0;
		while (index < number) {
			singleton.arrayList.add(index, ++index);
		}
		
		singleton.oddSum = 0;
		singleton.evenSum = 0;
		
		for (int val : singleton.arrayList) {
			if (val % 2 == 0) {
				singleton.evenSum += val;
			}
			else {
				singleton.oddSum += val;
			}
		}
		return singleton;
		
	}
	// Variables of items that we would want to test.
	public int getEvenSum() {
		return evenSum;
	}
	public int getOddSum() {
		return oddSum;
	}
	public ArrayList<Integer> getArrayList() {
		return arrayList;
	}
	public static void main(String[] args) {
		// The ArrayList for this problem for us to store numbers.
		Question19 gen = Question19.generate(10);
		
		System.out.println("Odd Sum: " + gen.getOddSum());
		System.out.println("Even Sum: " + gen.getEvenSum());
		
		ArrayList<Integer> myArrayList = gen.getArrayList();
		/*
		 * Removing primes
		 */
		gen.removePrimes();
		System.out.println("ArrayList without primes is: "
				+ myArrayList);
	}
	public void removePrimes() {
		for (int i = 0; i < arrayList.size(); i++) {
			if (isPrime(arrayList.get(i))) {
				arrayList.remove(i--);
			}
		}
	}
	/*
	 * Testing if number is prime.
	 * We're only using this function here.
	 */
	private static boolean isPrime(int input) {
		/* 1 is technically not prime based
		 * on mathematical definition.
		 */
		if (input == 1) {
			return false;
		}
		
		/*
		 * If number has any divisor k such that
		 * 2 >= k >= sqrt(number), number is not prime.
		 */
		for (int i = 2; i * i <= input; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
}