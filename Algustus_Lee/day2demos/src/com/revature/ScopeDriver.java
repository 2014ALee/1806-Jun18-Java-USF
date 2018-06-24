package com.revature;

public class ScopeDriver {
	public static int x = 0;
	public static String myStr = "hello";
	public static int myOuterInt = 9;
	
	public static void main(String[] args) 
	{
		System.out.println(x);
		System.out.println(changeX(x));
		System.out.println(x);
		System.out.println(myStr);
		System.out.println(changeString(myStr));
		
	}
	
	//Java is pass-by-value! Only the value of x is passed in, not the reference to the variable itself!
	public static int changeX(int x)
	{
		return x++;
	}
	public static String changeString(String value)
	{
		return value + " , world!";
	}
	
	public static int getMyInnerInt()
	{
		//myInnerInt is not visible here unless you edit myInnerInt
		return SomeClass.myInnerInt;
	}
	
	class SomeClass{
		public static final int myInnerInt = 6;
		private int getMyOuterInt()
		{
			return myOuterInt;
		}
	}
}
