package com.revature;

public class InterfaceMathMethos implements InfterfaceMathMet{

	@Override
	public double add(double i, double j) {
		
		return i +j;
	}

	@Override
	public double subtract(double i, double j) {
		
		return i - j;
	}

	@Override
	public double mytiply(double i, double j) {
		
		return i*j;
	}

	@Override
	public double divide(double i, double j) {
		
		return i/j;
	}

}
