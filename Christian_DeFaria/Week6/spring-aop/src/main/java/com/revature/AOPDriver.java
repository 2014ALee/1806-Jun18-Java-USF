package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Bear;

public class AOPDriver {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Bear bear = context.getBean("bear", Bear.class);
		
		bear.setWinter(false);
		bear.setFull(false);
		
		try {
			System.out.println("Is the bear full?: " + bear.isFull());
			bear.bearHibernates();
			
			System.out.println("Is the bear alseep?: " + bear.isAwake());
			bear.wakeUpBear();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		((ClassPathXmlApplicationContext) context).close();
	}

}
