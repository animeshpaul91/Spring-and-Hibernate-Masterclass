package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RugbyJavaConfigDemoApp {

	public static void main(String[] args) {
		// read the Spring config file 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RugbyConfig.class);
		
		// get the bean from spring container
		Coach theCoach = context.getBean("rugbyCoach", Coach.class); // bean ID is the name of the bean method in SportConfig.java
		
		// call a method on the bean 
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to call daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		FortuneService fortuneService = context.getBean("moderateFortuneService", FortuneService.class);
		System.out.println(fortuneService.getFortune());
		context.close();
	}
}
