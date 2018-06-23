package com.revature;

public class evenNums {
	public static void main(String[] args) {
		EvenSteven even = new EvenSteven();
		int[] nums = new int[100];
		for (int i = 1; i < 100; i++)
			nums[i] = i;
		for(int num : nums)
			if (even.isEven(num))
				System.out.println(num);
	}
}
