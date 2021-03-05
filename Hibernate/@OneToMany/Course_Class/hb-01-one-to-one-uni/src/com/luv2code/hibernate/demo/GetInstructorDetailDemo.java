package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start the transaction
			session.beginTransaction();

			// get instsructor detail object
			int id = 3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id); // will return null if id is
																							// invalid

			// print instructor detail
			System.out.println("Instructor Detail: " + instructorDetail);

			// print the associated instructor
			System.out.println("The Assocciated Instructor: " + instructorDetail.getInstructor());

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}

		finally {
			// handle leak issue
			session.close();
			factory.close();
		}
	}

}
