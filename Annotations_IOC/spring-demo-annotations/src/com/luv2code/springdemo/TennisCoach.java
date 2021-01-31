package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach") // Spring will automatically register this bean with the bean ID thatSillyCoach
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() { 
		return "Practice your backhand volley";
	}

}
