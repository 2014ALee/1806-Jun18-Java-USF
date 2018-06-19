package com.revature;

public class VarArgsDriver {
	
	//variable arguments - lets you create a function with as many arguments as you want and store them in an array
	
	public static void main(String... args) {
		display("hi", new int[] {5, 6, 7});
	}

	public static void display(String strValue, int... arr) {
		
			System.out.println(strValue);
			
			for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
}
