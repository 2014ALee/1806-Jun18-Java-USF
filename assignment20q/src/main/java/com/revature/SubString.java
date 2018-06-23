package com.revature;

public class SubString {
	
	public static void main(String[] args) {
		SubString sub = new SubString();
		System.out.println(sub.subStringBuilder("Smith", 3));
	}
	
	
	public String subStringBuilder(String str, int idx) {
		String newStr = "";
		for(int i = 0; i < idx; i++)
			newStr = newStr + str.toCharArray()[i];
		return newStr;
	}
}
