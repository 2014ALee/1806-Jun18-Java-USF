package com.revature;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Coach;

public class AnnotationDriver {
	
	public static void main(String[] args) {
		//Load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//Get beans from container
		Coach baseballCoach = context.getBean("myBaseballCoach", Coach.class);
		Coach trackCoach = context.getBean("trackCoach", Coach.class);
		
		//Call methods on beans
		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(baseballCoach.getMotivation());
		System.out.println(trackCoach.getDailyWorkout());
		
		//Close container
		context.close();
	}
}
