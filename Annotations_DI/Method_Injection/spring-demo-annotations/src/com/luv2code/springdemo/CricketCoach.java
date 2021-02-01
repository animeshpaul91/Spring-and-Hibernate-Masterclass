package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "10 overs of batting and bowling daily";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "";
	}
	
	

}
