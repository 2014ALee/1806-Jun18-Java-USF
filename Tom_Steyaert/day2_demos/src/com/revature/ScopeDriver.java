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
	System.out.println(myStr);
	
	}
	
	//java is pass by value
	public static int changeX(int value) {
		x = ++value;
		return ++x;		
	}
	
	public static String changeString(String value) {
		return value + ", world!";
	}
	
	public static int getMyInnerInt() {
		return SomeClass.myInnerInt;
	}
	
	
	static class SomeClass{
		public static int myInnerInt = 6;
		
		
		
		public int getMyOutterInt() {
			return myOuterInt;
		}
		
		
	}
	
	
	
}
