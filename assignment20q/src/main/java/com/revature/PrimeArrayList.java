package com.revature;

import java.util.ArrayList;

public class PrimeArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++)
			nums.add(i);
		primes(nums);
	}
	public static void primes(ArrayList<Integer> nums) {
		for (int num : nums)
			if (isPrime(num))
				System.out.println(num);
	}
	public static boolean isPrime(int num) {
			int counter = 0;
			for(int i = num; i>= 1; i--)
				if(num%i == 0)
					counter = counter +1;
			if (counter == 2)
				return true;
		return false;
	}
}
