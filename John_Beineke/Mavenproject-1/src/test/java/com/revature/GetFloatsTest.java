package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class GetFloatsTest {

	@Test
	public void testGetFloat1() {
		assertEquals("Should retrieve ", 3.45, GetFloats.getFloat1());
	}

}
