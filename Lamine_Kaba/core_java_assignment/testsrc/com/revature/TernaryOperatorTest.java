package com.revature;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TernaryOperatorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		TernaryOperator myOp = new TernaryOperator();
	}

	@Test
	public void testTernaryOperator() {
		TernaryOperator.ternaryOperator();
	}

}
