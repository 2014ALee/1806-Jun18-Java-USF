package com.revature.models;

public class Beta extends Alpha {

	// Variable Shadowing
	public int myPublicInt = 9;
	
	public int shadowGetter() {
		return super.myPublicInt;
	}
	
	// Cannot reduce the visibility of inherited methods
//	@Override
//	private double protectedDoubleGetter() {
//		return super.myProtectedDouble;
//	}
	
	// The visibility can be increased, however!
	@Override
	public double protectedDoubleGetter() {
		return myProtectedDouble;
	}
	
	// Cannot override inherited final methods
//	@Override
//	public final int publicFinalIntGetter() {
//		return super.MY_PUBLIC_FINAL_INT;
//	}

	// Private class members are not visible, and therefore cannot be overridden
//	@Override
//	private char privateCharGetter() {
//		return 'd';
//	}
	
	// This is valid because we are not using the @Override annotation
	private char privateCharGetter() {
		return 'l';
	}
	
	// Static methods are not inherited, and therefore cannot be overridden
//	@Override
//	public static int publicStaticIntGetter() {
//		return myPublicStaticInt;
//	}
	
	public static int publicStaticIntGetter() {
		return 123;
	}
	
	@Override
	String packageStringGetter() {
		return "different string!";
	}
	
	
}
