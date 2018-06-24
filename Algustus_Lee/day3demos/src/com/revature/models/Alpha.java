package com.revature.models;

import com.revature.util.IOException;

public class Alpha {
	public int myPublicInt = 1;
	protected double  myProtectedDouble= 5d;
	private char myPrivateChar = 'a';
	String myPackageString = "hello"; //this package only
	
	public static int myPublicStaticInt = 2;
	protected static double myProtectedStaticDouble = 10d;
	private static char myPrivateStaticChar = 'b';
	static String myPackageStaticString = "bonjour";
	
	public final int MY_PUBLIC_FINAL_INT =100;
	protected final double MY_PROTECTED_FINAL_DOUBLE = 2.168;
	private final char MY_PRIVATE_FINAL_CHAR = 'z';
	final String MY_PACKAGE_FINAL_STRING = "hola";
	
	private Shape myPrivateShape;
	private Circle myPrivateCircle;
	
	public int publicIntGetter()
	{
		return this.myPublicInt;
	}
	protected double protectedDoubleGetter()
	{
		return this.myProtectedDouble;
	}
	private char privateCharGetter()
	{
		return this.myPrivateChar;
	}
	String packageStringGetter()
	{
		return this.myPackageString;
	}
	public static int publicStaticIntGetter()
	{
		return myPublicStaticInt;
	}
	protected static double protectedStaticDoubleGetter()
	{
		return myProtectedStaticDouble;
	}
	private static char privateStaticCharGetter()
	{
		return myPrivateStaticChar;
	}
	static String staticStringGetter()
	{
		return myPackageStaticString;
	}
	public final int publicFinalIntGetter()
	{
		return MY_PUBLIC_FINAL_INT;
	}
	protected final double protectedFinalDoubleGetter()
	{
		return MY_PROTECTED_FINAL_DOUBLE;
	}
	private final char privateFinalCharGetter()
	{
		return MY_PRIVATE_FINAL_CHAR;
	}
	final String finalStringGetter()
	{
		return MY_PACKAGE_FINAL_STRING;
	}
	
	public Shape getShape() {
		return this.myPrivateShape;
	}
	public Circle getCircle()
	{
		return this.myPrivateCircle;
	}
	public String publicStringThrowsIOException() throws IOException{
		return "how can we override this method by changing the exception thrown?";
	}
	
	protected String protectedStringThrowsException() throws Exception
	{
		return "Stuff";
	}
}
