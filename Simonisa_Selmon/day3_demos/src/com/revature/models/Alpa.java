package com.revature.models;

public class Alpa {

	public int myPublicInt=1;
	protected double myProtectedDouble=5.0;
	private char myPrivateChar= 'a';
	String myPackageString= "hello";
	
	public static int myPublicStaticInt= 2;
	protected static double myProtectedStaticDouble= 10.0;
	private static char myPrivateStaticChar= 'b';
	static String myPackageStaticString= "bonjour";
	
	public final int MY_PUBLIC_FINAL_INT= 100;
	protected final double MY_PROTECTED_FINAL_DOUBLE= 2.168;
	private final char MY_PROCTECTED_FINAL_CHAR= 'z';
	final String MY_PACKAGE_FINAL_STRING= "hola";
	
	public int publicIntGetter() {
		return this.myPublicInt;
		
	}
	
	protected double protectedDoubleGetter();{
	return this. myProtectedDouble;
}
	
}

	