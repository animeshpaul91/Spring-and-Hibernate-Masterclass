package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			Course course1 = new Course("Air Guitar - The Ultimate Guide");
			Course course2 = new Course("The PinBall - Masterclass");
			
			instructor.add(course1);
			instructor.add(course2);
			
			session.save(course1);
			session.save(course2);
			
			// commit transaction
			session.getTransaction().commit();
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
