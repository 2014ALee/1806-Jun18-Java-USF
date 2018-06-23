package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.models.MathImp;

public class MathDriverTest {
	static MathImp maths = new MathImp();
	@Test
	public void testAdd() {
		int i = 20;
		int j = 5;
		assertTrue("Exspected 25", 25 == maths.add(i, j));
	}
	public void testSubtract() {
		int i = 20;
		int j = 5;

		assertTrue("Exspected 15", 15 == maths.subtract(i, j));
	}
	public void testMultiply() {
		int i = 5;
		int j = 5;

		maths.multiply(i, j);
		assertTrue("Exspected 25", 25 == maths.multiply(i, j));
	}
	public void testDivision() {
		int i = 20;
		int j = 5;

		maths.division(i, j);
		assertTrue("Exspected 4", 4 == maths.division(i, j));
	}

}
