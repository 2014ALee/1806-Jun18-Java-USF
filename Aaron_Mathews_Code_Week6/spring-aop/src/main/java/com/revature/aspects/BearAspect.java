package com.revature.aspects;

import org.apache.log4j.net.SyslogAppender;
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
	public void stockedUpForWinter(JoinPoint jp) {
		
		Bear b = (Bear) jp.getTarget();
		
		if (b.isFull()) {
			System.out.println("Bear was stocked up and ready for winter.");
		} else {
			System.out.println("Bear is going to be hungry when he wakes up.");
		}
		
	}
	
	@Around("execution(* wake*(..))")
	public void wakeAnimal(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Before the method execution");
		long start = System.currentTimeMillis();
		pjp.proceed(); //allows method to proceed
		long end = System.currentTimeMillis();
		System.out.println("After the method's execution. Total execution time: " + (end - start));
	}

}
