package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 2;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the ID
			System.out.println("\nGetting Student with ID: " + studentId);

			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Deleting Student: " + myStudent);
			session.delete(myStudent);

			// commit the transaction
			session.getTransaction().commit();
			
			// Alternate Approach
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Deleting Student with id=5");
			session.createQuery("delete from Student where id=5").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!!");
		} finally {
			factory.close();
		}
	}

}
