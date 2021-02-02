package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {
	
	private static final String fileName = "src/sport.properties";
	private List<String> list;
	
	@PostConstruct
	public void init() {
		System.out.println("Inside init method");
		
		File file = new File(fileName);
		System.out.println("Reading fortunes from file: " + file);
		System.out.println("File Exists: " + file.exists());
		
		list = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			
			while((line = br.readLine()) != null)
				list.add(line);
			
			br.close();
		}
		
		catch(IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	private static final Random random = new Random();
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		
		int index = random.nextInt(list.size());
		String fortuneText = list.get(index);
		String[] strings = fortuneText.split("=");
		return strings[1];
	}

}
