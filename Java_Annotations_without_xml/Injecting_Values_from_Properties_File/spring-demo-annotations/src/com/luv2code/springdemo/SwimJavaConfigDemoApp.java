package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// read the Spring config file 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class); // bean ID is the name of the bean method in SportConfig.java
		
		// call a method on the bean 
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to call daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// call the new methods
		System.out.println("Email: " + theCoach.getEmail());		
		System.out.println("Team: " + theCoach.getTeam());
		
		// close the context
		context.close();
	}
}
