package com.revature;

public class MinUsingTernary {
	
	public static void main(String[] args) {
		int i = 10;
		int x = 9;
		
		if (Ternary(i, x)) {
			
			if (i == x) {
				System.out.println(i + " is equal to " + x);
			} else {
				System.out.println(i + " is smaller than " + x);
			}
			
			
		} else {
			System.out.println(x + " is smaller than " + i);
		}
	}
	
	public static boolean Ternary(int i, int x) {
		
		return (i < x) ? true : false;
	}

}
