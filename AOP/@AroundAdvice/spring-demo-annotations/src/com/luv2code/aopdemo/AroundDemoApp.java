package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);

		System.out.println("\nMain Program: Around Demo App");
		System.out.println("Calling getFortune()");
		
		String fortune = trafficFortuneService.getFortune();
		System.out.println("\nMy Fortune is: " + fortune);
		System.out.println("Finished");
		
		// close the context
		context.close();

	}

}
