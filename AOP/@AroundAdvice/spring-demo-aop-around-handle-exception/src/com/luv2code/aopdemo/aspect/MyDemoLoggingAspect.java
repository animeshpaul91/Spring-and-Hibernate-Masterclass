package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	// this is where we add all of our related advices for logging

	// let's start with a @Before Advice

	// General Syntax
	// execution(modifiers-pattern? return-type-pattern declaring-type-pattern?
	// method-name-pattern(param-pattern) throws-pattern?)
	// ? indicates optional
	// public - modifier
	// void - return type
	// com.luv2code.aopdemo.dao.AccountDAO - declaring type
	// addAccount() - method name (here no parameters)

	// apply combined PointCut

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		logger.info("\n=============>>> Executing @Before package match advice methods()");

		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		logger.info("Method: " + methodSignature);
		logger.info("\n");

		// display the method arguments
		// get args
		Object[] args = joinPoint.getArgs();

		for (Object arg : args) {
			logger.info(arg.toString());
			if (arg instanceof Account) {
				// downcast and print Account specific stuff
				Account account = (Account) arg;
				logger.info("Account Name: " + account.getName());
				logger.info("Account Name: " + account.getLevel());
			}
		}
	}

	// add a new advice for @AfterReturning on the findAccounts method

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		// second argument has to match the keyword mentioned against returning in line
		// # 60

		// print the method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n=============>>>> Executing @AfterReturning on method: " + method);

		// print out the results of the method call
		logger.info("\n=============>>>> Result is: " + result);

		// let's post-process the data. Let's modify it
		// convert the account names to all uppercase
		convertAccountNamesToUpperCase(result);

		logger.info("\n=============>>>> Result is: " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through Accounts

		for (Account account : result) {
			// get uppercase version of the name
			String upperName = account.getName().toUpperCase();
			account.setName(upperName);
		}
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n=============>>>> Executing @AfterFinally on method: " + method);
	}

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exception")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n=============>>>> Executing @AfterThrowing on method: " + method);

		// logging the exception
		logger.info("\n=============>>>> The Thrown Exception is: " + exception);
	}

	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		// proceedingJoinPoint is just a handle to the target object
		// print out method we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("\n=============>>>> Executing @Around on method: " + method);

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// now let's execute method
		Object result = null;
		
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			// log the exception
			logger.warning(e.getMessage());
			
			// give user a custom message & handle the exception
			result = "Major accident! But no worries, your private helicopter is on the way";
		}
		
		// get end timestamp
		long end = System.currentTimeMillis();

		long duration = end - begin;
		logger.info("\n==========> Execution Time: " + duration / 1000 + " seconds");

		return result;
	}
}
