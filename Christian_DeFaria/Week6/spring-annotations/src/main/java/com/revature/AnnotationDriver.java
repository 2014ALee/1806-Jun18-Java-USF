package com.revature;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Coach;

public class AnnotationDriver {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Coach baseballCoach = context.getBean("myBaseballCoach", Coach.class);
		Coach footballCoach = context.getBean("myFootballCoach", Coach.class);
		Coach trackCoach = context.getBean("trackCoach", Coach.class);
		
		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(baseballCoach.getMotivation());
		
		System.out.println(trackCoach.getDailyWorkout());
		System.out.println(trackCoach.getMotivation());
		
		System.out.println(footballCoach.getDailyWorkout());
		System.out.println(footballCoach.getMotivation());
		
		context.close();
	}

}
