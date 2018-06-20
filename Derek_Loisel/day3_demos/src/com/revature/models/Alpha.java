package com.revature.models;

import java.io.IOException;

public class Alpha {

	public int myPublicInt = 1;
	protected double myProtectedDouble = 5.0;
	private char myPrivateChar = 'a';
	String myPackageString = "hello";
	
	public static int myPublicStaticInt = 2;
	protected static double myProtectedStaticDouble = 10.0;
	private static char myPrivateStaticChar = 'b';
	static String myPackageStaticString = "bonjour";
	
	public final int MY_PUBLIC_FINAL_INT = 100;
	protected final double MY_PROTECTED_FINAL_DOUBLE = 2.168;
	private final char MY_PRIVATE_FINAL_CHAR = 'z';
	final String MY_PACKAGE_FINAL_STRING = 	"hola";
	
	
	private Shape myPrivateShape = new Shape();
	private Circle myprivateCircle = new Circle();
	
	
	public int publicIntGetter() {
		return this.myPublicInt;
	}
	
	protected double protectedDoubleGetter() {
		return this.myProtectedDouble;
	}
	
	private char privateCharGetter() {
		return this.myPrivateChar;
	}
	
	String packageStringGetter() {
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
	
	public final int publicFinalIntGetter() {
		return this.MY_PUBLIC_FINAL_INT;
	}
	protected final double protectedFinalDoubleGetter() {
		return this.MY_PROTECTED_FINAL_DOUBLE;
	}
	
	private final char privateFinalCharGetter() {
		return this.MY_PRIVATE_FINAL_CHAR;
	}
	final String packageFinalStringGetter() {
		return this.MY_PACKAGE_FINAL_STRING;
	}
	
	
	
	public Shape getShape() {
		return this.myPrivateShape;
	}
	
	public Circle getCircle() {
		return this.myprivateCircle;
	}
	
	
	
	public String publicStringThrowsIOException() throws IOException {
		return "how can we override this method by changing the exception thrown?";
	}
	
	protected String protectedStringThrowsException() throws Exception {
		return "Stuff";
	}
		
		
}
