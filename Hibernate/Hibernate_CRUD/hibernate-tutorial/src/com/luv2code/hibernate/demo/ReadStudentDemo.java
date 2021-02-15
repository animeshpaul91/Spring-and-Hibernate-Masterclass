package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			System.out.println("Creating a new student object");
			
			// create a student object
			Student student = new Student("Daffy", "Duck", "dduck@gmail.com");			
			
			// start the transaction
			session.beginTransaction();			
			
			// save the student object
			System.out.println("Saving the student");
			System.out.println(student);
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			
			// My new Code to retrieve object
			System.out.println("Saved student. Genarated ID: " + student.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the ID
			System.out.println("\nGetting Student with ID: " + student.getId());
			
			Student sameStudent = session.get(Student.class, student.getId());
			System.out.println("Get Complete: " + sameStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
		}
		finally {
			factory.close();
		}
	}

}
