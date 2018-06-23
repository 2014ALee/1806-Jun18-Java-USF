package com.revature;

public class ReverseString {
	public static void main(String[] args) {
		ReverseString rev = new ReverseString();
		System.out.println(rev.reverseStr("erif"));
	}
	public String reverseStr(String str) {
		for(char rev: str.toCharArray())
			str = rev + str;
		str = str.substring(0, (str.length()/2));
		return str;
	}
}
