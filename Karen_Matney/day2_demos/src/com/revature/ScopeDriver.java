package com.revature;

public class ScopeDriver {
	public static int x = 0;
	public static String myStr = "hello";
	public static int myOuterInt = 9;

	public static void main(String[] args) {
		System.out.println(x);
		System.out.println(changeX(x));
		System.out.println(x);
		System.out.println(myStr);
		System.out.println(changeString(myStr));
		myStr = changeString(myStr); // This change the string
		System.out.println(myStr);
	}

	// Java is PASS-BY-VALUE! Only the value of 'x' is passed in, not the reference to the variable itself!
	public static int changeX(int x) {
		return ++x;
	}

	public static String changeString(String value) {
		return value + ", world!";
	}

	// Can't really see, unless...
	//	public static int getMyInnerInt() {
	//		return myInnerInt; // can by making variable and class static and referencing it SomeClass.myInnerInt
	//	}

	class SomeClass{
		private int myInnerInt = 6;

		// Can see variable of outer class
		public int getMyOuterInt() {
			return myOuterInt;
		}
	}
}