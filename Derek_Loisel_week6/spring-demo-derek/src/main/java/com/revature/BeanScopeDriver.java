package com.revature;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Coach;

public class BeanScopeDriver {
public static void main(String[] args) {
	//load spring config page
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-scopes.xml");

	
	//retrieve a bean from the spring container
	Coach coach = context.getBean("myCoach", Coach.class);
	Coach assistantCoach = context.getBean("myCoach", Coach.class);
	
	//check if the two beans retrieved from the container are pointing to the same object
	
	boolean result = (coach == assistantCoach);
	
	//this will be true w/ singleton scope but false w/ prototype scope
	
	//print out the results and memory locations
	System.out.println("pointing to the same object: " + result);
	System.out.println("memory location for coach: " + coach);
	System.out.println("memory location for assistantcoach: " + assistantCoach);


	//close container
	context.close();
}
}
