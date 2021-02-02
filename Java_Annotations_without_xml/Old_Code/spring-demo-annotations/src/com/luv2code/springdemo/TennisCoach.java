package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // Spring will automatically register this bean with the default bean ID tennisCoach (camelcased)
// else you can specify a custom bean ID in parenthesis after the annotation.
public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	// define the init method
	@PostConstruct
	public void init() {
		System.out.println("TennisCoach inside init method");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("TennisCoach inside destroy method");
	}

	@Override
	public String getDailyWorkout() { 
		return "Practice your backhand volley";
	}
	
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
