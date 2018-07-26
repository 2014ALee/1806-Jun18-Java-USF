package com.revature;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Coach;

public class BeanScopeDriver {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-scopes.xml");
		
		Coach coach = context.getBean("myCoach", Coach.class);
		
		Coach assistant = context.getBean("myCoach", Coach.class);
		
		boolean result = (coach == assistant);
		
		context.close();
		
	}
	
}
