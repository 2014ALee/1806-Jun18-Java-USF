package com.floatvariable;

public class FloatVariableClass {
	
	public float myCheckingBalance;
	public float mySavingsBalance;
	
	public float getMyCheckingBalance() {
		return myCheckingBalance;
	}

	public void setMyCheckingBalance(float myCheckingBalance) {
		this.myCheckingBalance = myCheckingBalance;
	}

	public float getMySavingsBalance() {
		return mySavingsBalance;
	}

	public void setMySavingsBalance(float mySavingsBalance) {
		this.mySavingsBalance = mySavingsBalance;
	}

	public void getVariables() {
		
		System.out.println("My checking balance is: " +myCheckingBalance);
		System.out.println("My savings balance is: " +mySavingsBalance);
	}
}
