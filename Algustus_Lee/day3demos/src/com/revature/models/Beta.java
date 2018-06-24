package com.revature.models;

public class Beta extends Alpha{
	
	//Variable Shadowing
	public int myPublicInt = 9;
	
	public int shadowGetter() {
		return super.myPublicInt; //use 'super' to pull things from the superclass that the current class is extending.
	}
	
	@Override
	protected double protectedDoubleGetter() 
	{
		return super.myProtectedDouble;
	}
	//Override rules, you cannot reduce the visibility of inherited methods. It can be increased.
	
	//@Override
	//public final int publicFinalIntGetter()
	//{
	//	return super.MY_PUBLIC_FINAL_INT;
	//}
	//Override rules, you cannot Override a final.
	
	/*@Override
	private char privateCharGetter()
	{
		return 'd';
	}*/
	//Override rules, you can't override a private. Privates can't be accessed outside of their own class.
	
	private char privateCharGetter()
	{
		return 'l';
	}
	//This works due to shadowing. 
	
	//@Override
	//public static int publicStaticIntGetter()
	//{
	//	return myPublicStaticInt;
	//}
	//Override rules, you can't override a static.
	
	public static int publicStaticIntGetter()
	{
		return 123;
	}
	//This works due to shadowing.
	@Override
	String packageStringGetter()
	{
		return "different string";
	}
}
