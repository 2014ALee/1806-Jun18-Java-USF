package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q3ReverseStringTest {

	@Test
	public void worksOnEven() { // number of characters
		assertEquals("Works on Even","ytrewq",Q3ReverseString.reverse("qwerty"));
	}
	
	@Test
	public void worksOnOdd() { // number of characters
		assertEquals("Works on Even","trewq",Q3ReverseString.reverse("qwert"));
	}

}
