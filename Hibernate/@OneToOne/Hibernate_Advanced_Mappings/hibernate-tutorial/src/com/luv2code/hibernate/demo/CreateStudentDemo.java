package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object
			System.out.println("Creating a new student object");

			String dateOfBirth = "23/11/1991";
			Date dob = DateUtils.parseDate(dateOfBirth);

			// create a student object
			Student student = new Student("Animesh", "Paul", "ani.nitmz@gmail.com", dob);

			// start the transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student");
			session.save(student);

			// commit transaction
			session.getTransaction().commit();
		}

		catch (ParseException parseException) {
			parseException.printStackTrace();
		}

		finally {
			factory.close();
		}
	}

}
