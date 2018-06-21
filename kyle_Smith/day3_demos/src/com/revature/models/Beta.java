package com.revature.models;

public class Beta extends Alpha{

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
	
	//Cannot override inherited final methods
//	@Override
//	public final int publicFinalIntGetter() {
//		return super.MY_PUBLIC_FINAL_INT;
//	}
//	
//	Private class members are not visible, and therefore cannot be overridden
//	@Override
//	private char privateCharGetter() {
//		return 'd';
//	}
	
//	this is valid becuase we are not using the @Override annotation
	private char privateCharGetter() {
		return '1';
	}
	
//	Static methods are not inherited, and therefore cannot be overridden
//	@Override
//	public static int publicStaticIntGetter() {
//		return myPublicStaticInt;
//	}
	
	public static int publicStaticIntGetter() {
		return myPublicStaticInt;
	}
}
