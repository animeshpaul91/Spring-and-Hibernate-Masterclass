package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start the transaction
			session.beginTransaction();

			// get instructor by primary key
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("Found Instructor: " + instructor);

			// delete the instructor
			if (instructor != null) {
				System.out.println("Deleting: " + instructor);
				session.delete(instructor); // will also delete the corresponding details object because of
											// CascadeType.ALL
			}

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
		}

		finally {
			factory.close();
		}
	}

}
