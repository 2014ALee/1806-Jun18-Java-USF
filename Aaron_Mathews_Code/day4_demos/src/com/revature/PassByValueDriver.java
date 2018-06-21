package com.revature;

import com.revature.models.User;

public class PassByValueDriver {
	
	/*
	 * Passing primitives as parameters
	 * 
	 * In Java, when we pass a variable of a primitive data type into a method - a copy of the variable is made and
	 * manipulated within the method. This means that changes made within the method have no effect on the 
	 * original value.
	 * 
	 */
	public static void main(String[] args) {
		
		int i = 5;
		System.out.println(i);
		incrementValue(i);
		System.out.println(i);
		
		/*
		 * Passing objects as parameters
		 * 
		 * When we declare an object reference (String mystr) it is just that - a reference.
		 * The valye of the variable IS  a reference to the location of the object in memory.
		 * 
		 * This is why when we print an object that does not override the Object toString()
		 * method to the console using System.out.println() we get a reference location printed
		 * to the screen.
		 * 
		 * So, while it may look like Java passes objects by reference - IT IS NOT. It has the 
		 * exact same effect as it were, but that is merely because variable of non-primitive 
		 * types are references.
		 */
		
		Object obj = new Object();
		System.out.println(obj);
		
		User user = new User("Xi", "Jinping", "xi.jinping", "China", "xi.jinping@gmail.com");
		System.out.println(user);
		changeEmail(user);
		System.out.println(user);
	}
	
	private static void incrementValue(int i) {
		i++;
	}
	
	private static void changeEmail(User u) {
		u.setEmail("xi.jinping@gov.cn");
	}

}
