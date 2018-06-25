package com.revature.models;

public class Beta extends Alpha {

	// Variable Shadowing
	public int myPublicInt = 9;
	
	public int shadowGetter() {
		return super.myPublicInt;
	}
	
	// cannot reduce visibility of inherited methods  (but can increase visibility)
//	@Override
//	private double protectedDoubleGetter() {
//		return super.myProtectedDouble;
//	}
	
	// cannot override inherited final methods
//	@Override
//	public final int publicFinalIntGetter() {
//		return super.MY_PUBLIC_FINAL_INT;
//	}
	
	// private class members are not inherited so they cannot be overridden
//	@Override
//	private char privateCharGetter() {
//		return 'd';
//	}
	
	// static class members are not inherited and therefore cannot be overridden
//	@Override
//	public static int publicStaticIntGetter() {
//		return myPublicStaticInt;
//	}
	
	
	
	
	
	
	
}
