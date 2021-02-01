package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Spring will automatically register this bean with the default bean ID tennisCoach (camelcased)
// else you can specify a custom bean ID in parenthesis after the annotation.
public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("Inside default constructor");
	}

//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside fortuneService setter method");
		this.fortuneService = fortuneService;
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
