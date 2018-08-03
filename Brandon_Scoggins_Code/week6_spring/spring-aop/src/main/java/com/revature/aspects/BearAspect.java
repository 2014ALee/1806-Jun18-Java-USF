package com.revature.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.beans.Bear;

@Aspect
@Component
public class BearAspect {

	@Before("execution(* bearHibernates())")
	public void stockUpForWinter(JoinPoint jp) {
		
		Bear b = (Bear) jp.getTarget();
		
		if (b.isFull()) {
			System.out.println("Bear is stoked up for winter");
		} else {
			System.out.println("Bear will be hungry when they wake up");
		}
	}
	
	@Around("execution(* wake*(..))")
	public void wakeAnimal(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("before method execution");
		long start = System.currentTimeMillis();
		pjp.proceed();
		long end = System.currentTimeMillis();
		System.out.println("Total execution time: " + (end - start));
	}
}
