package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// Create the objects
//			Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//			
//			InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code");
			
			Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com/", "Guitar");
			
			// associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			// start the transaction
			session.beginTransaction();

			// save the instructor 
			// Note this will also save the details object because of cascadetype.ALL
			System.out.println("Saving instructor: " + instructor);
			
			session.save(instructor);
			
			// commit transaction
			session.getTransaction().commit();
		}

		finally {
			factory.close();
		}
	}

}
