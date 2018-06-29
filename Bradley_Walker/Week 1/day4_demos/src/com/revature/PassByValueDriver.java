package com.revature;

import com.revature.models.User;

public class PassByValueDriver {

	public static void main(String[] args) {
		/*
		 * Passing primitives as parameters
		 * 
		 * In Java, when we pass a variable of a primitive data type into a method - a copy of the
		 * variable is made and manipulated within the method. This means that changes made within
		 * the method have no effect on the original variable.
		 */
		int i = 5;
		System.out.println(i);
		incrementValue(i);
		System.out.println(i);
		
		// Passing objects as parameters
		// The value of an object variable IS a reference
		Object obj = new Object();
		System.out.println(obj);
		
		User user = new User("Xi", "Jinping", "xi.jinping", "china", "xi.jinping@gmail.com");
		System.out.println(user);
		changeEmail(user);
		System.out.println(user);
	}
	
	private static void incrementValue(int i) {
		i++;
	}

	private static void changeEmail(User user) {
		user.setEmail("xi.jinping@gov.cn");
	}
}
