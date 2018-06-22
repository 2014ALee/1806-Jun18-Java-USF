package com.revature;

import com.revature.models.User;

public class PassByValueDriver {

	public static void main(String[] args) {
		
		int i = 5;
		System.out.println(i);
		
		incrementValue(i);
		//passing objects as paramters
		
		//when we declare an object reference (String mystr) it is just a reference
		//the value of the object is a reference to it's location
		
		User user = new User("XI", "Jinping", "xi.jinping", "china", "xi.jinpeng@gmail.com");
		System.out.println(user);
		changeEmail(user);
		System.out.println(user);
	}
	
	private static void incrementValue(int i) {
		i++;
	}
	
	private static void changeEmail(User u) {
		u.setEmail("xi.china");
	}
	
}
