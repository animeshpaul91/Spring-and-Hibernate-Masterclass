package com.lovetocode.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService{
	
	private static final Random random = new Random();
	private static final String[] data = {"random1", "random2", "random3"};


	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		int index = random.nextInt(data.length);
		return data[index];
	}
	
}
