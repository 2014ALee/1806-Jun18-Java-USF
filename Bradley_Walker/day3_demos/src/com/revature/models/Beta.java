package com.revature.models;

import java.io.IOException;

public class Beta extends Alpha {
	
	// Variable Shadowing
	public int myPublicInt = 9;
	
	public int shadowGetter() {
		return super.myPublicInt;
	}
	
	// We can increase but not decrease the visibility of inherited methods
//	@Override
//	private double protectedDoubleGetter() {
//		return super.myProtectedDouble;
//	}
	
	@Override
	public double protectedDoubleGetter() {
		return super.myProtectedDouble;
	}
	
	// Cannot override inherited final methods
//	@Override
//	public final int publicFinalIntGetter() {
//		return super.MY_PUBLIC_FINAL_INT;
//	}
	
	// Private class members aren't visible and can't be overridden
//	@Override
//	private char privateCharGetter() {
//		return super.myPrivateChar;
//	}
	
	// Static methods aren't inherited and can't be overridden
//	@Override
//	public static int publicStaticIntGetter() {
//		return myPublicStaticInt;
//	}

	// Static fields are inherited
	public static int publicStaticIntGetter() {
		return myPublicStaticInt;
	}
}
