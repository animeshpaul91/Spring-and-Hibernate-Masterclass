package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {
	
	public static void main(String[] args) {
		// create session factory		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			System.out.println("Creating a new Employee object");
			
			// create a student object
			Employee employee = new Employee("Animesh", "Paul", "ani.nitmz@gmail.com", "Visa Inc");			
			
			// start the transaction
			session.beginTransaction();			
			
			// save the student object
			System.out.println("Saving the Employee");
			session.save(employee);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}
}
