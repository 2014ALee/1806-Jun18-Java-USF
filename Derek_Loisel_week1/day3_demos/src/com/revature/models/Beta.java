package com.revature.models;

public class Beta extends Alpha {

	//variable shadowing
	public int myPublicInt = 9;
	
	public int shadowGetter() {
		return super.myPublicInt; //need super. here because this vars shadowed
	}
	
	//cant decrease the visibility of an inherited method, ex. cant change this protected method to private.  But you can increase it to public.
	@Override
	protected double protectedDoubleGetter() {
		return myProtectedDouble; //dont need super. here
	}
	
	/*
	//cant override final methods
	@Override
	public final int publicFinalIntGetter() {
		return super.MY_PUBLIC_FINAL_INT;
	}
	*/
	
	/*
	//cant override a private method because it cant be inherited, its private
	@oOverride
	private char privateCharGetter() {
		return 'd';
	}
	*/
	
	/*
	//static methods are not inherited, and therefore cannot be overriden
	@Override
	public static int publicStaticIntGetter() {
		return myPublicStaticInt;
	}
	*/
	
	public static int publicStaticIntGetter() {
		return myPublicStaticInt;
	}
	
	
	
}
