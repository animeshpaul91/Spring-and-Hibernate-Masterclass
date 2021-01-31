package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component // Spring will automatically register this bean with the default bean ID tennisCoach (camelcased)
// else you can specify a custom bean ID in parenthesis after the annotation.
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() { 
		return "Practice your backhand volley";
	}

}
