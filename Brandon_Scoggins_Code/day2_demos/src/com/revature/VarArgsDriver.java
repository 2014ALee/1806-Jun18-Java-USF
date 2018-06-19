package com.revature;

public class VarArgsDriver {

	public static void main(String[] args) {
		int[][] my2dArray = {{1, 2}, {3, 4}};
//		display("John", new int[] {1, 2, 3});
		display("Brandon");
		display("Katie", my2dArray);
	}
	// variable arguments are optional and must come at the end or parameters
	public static void display(String strValue, int[]... arr) {
		for(int[] number : arr)
			System.out.println(number);
		System.out.println(strValue);
	}
}
