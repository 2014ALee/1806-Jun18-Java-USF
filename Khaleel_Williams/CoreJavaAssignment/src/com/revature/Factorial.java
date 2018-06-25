package com.revature;

public class Factorial {
	
	public static void main(String[] args) {
		System.out.println("The factor of 8 is = " + Factor(8));
	}
	public static int Factor(int i) {
		
		if((i == 1) || (i == 0)) {
			
			return 1;
		} else if(i == 2) {
			
			return 2;
		} else {
			
			return Factor(i-1) * i;
		}
	}

}
