package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// Create the objects
			Instructor instructor1 = new Instructor("Susan", "Miller", "smiller@luv2code.com");

			InstructorDetail instructorDetail1 = new InstructorDetail("http://www.luv2code.com/gaming", "Gaming");

			Instructor instructor2 = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

			InstructorDetail instructorDetail2 = new InstructorDetail("http://youtube.com/", "Guitar");

			// associate the objects
			instructor1.setInstructorDetail(instructorDetail1);
			instructor2.setInstructorDetail(instructorDetail2);

			// start the transaction
			session.beginTransaction();

			// save the instructor
			// Note this will also save the details object because of cascadetype.ALL
			System.out.println("Saving instructor1: " + instructor1);
			System.out.println("Saving instructor2: " + instructor2);

			session.save(instructor1);
			session.save(instructor2);

			// commit transaction
			session.getTransaction().commit();
		}

		catch (NullPointerException nullPointerException) {
			nullPointerException.printStackTrace();
		}

		finally {
			session.close();
			factory.close();
		}
	}

}
