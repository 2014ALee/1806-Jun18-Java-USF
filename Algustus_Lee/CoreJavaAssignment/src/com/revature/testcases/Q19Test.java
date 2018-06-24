package com.revature.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.Q19;

class Q19Test {

	@Test
	void test1() {
		List<Integer> theList = new ArrayList<>();
		theList.add(1);
		theList.add(2);
		theList.add(3);
		theList.add(4);
		theList.add(5);
		theList.add(6);
		theList.add(7);
		theList.add(8);
		theList.add(9);
		theList.add(10);
		assertEquals("1+3+5+7+9 = 25",25,Q19.oddSumGetter(theList));
	}
	@Test
	void test2() {
		List<Integer> theList = new ArrayList<>();
		theList.add(1);
		theList.add(2);
		theList.add(3);
		theList.add(4);
		theList.add(5);
		theList.add(6);
		theList.add(7);
		theList.add(8);
		theList.add(9);
		theList.add(10);
		assertEquals("2+4+6+8+10 = 30",30,Q19.evenSumGetter(theList));
	}
	@Test
	void test3() {
		List<Integer> theList = new ArrayList<>();
		theList.add(1);
		theList.add(2);
		theList.add(3);
		theList.add(4);
		theList.add(5);
		theList.add(6);
		theList.add(7);
		theList.add(8);
		theList.add(9);
		theList.add(10);
		assertEquals("With prime numbers removed, there are only six numbers between 1 and 10",6,Q19.primeRemover(theList).size());
	}

}
