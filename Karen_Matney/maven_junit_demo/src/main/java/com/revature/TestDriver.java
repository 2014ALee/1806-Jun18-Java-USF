package com.revature;

public class TestDriver {
	public int multiply(int x, int y) {
		if(x > 999) throw new IllegalArgumentException(); // throw new ArithmeticException fails
		// No exception thrown, therefore fails, same for if more vague
		// More specific will work
		
		return x * y;
//		return x / y; // JUnit test fail
	}
}
