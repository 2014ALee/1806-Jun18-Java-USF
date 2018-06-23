package com.revature;


import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class PalindromesTest {

	@Test
	public void testIsDrome() {
		ArrayList<String> words = new ArrayList<String>();
		words.addAll(Arrays.asList("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"));
		ArrayList<String> words2 = new ArrayList<String>();
		words2.addAll(Arrays.asList("madam", "civic", "radar", "kayak", "refer", "did"));

		Assert.assertTrue("They are not equal",(words2).equals(Palindromes.isDrome(words)));

	}

}
