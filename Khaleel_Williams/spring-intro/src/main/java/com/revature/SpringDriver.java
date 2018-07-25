package com.revature;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Coach;

public class SpringDriver {
	
	public static void main(String[] args) {
		
		// load the Spring configuration file 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		// Retrieve a bean from the Spring container
		Coach coach = context.getBean("myCoach", Coach.class);
		
		// Call some methods on the retrieved bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getMotivation());
		
		// Close the Spring container
		context.close();
	}

}
