package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create an Array of Strings
	private static final String[] data = {
			"Beware of wolf in sheep's clothing", 
			"Diligence is the mother of good luck", 
			"The Journey is the reward"
	};
	
	private static final Random random = new Random();
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		int index = random.nextInt(data.length);
		return data[index];
	}

}
