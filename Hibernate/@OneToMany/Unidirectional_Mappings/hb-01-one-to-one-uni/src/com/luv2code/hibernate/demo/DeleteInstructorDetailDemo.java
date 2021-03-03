package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start the transaction
			session.beginTransaction();

			// get instsructor detail object
			int id = 4;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id); // will return null if id is
																							// invalid

			// print instructor detail
			System.out.println("Instructor Detail: " + instructorDetail);

			// print the associated instructor
			Instructor associatedInstructor = instructorDetail.getInstructor();
			System.out.println("The Assocciated Instructor: " + associatedInstructor);

			// now let's delete the instructor detail
			System.out.println("Deleting Instructor Detail: " + instructorDetail);

			// remove the associated reference
			// break bi directional link

			associatedInstructor.setInstructorDetail(null);

			session.delete(instructorDetail); // will also delete the associated instructor bcz of cascading delete

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}

		finally {
			// handle leak issue
			session.close();
			factory.close();
		}
	}

}
