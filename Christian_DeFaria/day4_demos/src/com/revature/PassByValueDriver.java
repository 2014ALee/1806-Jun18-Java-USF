package com.revature;

import com.revature.models.User;

public class PassByValueDriver {
	/*
	 * Passing primitives as parameters
	 * 
	 * Pass by values
	 */
	public static void main(String[] args) {
		int i = 5;
		System.out.println(i);
		incrementValue(i);
		System.out.println(i);
		
		/*
		 * Passing objects as parameters
		 * 
		 * When we declare an object reference (String myStr) it is just that - a reference.
		 * The value of the variable IS a reference to the location of the object in memory.
		 */
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
	
	private static void changeEmail(User u) {
		u.setEmail("xi.Jinping@gov.cn");
	}
}
