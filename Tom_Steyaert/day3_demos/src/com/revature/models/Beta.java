package com.revature.models;

public class Beta extends Alpha {

	//variable shadowing
	
	public int myPublicInt = 9;
	protected int protectedInt = 5;
	public int shadowGetter(){
		return super.myPublicInt;
	}
	
	
	//cannot reduce the visibility of inherited methods
	@Override
	protected double protectedDoubleGetter() {
		return super.myProtectedDouble;
	}
	
	
	//cannot override inherited final methods
//	@Override
	//public final int publicFinalIntGetter() {
		//return super.MY_PUBLIC_FINAL_INT;
	//}
	
//can't override it since it's not visible.	
//	private char privateCharGetter() {
//		return 'd';
//	}
	
	
	//not using @Override notation, so no issue
	private char privateCharGetter() {
		return '1';
	}
	
	public static int publicStaticIntGetter() {
		return myPublicStaticInt;
	}
	
	
}
