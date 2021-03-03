package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetCoursesLater {

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
			Instructor instructor = session.get(Instructor.class, id);

			System.out.println("Instructor: " + instructor);

			// commit transaction
			session.getTransaction().commit();

			// close the session
			session.close();
			System.out.println("\n The Session is now closed\n");

			// opening new session
			session = factory.getCurrentSession();
			session.beginTransaction();

			Query<Course> query = session
					.createQuery("select c from Course c " + "where c.instructor.id=:theInstructorId", Course.class); // will
																														// retrieve
																														// everything
																														// in
																														// memory
			// set parameter on query
			query.setParameter("theInstructorId", id);
			List<Course> courses = query.getResultList();

			System.out.println("luv2code: Courses: " + courses); // still can access lazy data even after session.close

			instructor.setCourses(courses);

			System.out.println("Instructor's Courses: " + courses); // still can access lazy data even after
																	// session.close
			session.getTransaction().commit();

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
