package com.revature.model;

public class Factorial {
	
	public int Factor(int i) {
		
		if((i == 1) || (i == 0)) {
			
			return 1;
		} else if(i == 2) {
			
			return 2;
		} else {
			
			return Factor(i-1) * i;
		}
	}

}
