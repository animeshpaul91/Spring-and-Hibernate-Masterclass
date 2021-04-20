package com.in28minutes.springboot.basics.springbootin10steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication 
// indicates that this is a spring context file
// enables auto configuration
// enables Component Scanning recursively from within this package
public class SpringbootIn10StepsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =  SpringApplication.run(SpringbootIn10StepsApplication.class, args);
		
//		for(String string: applicationContext.getBeanDefinitionNames()) {
//			System.out.println(string);
//		}
	}

}
