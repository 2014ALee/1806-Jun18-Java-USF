package com.revature;

public class VarArgsDriver {
	
	public static void main(String[] args) {
		System.out.println(reverseString(str));
		//display(new int[] {1, 2, 3});
	}
	
//	public static void display(int...arr) {
//		for (int number : arr) {
//			System.out.println(number);
//		}
//	}
	
	static String str = "Hello, World!";
	
	public static String reverseString(String string) {
		int length = string.length();
		String s = "";
		for (int i = length - 1; i >= 0; i--) {
			s = s + string.charAt(i);
		}
		return s;
	}
	
	

}
