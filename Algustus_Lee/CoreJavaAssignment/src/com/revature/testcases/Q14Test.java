package com.revature.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Q14;

class Q14Test {

	@Test
	void stringSplitTest() {
		assertEquals("This phrase should be split into eight words", 8, Q14.stringSplitter("This phrase should be split into eight words").length);
	}

}
