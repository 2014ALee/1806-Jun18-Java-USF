package com.revature;

import java.util.ArrayList;

public class Question19 {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 1; i < 11; i++)
			list.add(i);

		displayArray(list);
		System.out.println();
		displayEvenSum(list);
		System.out.println();
		displayOddSum(list);
		System.out.println();
		removePrimes(list);
		displayArray(list);
	}

	public static void displayArray(ArrayList<Integer> list) {
		for(int num : list)
			System.out.println(num);
	}

	public static void displayEvenSum(ArrayList<Integer> list) {
		int evenSum = 0;
		for(int num : list)
			evenSum = (((num) % 2) == 0) ? (evenSum + num) : evenSum;
			System.out.println("Even sum: " + evenSum);
	}

	public static void displayOddSum(ArrayList<Integer> list) {
		int oddSum = 0;
		for(int num : list)
			oddSum = (((num) % 2) != 0) ? (oddSum + num) : oddSum;
			System.out.println("Odd sum: " + oddSum);
	}

	public static void removePrimes(ArrayList<Integer> list) {
		ArrayList<Integer> primes = new ArrayList<>();

		for(int num : list) {
			if (isPrime(num))
				primes.add(num);
		}

		for (int num : primes) {
			list.remove(list.indexOf(num));
		}
		
		System.out.println("Primes removed.");
	}

	public static boolean isPrime(int N) {
		if(N > 3) 
			for (int i = 2; i < N; i++)
				if((N % i) == 0)
					return false;
		return true;
	}
}
