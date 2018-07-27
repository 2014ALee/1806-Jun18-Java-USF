package com.revature.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.User;
import com.revature.repositories.UserRepository;

public class RevachatDriver {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		User newUser = new User("tsteyaert","tom@gmail5.com", "Tom", "Steyaert");
		
		UserRepository repo = new UserRepository();
		repo.addUser(newUser);
		
	}
	}
