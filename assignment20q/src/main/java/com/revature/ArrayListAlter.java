package com.revature;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListAlter {

	public static void main(String[] args) {
		EvenSteven even = new EvenSteven();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++)
			nums.add(i);
		System.out.println(Arrays.toString(nums.toArray()));
		int posSum = 0;
		int negSum = 0;
		for (int num : nums)
			if (even.isEven(num))
				posSum = posSum + num;
			else
				negSum = negSum + num;
		System.out.println(posSum);
		System.out.println(negSum);
		nums.removeIf(n -> PrimeArrayList.isPrime(n));
		System.out.println(Arrays.toString(nums.toArray()));
	}
}
