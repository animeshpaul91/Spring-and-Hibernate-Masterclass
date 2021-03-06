package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);

		logger.info("\nMain Program: Around Demo App");
		logger.info("Calling getFortune()");

		boolean tripWire = true;
		String fortune = trafficFortuneService.getFortune(tripWire); // this gets invoked through the Advice and not from the
		// main has no track of thrown exception
		
		// Allows code to be executed before and after executing the target method.

		logger.info("\nMy Fortune is: " + fortune);
		logger.info("Finished");

		// close the context
		context.close();

	}

}
