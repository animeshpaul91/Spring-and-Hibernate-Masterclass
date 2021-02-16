package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class ReadEmployeeDemo {

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
			Employee employee = new Employee("Daffy", "Duck", "dduck@gmail.com", "Cisco");			
			
			// start the transaction
			session.beginTransaction();			
			
			// save the student object
			System.out.println("Saving the employee");
			System.out.println(employee);
			session.save(employee);
			
			// commit transaction
			session.getTransaction().commit();
			
			// My new Code to retrieve object
			System.out.println("Saved student. Genarated ID: " + employee.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the ID
			System.out.println("\nGetting Employee with ID: " + employee.getId());
			
			Employee sameEmployee = session.get(Employee.class, employee.getId());
			System.out.println("Get Complete: " + sameEmployee);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
		}
		finally {
			factory.close();
		}
	}

}
