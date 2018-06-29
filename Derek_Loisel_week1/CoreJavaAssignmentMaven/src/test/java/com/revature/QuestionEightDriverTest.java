package com.revature;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class QuestionEightDriverTest {

	@Test
	public void test() {

		//create an array list of only palindromes to compare
		ArrayList<String> arrayList1 = new ArrayList<>();
		arrayList1.add("dood");
		arrayList1.add("zerorez");
		
		//create an array list of strings to test that it returns only the palindromes
		ArrayList<String> arrayList2 = new ArrayList<>();
		arrayList2.add("dood");
		arrayList2.add("brenda");
		arrayList2.add("tommy");
		arrayList2.add("zerorez");
		
		//use the function on arrayList2 to test it
		arrayList2 = QuestionEightDriver.createPalindromesArrayList(arrayList2);

		//test that the arrayList2 was properly modified to match arrayList1
		assertArrayEquals("The createPalindromesArrayList() function didn't return the correct array of palindromes", arrayList1.toArray(), arrayList2.toArray());
		
	}

}
