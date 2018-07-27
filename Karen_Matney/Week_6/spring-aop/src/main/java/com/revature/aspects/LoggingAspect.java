package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private static Logger log = Logger.getRootLogger();
	/*
	 * trace
	 * debug
	 * info
	 * warn
	 * error
	 * fatal
	 */
	@AfterReturning(pointcut="within(com.revature.beans.*)")
	public void logAfter(JoinPoint jp) {
		log.info(jp.getSignature());
	}
	
	@AfterThrowing("within(com.revature.beans.*)")
	public void logException(JoinPoint jp) {
		log.error(jp.getSignature());
	}
}
