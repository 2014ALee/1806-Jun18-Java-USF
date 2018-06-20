package com.revature;

public class ScopeDriver {
	public static int x = 0;
	public static String myStr = "Hello";
	public static int myOuterInt = 9;
	
	public static void main(String[] args) {
		System.out.println(x);
		System.out.println(change(x));
		System.out.println(x);
		
		System.out.println(myStr);
		System.out.println(changeString(myStr));
		myStr = changeString(myStr);
		System.out.println(myStr);
	}
	
	//Java is pass by value! only the value of x is passed to the function, not a reference to 'x'
	public static int change(int value) {
		x = ++value;
		return x;
	}
	
	public static String changeString(String value) {
		return value + ", world!";
	}
	
	public static int getMyInnerInt() {
		//myInnerInt out of scope
		//return myInnerInt;
		return 0;
	}
	
	static class SomeClass {
		public static int myInnerInt = 6;
		
		public int getMyOuterInt() {
			return myOuterInt;
		}
	}
}
