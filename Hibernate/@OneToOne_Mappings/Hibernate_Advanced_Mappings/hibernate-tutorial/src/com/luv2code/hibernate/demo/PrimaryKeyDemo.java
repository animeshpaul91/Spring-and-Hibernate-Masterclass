package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create 3 new students
			System.out.println("Creating 3 new student objects");

			String dateOfBirth = "23/11/1991";
			Date dob = DateUtils.parseDate(dateOfBirth);
			
			// create a student object
//			Student student = new Student("Animesh", "Paul", "ani.nitmz@gmail.com");			
			Student student1 = new Student("John", "Doe", "jdoe@gmail.com", dob);
			Student student2 = new Student("Mary", "Jane", "mjane@gmail.com", dob);
			Student student3 = new Student("Ashley", "Smith", "asmith@gmail.com", dob);

			// start the transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the students");			
			session.save(student1);
			session.save(student2);
			session.save(student3);

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
