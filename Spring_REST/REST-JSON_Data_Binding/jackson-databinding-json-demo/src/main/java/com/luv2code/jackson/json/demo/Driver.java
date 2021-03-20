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
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class); // invokes setters on
																									// the Class

			// print first name and last name
			System.out.println("First Name: " + student.getFirstName());
			System.out.println("Last Name: " + student.getLastName());

			// print out address: street and city
			Address address = student.getAddress();
			System.out.println("Street: " + address.getStreet());
			System.out.println("City: " + address.getCity());

			for (String language : student.getLanguages())
				System.out.println(language);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
