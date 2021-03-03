package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start the transaction
			session.beginTransaction();

			// Option -2 Query with HQL

			int id = 1;

			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id=:theInstructorId",
					Instructor.class); // will retrieve everything in memory
			// set parameter on query
			query.setParameter("theInstructorId", id);

			// execute query and get instructor
			Instructor instructor = query.getSingleResult();

			System.out.println("luv2code: Instructor: " + instructor);

			// commit transaction
			session.getTransaction().commit();

			// close the session
			session.close();

			System.out.println("\n The Session is now closed\n");
			System.out.println("luv2code: Courses: " + instructor.getCourses()); // still can access lazy data even
																					// after session.close
			// bcz everytihing is in memory

			System.out.println("Done!");
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
