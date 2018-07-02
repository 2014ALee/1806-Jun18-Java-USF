package com.revature;

public class VarArgsDriver {
	public static void main(String[] args) {
		/*String str = "Hello";
		String str2 = "";
		for(int i = str.length()-1; i>=0; i--) {
			str2+=str.substring(i, i+1);
			str2+=str.charAt(i);
		}
		str=str2;
		System.out.println(str);*/
		
		display("Kyle", new int[] {1,2,3});
		display("John");
	}
	
	public static void display(String str, int... arr) {
		for(int number : arr) {
			System.out.println(str);
			System.out.println(number);
		}
	}
	
}
