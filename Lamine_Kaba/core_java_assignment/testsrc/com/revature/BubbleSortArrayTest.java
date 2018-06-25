package com.revature;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BubbleSortArrayTest {
	
	int[] array = {1,0,5,6,3,2,3,7,9,8,4};

	@Test
	public void test() {
		BubbleSortArray mySortedArray = new BubbleSortArray();
		mySortedArray.bubbleSortArray(array);
		
		for(int i = 0; i < array.length; i++) {
			
			System.out.print(array[i]);
			System.out.print(" ,");
		}
	}

}
