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
		PrimeArrayList pra = new PrimeArrayList();
		for (int num : nums)
			if (pra.isPrime(num))
				System.out.println(num);
	}
	public boolean isPrime(int num) {
			int counter = 0;
			EvenSteven even = new EvenSteven();
			if(!(even.isEven(num)))
				for(int i = num; i>= 1; i--)
					if(num%i == 0)
						counter = counter +1;
				if (counter == 2)
					return true;
		return false;
	}
}
