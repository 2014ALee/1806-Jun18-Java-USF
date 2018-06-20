package com.revature;

public class varArgsDriver {

	public static void main(String[] args) {

		display(new int[] {1, 2, 3});
		String str = "Hello";
		
		for (int i = str.length()-1; i>0; i--) {
			System.out.println(str.charAt(i));
		}
	}
	
	public static void display(String strValue, int... arr) {
		for(int number : arr) {
			System.out.println(strValue);
			System.out.println(number);
		}
	}

}
