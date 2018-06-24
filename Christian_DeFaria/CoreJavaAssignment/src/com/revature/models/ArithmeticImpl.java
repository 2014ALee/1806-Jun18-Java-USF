package com.revature.models;

public class ArithmeticImpl implements Arithmetic {
	@Override
	public int addition(int x, int y) {
		return x+y;
	}

	@Override
	public int subtraction(int x, int y) {
		return x-y;
	}

	@Override
	public int multiplication(int x, int y) {
		return x*y;
	}

	@Override
	public double division(int x, int y) {
		return (double) x/ (double) y;
	}
}
