package com.revature.utility.question.fifteen;
/*
 * The implementing class asked of question 15.
 */
public class Implementor implements OurInterface {
	
	private static OurInterface imp = new Implementor();
	
	private Implementor() {}
	
	public static OurInterface getImplementor() {
		return imp;
	}

	@Override
	public double addition(double a, double b) {
		return a + b;
	}

	@Override
	public double subtraction(double a, double b) {
		return a - b;
	}

	@Override
	public double multiplication(double a, double b) {
		return a * b;
	}

	@Override
	public double division(double a, double b) {
		return a / b;
	}

}
