package com.revature;

public class SubString {
	
	public static void main(String[] args) {
		System.out.println(subStringBuilder("Smith", 3));
	}
	
	
	public static String subStringBuilder(String str, int idx) {
		String newStr = "";
		for(int i = 0; i < idx; i++)
			newStr = newStr + str.toCharArray()[i];
		return newStr;
	}
}
