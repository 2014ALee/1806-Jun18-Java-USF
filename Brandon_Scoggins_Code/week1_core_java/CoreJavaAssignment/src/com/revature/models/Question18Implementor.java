package com.revature.models;
// class to implement inherited methods from a super class for question 18
public class Question18Implementor extends Question18Super {

	@Override
	public boolean hasUpperCase(String str) {
		return (str.compareTo(str.toLowerCase()) == 0) ? false : true;
	}

	@Override
	public String toUpperCase(String str) {
		return str.toUpperCase();
	}

	@Override
	public void toIntAndAdd(String str) {
		try {
		System.out.println(Integer.valueOf(str) + 10);	
		}catch(NumberFormatException nfe) {
			System.out.println("String could not be parsed as an integer.");
			nfe.printStackTrace();
		}
	}

}
