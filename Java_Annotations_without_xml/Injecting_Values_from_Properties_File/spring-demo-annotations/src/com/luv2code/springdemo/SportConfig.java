package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	// define bean for our sad fortune service
	
	@Bean
	public FortuneService sadFortuneService() { // the method name is the bean ID that spring will use it to assign it to a container
		return new SadFortuneService();
	}
	
	// define bean for our swim coach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService()); // constructor injection. 
		/* only first invocation creates the instance and registers it with the Spring container.
		 *  subsequent invocations only return an instance of the bean in memory (from the spring container)
		 */
	}
}
