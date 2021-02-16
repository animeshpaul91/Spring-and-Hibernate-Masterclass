package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {						
			
			int employeeId = 1;			
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the ID
			System.out.println("\nGetting Employee with ID: " + employeeId);
			
			Employee myStudent = session.get(Employee.class, employeeId);
			System.out.println("Updating Employee...");
			myStudent.setFirstName("Animesh");
			
			// commit the transaction
			session.getTransaction().commit();
			
			// New Code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for Animesh
			System.out.println("Updating email for Animesh...");
			session.createQuery("update Employee set email='animeshpaul44@gmail.com' where id=1")
			.executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
		}
		finally {
			factory.close();
		}
	}

}
