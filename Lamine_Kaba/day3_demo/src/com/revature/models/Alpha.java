package com.revature.models;

public class Alpha {

	public int myPublicInt = 1;
	protected double myProtectedDouble = 5.0;
	private char myPrivatChar = 'a';
	String myPackageString = "hello";
	
	public static int myPublicStaticInt = 2;
	protected static double myProtectedStaticDouble = 10.0;
	private static char myPrivateStaticChar = 'b';
	static String myPackageStaticString = "bonjour";
	
	public final int  MY_PUBLIC_FINAL_INT = 100;
	protected final double MY_PROTECTED_FINAL_DOUBLE = 10.0;
	private final char MY_PRIVATE_FANAL_CHAR = 'Z';
	final String MY_PACKAGE_FINAL_STRING = "holo";
	
	private Shape myPrivateShape = new Shape();
	private Circle myPrivateCircle = new Circle();
	
	
	public Shape getMyPrivateShape() {
		return myPrivateShape;
	}

	public Circle getMyPrivateCircle() {
		return myPrivateCircle;
	}


	public int getMyPublicInt() {
		return myPublicInt;
	}
	
	public double getMyProtectedDouble() {
		return myProtectedDouble;
	}
	
	public char getMyPrivatChar() {
		return myPrivatChar;
	}
	
	public String getMyPackageString() {
		return myPackageString;
	}
	
	public static int getMyPublicStaticInt() {
		return myPublicStaticInt;
	}
	
	public static double getMyProtectedStaticDouble() {
		return myProtectedStaticDouble;
	}
	
	public static char getMyPrivateStaticChar() {
		return myPrivateStaticChar;
	}
	
	public static String getMyPackageStaticString() {
		return myPackageStaticString;
	}
	
	public int getMY_PUBLIC_FINAL_INT() {
		return MY_PUBLIC_FINAL_INT;
	}
	public double getMY_PROTECTED_FINAL_DOUBLE() {
		return MY_PROTECTED_FINAL_DOUBLE;
	}
	public char getMY_PRIVATE_FANAL_CHAR() {
		return MY_PRIVATE_FANAL_CHAR;
	}
	public String getMY_PACKAGE_FINAL_STRING() {
		return MY_PACKAGE_FINAL_STRING;
	}
	
	
	
	
}
