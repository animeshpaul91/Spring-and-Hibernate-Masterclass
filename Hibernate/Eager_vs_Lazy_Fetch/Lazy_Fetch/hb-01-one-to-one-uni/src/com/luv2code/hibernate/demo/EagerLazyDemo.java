package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start the transaction
			session.beginTransaction();
			
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("luv2code: Instructor: " + instructor);
			
			// Get this instructor's courses
			System.out.println("luv2code: Courses: " + instructor.getCourses()); // in lazy loading this is the point 
			// where courses will be queried by hibernate. It requires the same session to be active. 
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}

		catch(NullPointerException nullPointerException) {
			nullPointerException.printStackTrace();
		}
		
		finally {			
			session.close();
			factory.close();
		}
	}

}
