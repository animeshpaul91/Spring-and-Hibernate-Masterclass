package com.luv2code.beanscope;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lovetocode.springdemo.Coach;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//load the Spring Config File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		// retrieve bean from Spring Container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		boolean result = theCoach.equals(alphaCoach);
		System.out.println("\nPointing to the same object: "+ result);
		System.out.println("\nMemory Address of thecoach: " + theCoach);
		System.out.println("\nMemory Address of alphacoach: " + alphaCoach);
	}
}
