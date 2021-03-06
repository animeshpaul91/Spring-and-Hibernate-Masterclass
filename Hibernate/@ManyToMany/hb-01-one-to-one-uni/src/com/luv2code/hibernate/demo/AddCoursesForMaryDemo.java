package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start the transaction
			session.beginTransaction();

			// get mary from db 
			int id = 2;
			Student student = session.get(Student.class, id);
			System.out.println("\nMary: " + student);
			System.out.println("Mary's Courses: " + student.getCourses());

			// create more courses
			Course course1 = new Course("Rubik's Cube - How to speed Cube");
			Course course2 = new Course("Atari 2600 - Game Development");
			
			// add student to courses
			course1.addStudent(student);
			course2.addStudent(student);
			
			// save the courses
			System.out.println("Saving the courses...");
			session.save(course1);
			session.save(course2);
			
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
