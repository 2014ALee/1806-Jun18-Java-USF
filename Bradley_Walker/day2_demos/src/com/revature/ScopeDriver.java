package com.revature;

public class ScopeDriver {

	public static int x = 0;
	public static String myStr = "Hello";
	public static int myOuterInt = 9;
	
	public static void main(String[] args) {
		System.out.println(x);
		System.out.println(changeX(x));
		System.out.println(x);
		
		System.out.println(myStr);
		System.out.println(changeString(myStr));
		myStr = changeString(myStr);
		System.out.println(myStr);
	}

	// Java is PASS-BY-VALUE! Only the value of x is passed, not the variable reference
	public static int changeX(int x) {
		return ++x;
	}
	
	public static String changeString(String value) {
		return value + ", world!";
	}
	
	// This doesn't work
//	public int getMyInnerInt() {
//		return myInnerInt;
//	}
	
	class SomeClass {
		private int myInnerInt = 6;
		
		public int getMyOuterInt() {
			return myOuterInt;
		}
	}
}
