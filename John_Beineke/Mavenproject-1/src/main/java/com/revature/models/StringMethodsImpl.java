package com.revature.models;

import java.util.Scanner;

public class StringMethodsImpl extends StringMethods {


	@Override
	public boolean checkUpperCase(String str) {
		boolean cond = false;
		char[] charArray = str.toCharArray();
		while(!cond) {
			for(int i = 0; i < charArray.length; i++) {
				if(charArray[i] >= 'A' && charArray[i] <= 'Z') {
					cond = true;
					return cond;
				}
			}
			cond = false;
			return cond;
		}	
		return true;
	}

	@Override
	public String lowerCaseToUpperCase(String str) {
		String strNew = str.toUpperCase();
		return strNew;

	}

	@Override
	public int stringToInt(String str) {
			int result;
			result = Integer.parseInt(str);
			return (result + 10);
	}

}
