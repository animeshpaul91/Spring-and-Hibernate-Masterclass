package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		// Hibernate Query Language (HQL)
		try {					
			// start the transaction
			session.beginTransaction();			
			
			// query students
			List<Student> students = session.createQuery("from Student").getResultList();
			System.out.println("All students");
			displayStudents(students);
			
			// query students whose last name is doe
			students = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			System.out.println("Students who have last name of Doe");
			displayStudents(students);
			
			// query students: lastName of doe or firstName of 'Daffy'
			students = session.createQuery("from Student s where"
					+ " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			System.out.println("Students who have last name of Doe or firstName of Daffy");
			displayStudents(students);
			
			// query using LIKE clause
			students = session.createQuery("from Student s where"
					+ " s.email LIKE '%gmail.com'").getResultList();
			System.out.println("Students who have email addresses on domain gmail.com");
			displayStudents(students);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		// display students
		for(Student student: students)
			System.out.println(student);
	}

}
