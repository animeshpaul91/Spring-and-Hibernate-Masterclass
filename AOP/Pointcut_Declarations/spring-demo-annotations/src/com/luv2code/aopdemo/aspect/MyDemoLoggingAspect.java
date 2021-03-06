package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
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

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))") // PointCut Declaration
	private void forDaoPackage() {
	}

	// pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	// pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

	// combine PointCuts - include package and exclude getters and setters
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
	}

	// apply combined PointCut

	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=============>>> Executing @Before package match advice methods()");
	}

	// apply combined PointCut

	@Before("forDaoPackageNoGetterSetter()")
	public void performAPIAnalyticsAdvice() {
		System.out.println("=============>>> Executing @Before Performing API Analytics");
	}

}
