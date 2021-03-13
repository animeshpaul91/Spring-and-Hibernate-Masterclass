package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

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

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n=============>>> Executing @Before package match advice methods()");
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: " + methodSignature);
		System.out.println();
		
		// display the method arguments
		// get args
		Object[] args = joinPoint.getArgs();
		
		for(Object arg: args) {
			System.out.println(arg);
			if (arg instanceof Account) {
				// downcast and print Account specific stuff
				Account account = (Account) arg;
				System.out.println("Account Name: " + account.getName());
				System.out.println("Account Name: " + account.getLevel());
			}
		}
	}
	
	// add a new advice for @AfterReturning on the findAccounts method
	
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		// second argument has to match the keyword mentioned against returning in line # 60
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=============>>>> Executing @AfterReturning on method: " + method);
		System.out.println("\n=============>>>> Result is: " + result);
	}
}
