package com.revature;

import com.revature.model.SubClass;
import com.revature.model.SuperClass;

public class SuperSubClassDriver {

	public static void main(String[] args) {
		
		SuperClass sub = new SubClass();
		
		if(sub.checkForUpper("i am yOu")) {
			System.out.println("String contains at least one Uppercase");
		}else {
			System.out.println("String has no Uppercase");
		}
		
		
		System.out.println(sub.convertToUpper("hello there"));
		
		
		System.out.println(sub.convertToInt("50"));
	}

}
