package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// create Object Mapper 
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to Java POJO
			Student student = mapper.readValue(new File("data/sample-lite.json"), Student.class);
			
			// print first name and last name
			System.out.println("First Name: " + student.getFirstName());
			System.out.println("Last Name: " + student.getLastName());
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
