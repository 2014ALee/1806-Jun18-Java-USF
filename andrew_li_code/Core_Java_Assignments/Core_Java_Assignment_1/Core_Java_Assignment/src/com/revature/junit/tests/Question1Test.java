package com.revature.junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.revature.Question1;

class Question1Test {

	@Test
	void test() {
		int[] array = new int[] {
				9,2,5,3,8,1,5,6,9,14,12,9
		};
		int[] sortedArray = new int[] {
				1,2,3,5,5,6,8,9,9,9,12,14
		};
		Question1.sort(array);
		System.out.println(Arrays.equals(array, sortedArray));
	}

}
