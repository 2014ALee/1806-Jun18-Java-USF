package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q5SubstringTest {

	@Test
	public void substringTest() {
		assertEquals("Returned correct substring","qwer",Q5Substring.substring("qwerty",4));
	}

	@Test
	public void oddSubstringTest() {
		assertEquals("Returned correct substring","qwert",Q5Substring.substring("qwertyuiop",5));
	}
}
