package com.revature.models;

public class Beta extends Alpha {
	
	//Shadowing. myPublicInt exists in Alpha
	public int myPublicInt = 9;
	
	public int shadowGetter() {
		return super.myPublicInt;	
		
	}
	
	
	//Visibility of access modifiers can be increased but not decreased
	@Override
	protected double protectedDoubleGetter() {
		return super.myProtectedDouble;
	}
	
//	public double protectedDoubleGetter() {
//		return super.myProtectedDouble;
//	}
	
	// Cannot override inherited final methods 
//	@Override
//	public final int myPublicFinalIntGetter() {
//		return super.MY_PUBLIC_FINAL_INT;
//	}
	
	//Cannot override private fields or methods. They are not visible
//	@Override
//	private char privateCharGetter() {
//		return 'l';
//	}

	//Static methods are not inherited, and therefore cannot be overridden
//	@Override
//	public static int publicStaticIntGetter() {
//		return myPublicStaticInt;
//	}
	
	public static int publicStaticIntGetter() {
		return myPublicStaticInt;
	}
}
