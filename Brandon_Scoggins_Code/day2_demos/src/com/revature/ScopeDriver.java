package com.revature;

public class ScopeDriver {

	public static int x = 0;
	public static String myStr = "Hello";
	public static int myOuterInt = 9;
	
	public static void main (String[] args) {
		System.out.println(x);
		System.out.println(changeX(x));
		System.out.println(x);
		
		System.out.println(myStr);
		System.out.println(changeString(myStr));
		myStr = changeString(myStr);
		System.out.println(myStr);
	}
	
	// JAVA is pass-by-value! Only the value of a variable is passed, not the reference/variable itself.
	public static int changeX(int x) {
		return x++;
	}
	
	public static String changeString(String value) {
		return value + " world!";
	}
	
//	public static int getMyInnerInt() {
		// 'myInnerInt' is not in visible scope
//		return myInnerInt;
//	}
	static class SomeClass{
		private int myInnerInt = 6;
		
		public int getMyOuterInt ()
		{
			return myOuterInt;
		}	}
}
