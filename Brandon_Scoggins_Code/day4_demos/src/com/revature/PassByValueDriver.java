package com.revature;

import com.revature.models.User;

public class PassByValueDriver {

	static char[] testChar = "test array".toCharArray();
	static String testString = "test string";
	
	public static void main(String[] args) {
		
		/*
		 * Passing primitives as parameters
		 * 
		 * In java, when we pass a variable of a primitive data type into a method - a copy of the
		 * variable is made and manipulate within the method. This means that changes made within
		 * the method have no effect on the original variable.
		 */
		
		int i = 5;
		System.out.println(i); // prints 5
		incrementValue(i);
		System.out.println(i); // prints 5
		
		/*
		 * Passing objects as parameters
		 * 
		 * When we declare an object reference (String myStr;) it is just that - a reference.
		 * The value of the variable IS a reference to the location of the object in memory.
		 * 
		 * This is why when we print an object that does not override the Object toString()
		 * method to the console using System.out.prinltn() we get a reference location printed to the screen.
		 * 
		 * So, while it may look like Java passes objects by reference - IT IS NOT. It has the 
		 * exact same effect as if it were, but that is merely because variables of non-primitive 
		 * types are references.
		 */
		
		Object obj = new Object();
		System.out.println(obj);
		
		User user = new User("Xi", "Jinping", "xi.jinping", "china", "xi.jinping@gmail.com");
		System.out.println(user);
		changeEmail(user);
		System.out.println(user);
		
		
		System.out.println("begin test");
		
//		char[] testChar = "test array".toCharArray();
//		String testString = "test string";
		
		System.out.println(testChar);
		changeArray();
		System.out.println(testChar);

		System.out.println(testString);
		changeString();
		System.out.println(testString);
		
	}
	
	private static void incrementValue(int i) {
		i++;
	}
	
	private static void changeEmail(User u) {
		u.setEmail("blank");
	}
	
	private static void changeArray() {
		testChar = "new array".toCharArray();
	}
	
	private static void changeString() {
		testString = "new string";
	}
}
