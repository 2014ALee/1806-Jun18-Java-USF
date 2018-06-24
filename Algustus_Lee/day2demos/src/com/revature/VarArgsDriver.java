package com.revature;

public class VarArgsDriver {
	public static void main(String[] args)
	{
		display(new int[] {1,2,3});
	}
	
	public static void display(int... arr) //the ... also means 1-dimensional array to be passed into a function.
											//you can only use it once per set of arguments. just use [] and it comes at the
											// end of the parameter list.
	{
		for(int number : arr)
		{
			System.out.println(number);
		}
		
	}
	public static String reverseString(String str)
	{
		String reversed[];
		int size = str.length();
		for(int i= str.length()-1; i > 0; i--)
		{
			str[i] = reversed[i]; 
		}
		
		return reversed;
	}
}
