package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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

			// create a course
			Course course = new Course("Pacman - How to Score One Million Points");
			
			System.out.println("\nSaving the course...");
			session.save(course);
			System.out.println("Saved the course: " + course);
			
			// create the students
			Student student1 = new Student("John", "Doe", "jdoe@gmail.com");
			Student student2 = new Student("Mary", "Public", "mpublic@gmail.com");
			
			course.addStudent(student1);
			course.addStudent(student2);
			
			System.out.println("\nSaving the students");
			session.save(student1);
			session.save(student2);
			System.out.println("Saved the students: " + course.getStudents());

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
