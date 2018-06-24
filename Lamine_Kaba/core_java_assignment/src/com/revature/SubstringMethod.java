package com.revature;

public class SubstringMethod {

	public void substringMethod(String str, int idx) {
		String mystr = "";
		
		for(int i = 0 ; i < idx; i++) {
			mystr = mystr + str.toCharArray()[i];
		}
		
		System.out.println(mystr);
	}
}
