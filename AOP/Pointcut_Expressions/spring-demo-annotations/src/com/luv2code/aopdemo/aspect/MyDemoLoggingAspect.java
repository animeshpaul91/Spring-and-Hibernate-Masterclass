package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add all of our related advices for logging
	
	// let's start with a @Before Advice
	
	// General Syntax 
	// execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
	// ? indicates optional
	// public - modifier
	// void - return type
	// com.luv2code.aopdemo.dao.AccountDAO - declaring type
	// addAccount() - method name (here no parameters)
	
	@Before("execution(public void add*(com.luv2code.aopdemo.Account, ..))") // match parameters by Account then followed by 0 or more parameters
	public void beforeAddAccountAdvice() {
		System.out.println("\n=============>>> Executing @Before advice on addAccount()");
	}
	
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") // match parameters by Account then followed by 0 or more parameters
	public void anotherAdvice() {
		System.out.println("\n=============>>> Executing @Before package match advice methods()");
	}
}
