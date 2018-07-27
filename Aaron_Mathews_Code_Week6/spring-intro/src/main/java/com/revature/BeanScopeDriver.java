package com.revature;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Coach;

public class BeanScopeDriver {
	
	public static void main(String[] args) {
		
		//Load the Spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-scopes.xml");
		
		//Retrieve a bean from the spring container
		Coach coach = context.getBean("myCoach", Coach.class);
		Coach assistantCoach = context.getBean("myCoach", Coach.class);
		
		//Check if the two beans retrieved from the container are printing to the same object
		boolean result = (coach == assistantCoach);
		
		//Prints the results and memory location
		System.out.println("Point to the same object: " + result);
		System.out.println("Memory location for 'coach': " + coach);
		System.out.println("Memory location for 'assistantCoach': " + assistantCoach);
		
		//Close the container
		context.close();
		
	}

}
