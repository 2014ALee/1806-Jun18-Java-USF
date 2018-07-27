package com.revature;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Coach;

public class AnnotationDriver {
	public static void main(String[] args) {
		// Lead the Spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		// Get beans from the container
		Coach baseballCoach = context.getBean("myBaseballCoach", Coach.class);
		Coach trackCoach = context.getBean("trackCoach", Coach.class);
		Coach footballCoach = context.getBean("myFootballCoach", Coach.class);
		
		// Call some methods on the retrieved beans
		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(baseballCoach.getMotivation());
		
		System.out.println(trackCoach.getDailyWorkout());
		System.out.println(trackCoach.getMotivation());
		
		System.out.println(footballCoach.getDailyWorkout());
		System.out.println(footballCoach.getMotivation());
		
		// Close the container
		context.close();
	}
}
