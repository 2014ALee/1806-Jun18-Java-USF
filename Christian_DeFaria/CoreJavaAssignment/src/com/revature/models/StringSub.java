package com.revature.models;

public class StringSub  extends StringSuper {

	@Override
	public boolean checkUpperCase(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toUpper(String str) {
		return str.toUpperCase();
	}

	@Override
	public int toInt(String str) {
		int value = Integer.parseInt(str);
		value+=10;
		System.out.println("Str + 10 = " + value);
		return value;
		
	}

}
