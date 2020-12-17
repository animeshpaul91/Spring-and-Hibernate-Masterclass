package com.lovetocode.springdemo;

public class BaseballCoach implements Coach {	
	
	// defina a private field for the dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on Batting Practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
