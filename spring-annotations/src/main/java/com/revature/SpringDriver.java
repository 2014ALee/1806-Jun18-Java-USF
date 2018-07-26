package com.revature;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Coach;
import com.revature.beans.FootballCoach;

public class SpringDriver {

public static void main(String[] args) {
	
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	Coach coach = context.getBean("myCoach", Coach.class);
	
	System.out.println(coach.getDailyWorkout());

	System.out.println(coach.getMotivation());
	
	System.out.println("-------------------------------------------------------");
	
	FootballCoach footBallCoach = context.getBean("myFootballCoach", FootballCoach.class);
	
	
	System.out.println(footBallCoach.getEmail());

	System.out.println(footBallCoach.getTeam());
	
	
	context.close();
	
}	
	
}
