package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int employeeId = 2;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the ID
			System.out.println("\nGetting Employee with ID: " + employeeId);

			Employee myStudent = session.get(Employee.class, employeeId);
			System.out.println("Deleting Employee: " + myStudent);
			session.delete(myStudent);

			// commit the transaction
			session.getTransaction().commit();
			
			// Alternate Approach
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Deleting Employee with id=5");
			session.createQuery("delete from Employee where id=6").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!!");
		} finally {
			factory.close();
		}
	}

}
