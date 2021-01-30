package com.lovetocode.springdemo;

public class GolfCoach implements Coach{

	private FortuneService fortuneservice;
	
	
	public GolfCoach(FortuneService fortuneservice) {
		this.fortuneservice = fortuneservice;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice Skills for 2 hours everyday";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneservice.getFortune();
	}

}
