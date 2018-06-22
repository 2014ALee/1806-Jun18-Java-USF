package com.revature.models;

public class Alpha {

	public int myPublicInt = 1;
	protected double myProtectedDouble = 5.0;
	private char myPrivateChar = 'a';
	String myPackageString = "hello";
	
	public static int myPublicStaticInt = 2;
	protected static double myProtectedStaticDouble = 10.0;
	private static char myPrivateStaticChar = 'b';
	static String myPackageStaticString = "hola";
	
	public final int MY_PUBLIC_FINAL_INT = 100;
	protected final double MY_PROTECTED_FINAL_DOUBLE = 1024.0;
	private final char MY_PRIVATE_FINAL_CHAR = 'z';
	final String MY_PACKAGE_FINAL_STRING = "konichiwa";
	
	public int myPublicIntGetter() {
		return this.myPublicInt;
	}
	protected double myProtectedDoubleGetter() {
		return this.myProtectedDouble;
	}
	private char myPrivateCharGetter() {
		return this.myPrivateChar;
	}
	public String myPackageStringGetter() {
		return this.myPackageString;
	}
	public static int publicStaticIntGetter() {
		return myPublicStaticInt;
	}
	protected static double protectedStaticDoubleGetter() {
		return myProtectedStaticDouble;
	}
	private static char privateStaticCharGetter() {
		return myPrivateStaticChar;
	}
	static String packageStaticStringGetter() {
		return myPackageStaticString;
	}
	final public int publicFinalIntGetter() {
		return this.MY_PUBLIC_FINAL_INT;
	}
	final protected double protectedFinalDoubleGetter() {
		return this.MY_PROTECTED_FINAL_DOUBLE;
	}
	final private char privateFinalCharGetter() {
		return this.MY_PRIVATE_FINAL_CHAR;
	}
	final String packageFinalStringGetter() {
		return this.MY_PACKAGE_FINAL_STRING;
	}
	
	public Shape getShape() {
		return new Shape();
	}
	
}
