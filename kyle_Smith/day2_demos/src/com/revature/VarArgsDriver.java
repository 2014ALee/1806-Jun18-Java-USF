package com.revature;

public class VarArgsDriver {

	public static void main(String[] args) {
		System.out.println(reverse("help"));
	}
	
	public static String reverse(String str) {
		char[] chars = str.toCharArray();
		String result = "";
		for(int i = chars.length-1; i > -1; i--) {
			result = result + chars[i];
		}
		System.out.println(result);
		return result;
	}
}
