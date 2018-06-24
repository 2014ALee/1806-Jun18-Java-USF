package com.revature.testcases;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import com.revature.Q1;

public class Q1Test {

	@Test
	public void sortTester()
	{
		int[] sorted = {1,4,7,14,20};
		int[] jumbled = {20,7,4,1,14};
		assertArrayEquals("the bubblesort should work correctly",sorted,Q1.arraySorter(jumbled) );
	}
}
