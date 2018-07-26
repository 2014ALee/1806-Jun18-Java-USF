package com.revature.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.beans.Bear;

@Aspect
@Component
public class BearAspect {

	@Before("execution(* bearHibernates())")
	public void stockedUpForWinter(JoinPoint jp) {
	
		Bear b = (Bear) jp.getTarget();
		
		if(b.isFull()) {
			System.out.println("bear was stocked up and rdy for winter");
		}
		else {
			System.out.println("bears gonna be hungry when he wakes up");
		}
	}
}
