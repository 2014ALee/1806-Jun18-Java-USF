package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubStringTest {

	@Test
	public void testSubStringBuilder() {
		SubString sub = new SubString();
		assertTrue("They are not equal","Smi".equals(sub.subStringBuilder("Smith", 3)));
	}
}
