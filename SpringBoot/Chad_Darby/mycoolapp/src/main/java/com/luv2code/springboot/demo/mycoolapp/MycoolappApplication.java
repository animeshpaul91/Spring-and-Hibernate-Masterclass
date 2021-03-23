package com.luv2code.springboot.demo.mycoolapp;

import org.springframework.boot.SpringApplication; // special class that is used to helps bootstrap our springboot application
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Composed of @EnableAutoConfiguration, @ComponentScan, @Configuration 
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
		
		/* The above lines behind the scenes
		 * Creates Application Context
		 * Registers all beans
		 * Starts the embedded server
		 */
	}

}

/* 
@EnableAutoConfiguration - Enables Spring Boot's auto-configuration support
@ComponentScan - Enables Component Scanning of current package. Also Recursively scans sub packages
@Configuration - Able to register extra beans with @Bean or import other configuration classes
*/

/*
 * If there are other packages that need Component Scanning, then
 * @SpringBootApplication(
 * scanBasePackages= { "com.luv2code.springboot.demo.mycoolapp",
 * 						"org.acme.iot.utils", 
 * 						"edu.cmu.wead"})
 */

/*
	By default, SpringBoot will load prperties from application.properties
*/

/* 
	Do not use src/main/webapp directory if your application is packaged as a JAR. This Only works for WAR.
*/