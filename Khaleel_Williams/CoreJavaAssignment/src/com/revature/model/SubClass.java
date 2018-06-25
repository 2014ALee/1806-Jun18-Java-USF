package com.revature.model;

public class SubClass extends SuperClass {

	@Override
	public
	boolean checkForUpper(String string) {
		// TODO Auto-generated method stub
		
		char charArray[] = string.toCharArray();
		
		for(char c : charArray) {
			if(Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public
	String convertToUpper(String string) {
		// TODO Auto-generated method stub
		
		return string.toUpperCase();
	}

	@Override
	public int convertToInt(String string) {
		// TODO Auto-generated method stub
		int integer = Integer.parseInt(string);
		return integer + 10;
	}
	
	

}
