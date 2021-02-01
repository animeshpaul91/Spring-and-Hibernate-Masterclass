package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {
	
	@Value("${fortune1}")
	private String fortune1;
	
	@Value("${fortune2}")
	private String fortune2;
	
	@Value("${fortune3}")
	private String fortune3;
	
	private static final Random random = new Random();
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		String[] data = {fortune1, fortune2, fortune3};
		int index = random.nextInt(data.length);
		return data[index];
	}

}
