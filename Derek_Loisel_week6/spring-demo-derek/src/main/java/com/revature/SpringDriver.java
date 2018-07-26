package com.revature;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Coach;
import com.revature.beans.FootballCoach;

public class SpringDriver {

	public static void main(String[] args) {
		
		//load the spring config file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");//looks in resources by default
		
		//retrieve the bean from the spring container
		
		Coach coach = context.getBean("myCoach", Coach.class); //the interface will work as class here
		
		//call some methods on the retrieved bean
		
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getMotivation());
		
		System.out.println("--------------------------------------------");
		
		FootballCoach footballCoach = context.getBean("myFootballCoach", FootballCoach.class);
		System.out.println(footballCoach.getDailyWorkout());
		System.out.println(footballCoach.getMotivation());
		System.out.println(footballCoach.getEmail());
		
		
		//close the spring container
		context.close();
	}
}
