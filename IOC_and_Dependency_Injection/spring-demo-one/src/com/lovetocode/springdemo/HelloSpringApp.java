package com.lovetocode.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");		
		//retrieve a bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach cricketCoach = context.getBean("cricketCoach", Coach.class);
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyWorkout());
		//close the context
		context.close();
	}

}
