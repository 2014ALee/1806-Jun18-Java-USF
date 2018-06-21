package com.revature;

import com.revature.models.User;

public class PassByValueDriver {
	
	// In java, when we pas a variable of a primitiv data type into a method - a copy of the variable 
	//is made and manipulated within the method. this means that chages made within the method have 
	//no dffect on the original variable.
	
	public static void main(String[] args) {
		
		int i = 5;
		System.out.println(i);
		incrementValue(i);
		System.out.println(i);
		
		
		Object obj = new Object();
		System.out.println(obj);
		
		User user = new User();
	}
	
	private static void incrementValue(int i) {
		i++;
	}
	
	private static void changeEmail(User u) {
		u.setEmail("");
	}
	
}
