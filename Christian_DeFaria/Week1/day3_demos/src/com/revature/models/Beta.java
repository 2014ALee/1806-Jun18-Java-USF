package com.revature.models;

public class Beta extends Alpha{
	
	//Variable Shadowing
	public int myPublicInt = 9;
	
	public int shadowGetter() {
		return super.myPublicInt;
	}
	
	//Cannot reduce the visibility of inherited methods
//	@Override
//	private double protectedDoubleGetter() {
//		return super.myProtectedDouble;
//	}
	
	//Cannot override inherited final methods
//	@Override
//	public final int publicFinalIntGetter() {
//		return super.MY_PUBLIC_FINAL_INT;
//	}
	
	//Cannot override private class methods/members because they're not visible to subclasses
//	@Override
//	private char privateCharGetter() {
//		return 'l';
//	}

	//This is valid because it's not overriding
	private char privateCharGetter() {
		return 'l';
	}
	
	//Static methods are not inherited and therefore cannot be overridden
//	@Override
//	public static int publicStaticIntGetter() {
//		return myPublicStaticInt;
//	}
	
	public static int publicStaticIntGetter() {
		return 123;
	}
}
