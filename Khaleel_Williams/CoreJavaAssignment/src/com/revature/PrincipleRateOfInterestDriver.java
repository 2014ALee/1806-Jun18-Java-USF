package com.revature;

public class PrincipleRateOfInterestDriver {
	
	public static void main(String[] args) {
		
		float principal = 1000;
		float rate = (float) 0.10;
		float years = 1;
		System.out.println(principcalRateOfInterest(principal, rate, years));
	}

	private static float principcalRateOfInterest(float principal, float rate, float years) {
		// TODO Auto-generated method stub
		return (principal * rate * years);
	}

}
