package com.revature;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Coach;

public class BeanScopeDriver {

	public static void main(String[] args) {

		// Load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-scopes.xml");
		
		// retrieve a bean from the spring container
		Coach coach = context.getBean("myCoach", Coach.class);
		Coach assistantCoach = context.getBean("myCoach", Coach.class);
		
		// check if two beans retrieved from the container are pointing to the same object
		boolean result = (coach == assistantCoach);
		
		// print out the results and memory location
		System.out.println("Pointing to the same object: " + result);
		System.out.println("Memory location of 'coach': " + coach);
		System.out.println("Memory location of 'assistantCoach': " + assistantCoach);
		
		// close the container
		context.close();
	}

}
