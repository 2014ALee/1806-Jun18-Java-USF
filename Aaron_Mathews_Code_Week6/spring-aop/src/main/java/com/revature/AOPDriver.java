package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Bear;

public class AOPDriver {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Bear bear = ac.getBean("bear", Bear.class);
		
		//Setup stuff
		Bear.setWinter(true);
		bear.setFull(false);
		
		try {
			System.out.println("is the bear full?: " + bear.isFull());
			bear.bearHibernates();
			
			System.out.println("Is the bear asleep?: " + bear.isAwake());
			bear.wakeUpBear();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		((AbstractApplicationContext) ac).close(); 
	}

}
