package com.revature;

public class ScopeDriver {
	
	public static int x = 0;
	public static String mystr = "Hello";
	public static int myOuterInt = 9;

	public static void main(String[] args) {

		System.out.println(x);
		System.out.println(changeX(x));
		System.out.println(x);
		
		System.out.println(mystr); // prints hello
		System.out.println(changeString(mystr));
		System.out.println(mystr);
	}

	// Java is PASS-BY-VALUE
	public static int changeX(int value) {
		x = ++value;
		return x;
	}
	
	public static String changeString(String value) {
		return value + ", World!";
	}
	
	public static int getMyInnerInt() {
		// 'myInnerInt' is not visible here!
		//	return myInnerInt;
		return 0;
	}
	
	class SomeClass {
		private int myInnerInt = 6;
		
		public int getMyOuterInt() {
			return myOuterInt;
		}
		
	}
	
	
}
