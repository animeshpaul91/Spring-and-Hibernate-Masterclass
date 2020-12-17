package com.lovetocode.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;	
	
	public TrackCoach() {
		super();
	}

	public TrackCoach(FortuneService fortuneService) {		
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() { 
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just do it: " + fortuneService.getFortune();
	}

}
