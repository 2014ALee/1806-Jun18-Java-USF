package com.revature;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Coach;
import com.revature.beans.FootballCoach;

public class SpringDriver {
	
	public static void main(String[] args) {
		
		//Load the Spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//Annotation
		
		//Retrieve bean from Spring container
		Coach coach = context.getBean("myCoach", Coach.class);
		
		//Call methods on retrieved bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getMotivation());
		
		System.out.println("---------------------------------------------------");
		
		FootballCoach footballCoach = context.getBean("myFootballCoach", FootballCoach.class);
		System.out.println(footballCoach.getDailyWorkout());
		System.out.println(footballCoach.getMotivation());
		
		//Fields are inject by configuration file (beans.xml)
		System.out.println(footballCoach.getEmail());
		System.out.println(footballCoach.getTeam());
		
		//Close the Spring container
		context.close();
	}

}
