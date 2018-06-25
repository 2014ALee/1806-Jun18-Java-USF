package com.revature;
public class ComputeSubstring {

	public static void main(String[] args) {
		
		String str = "Hi I'm a string!";
		int idx = 8;
		System.out.println(substring(str, idx));
	}

	public static String substring(String str, int n) {
		String substring = "";
		for (int i = 0; i < n; i++) {
			substring += str.charAt(i);
		}
		return substring;
	}
	
}
