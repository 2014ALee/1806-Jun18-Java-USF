package com.revature.testcases;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.Q8;

public class Q8Test {

	@Test
	public void test() {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		list1.add("mommy");
		list1.add("daddy");
		list1.add("brother");
		list1.add("sister");
		
		assertEquals("There are no palindromes in this list.",list2.size() ,Q8.palindromeChecker(list1, list2).size());
	}

}
