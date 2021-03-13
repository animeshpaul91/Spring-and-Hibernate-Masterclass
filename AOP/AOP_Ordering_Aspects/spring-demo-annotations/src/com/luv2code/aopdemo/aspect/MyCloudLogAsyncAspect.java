package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCloudLogAsyncAspect {

	@Before("forDaoPackageNoGetterSetter()")
	public void loggingToCloudAsync() {
		System.out.println("=============>>> Logging to Cloud Async fashion");
	}
}
