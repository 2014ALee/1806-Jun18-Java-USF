package com.revature.models;

public class Beta extends Alpha {
	
	// Variable Shadowing
	public int myPublicInt = 9;
	
	public int shadowGetter() {
		return super.myPublicInt;
	}
	
	// Cannot reduce the visibility of inherited methods
	@Override
	public double myProtectedDoubleGetter() {
		return super.myProtectedDouble;
	}
	
	// Cannot override inherited final methods.
	//@Override
	//public final int publicFinalIntGetter() {
	//	return super.MY_PUBLIC_FINAL_INT;
	//}
	
	// Private class members are not visible, and therefore cannot be overridden.
	
	//THis is valid because we are not usuing the @override
	private char privateCharGetter() {
		return 'd';
	}


	public static int publicStaticIntGetter() {
		return 5;
	}
	
	

}
