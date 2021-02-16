package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create 3 new students
			System.out.println("Creating 3 new employee objects");

			// create a Employee object
			Employee employee1 = new Employee("John", "Doe", "jdoe@gmail.com", "Amazon.com");
			Employee employee2 = new Employee("Mary", "Jane", "mjane@gmail.com", "Google");
			Employee employee3 = new Employee("Ashley", "Smith", "asmith@gmail.com", "Oracle");

			// start the transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the employees");
			session.save(employee1);
			session.save(employee2);
			session.save(employee3);

			// commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
