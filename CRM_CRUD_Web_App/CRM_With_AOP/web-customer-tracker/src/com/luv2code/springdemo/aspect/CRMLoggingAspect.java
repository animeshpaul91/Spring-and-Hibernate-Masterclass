package com.luv2code.springdemo.aspect;

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

	// setup Logger
	private Logger logger = Logger.getLogger(getClass().getName());

	// setup Pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	// same for dao
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}

	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		// display method we are calling
		String methodName = joinPoint.getSignature().toShortString();
		logger.info("=============>> in @Before: calling method: " + methodName);
		
		// display the args to the method
		// get the args
		Object[] args = joinPoint.getArgs();
		
		for(Object arg: args) 
			logger.info("======> argument: " + arg);
		
	}

	// add @AfterReturning advice
	@AfterReturning(pointcut="forAppFlow()", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {		
		// display method we are returning from
		String methodName = joinPoint.getSignature().toShortString();
		logger.info("=============>> in @AfterReturning: from method: " + methodName);
		
		// display data returned
		logger.info("==========> result: " + result);
	}
	
}
