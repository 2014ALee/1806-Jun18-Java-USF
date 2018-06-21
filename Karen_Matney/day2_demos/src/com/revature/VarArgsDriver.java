package com.revature;

public class VarArgsDriver {
	public static void main(String[] args) {
		display(new int[] {1,2,3});
	}

	public static void display(int[] arr) { // the elipses must be the last one int... arr (0 or multiple, optional)
		for(int number : arr) {
			System.out.println(number);
		}
	}
}