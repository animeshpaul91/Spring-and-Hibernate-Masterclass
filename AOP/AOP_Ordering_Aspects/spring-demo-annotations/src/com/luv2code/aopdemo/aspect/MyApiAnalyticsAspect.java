package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyApiAnalyticsAspect {

	// apply combined PointCut
	@Before("forDaoPackageNoGetterSetter()")
	public void performAPIAnalyticsAdvice() {
		System.out.println("=============>>> Executing @Before Performing API Analytics");
	}
}
