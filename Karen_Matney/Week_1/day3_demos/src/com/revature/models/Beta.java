package com.revature.models;

public class Beta extends Alpha {
	// Variable Shadowing
	public int myPublicInt = 9;

	public int shadowGetter() {
		return super.myPublicInt;
	}

	// Cannot reduce the visibility of inherited methods
	//	@Override // Tells the compiler that we're overwriting something inherited, may not be necessary, but good practice
	//	private double protectedDoubleGetter() {
	//		return super.myProtectedDouble;
	//	}

	@Override
	protected double protectedDoubleGetter() {
		return super.myProtectedDouble;
	}

	// MISSING

	// Final methods cannot be overridden
	//	@Override
	//	public final int publicFinalIntGetter() {
	//		return super.MY_PUBLIC_FINAL_INT;
	//	}

	// Private class members are not visible, and therefore cannot be overridden.
	//	@Override
	//	private char privateCharGetter() {
	//		return 'd';
	//	}

	// Without override b/c Beta doesn't know it exists in Alpha
	private char privateCharGetter() {
		return 'l';
	}

	// Cannot override because static members are not inherited.
	//	@Override
	//	public static int publicStaticIntGetter() {
	//		return myPublicStaticInt;
	//	}

	public static int publicStaticIntGetter() {
		return 123;
	}

	@Override
	String packageStringGetter() {
		return "different string";
	}
}