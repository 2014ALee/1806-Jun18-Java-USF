package com.reavture;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Coach;

public class BeanScopeDriver {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-scopes.xml");
		Coach coach = context.getBean("myCoach", Coach.class);
		Coach assistantCoach = context.getBean("myCoach", Coach.class);
		
		boolean result = (coach == assistantCoach);
		
		System.out.println("pointing to same object " + result);
		System.out.println("Memory location for coach: " + coach);
		System.out.println("memory lcoation for assitantCoach = " + assistantCoach);
		
		context.close();
	}
}