package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class QueryEmployeeDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		// Hibernate Query Language (HQL)
		try {					
			// start the transaction
			session.beginTransaction();			
			
			// query students
			List<Employee> employees = session.createQuery("from Employee").getResultList();
			System.out.println("All students");
			displayStudents(employees);
			
			// query students whose last name is doe
			employees = session.createQuery("from Employee s where s.lastName='Doe'").getResultList();
			System.out.println("Employees who have last name of Doe");
			displayStudents(employees);
			
			// query students: lastName of doe or firstName of 'Daffy'
			employees = session.createQuery("from Employee s where"
					+ " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			System.out.println("Employees who have last name of Doe or firstName of Daffy");
			displayStudents(employees);
			
			// query using LIKE clause
			employees = session.createQuery("from Employee s where"
					+ " s.email LIKE '%gmail.com'").getResultList();
			System.out.println("Employees who have email addresses on domain gmail.com");
			displayStudents(employees);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Employee> employees) {
		// display students
		for(Employee employee: employees)
			System.out.println(employee);
	}

}
