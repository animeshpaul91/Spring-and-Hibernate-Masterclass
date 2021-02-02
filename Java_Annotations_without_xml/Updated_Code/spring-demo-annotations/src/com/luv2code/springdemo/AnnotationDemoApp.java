package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// read the Spring config file 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);
		
		// call a method on the bean 
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyWorkout());
		
		// call method to call daily fortune
		System.out.println(theCoach.getDailyFortune());
		System.out.println(cricketCoach.getDailyFortune());
		
		// close the context
		context.close();
	}
}
