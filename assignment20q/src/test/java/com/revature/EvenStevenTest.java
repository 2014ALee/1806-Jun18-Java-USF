package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class EvenStevenTest {

	@Test
	public void testIsEven() {
		EvenSteven even = new EvenSteven();
		int[] nums = new int[100];
		for (int i = 1; i < 100; i++)
			nums[i] = i;
		for(int num : nums)
			if (even.isEven(num))
				System.out.println(num);
		int i = 10;
		assertTrue("It is not even.",even.isEven(i));
	}

}
