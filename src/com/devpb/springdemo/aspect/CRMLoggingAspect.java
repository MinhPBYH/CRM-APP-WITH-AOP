package com.devpb.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations 
	@Pointcut("execution(* com.devpb.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.devpb.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.devpb.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	//add @before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		 
		//display the method
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====> In @Before: calling method: " + method);
		
		//display the arguments to the method
		//get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		//loop through and display argument
		for (Object arg : args) {
			myLogger.info("=====> Argument: " + arg);
		}
		
	}
	
	//add @afterretuning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	public void afterReturning(
			JoinPoint theJoinPoint, Object result) {
		
		//display the method
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====> In @AfterReturning: calling method: " + method);
		
		//display data returned
		myLogger.info("=====> Result: " + result);
	}
	
	
	
}
