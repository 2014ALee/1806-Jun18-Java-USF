package com.revature;
// determine if a number is even without using a modulus operator
public class Question6 {

	public static void main(String[] args) {
		System.out.println(isItEven(-12));
	}
	
	private static boolean isItEven(int N) {
		// explain this silliness
		char[] charArrayN = ("" + N).toCharArray();
		System.out.println(charArrayN);
		switch(charArrayN[charArrayN.length - 1]) {
		case '0': case '2': case '4': case '6': case '8':
			return true;
		default:
			return false;
		}	
	}
}
