package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Instructor;
import com.revature.models.InstructorDetail;
import com.revature.models.Student;

public class OneToOneDriver {

	public static void main(String[] args) {
		// Create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // not required, Hibernate will look for this file automatically
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// Retrieve the Session from the SessionFactory
		Session session = factory.getCurrentSession();
		
		try {
			/*
			 * ONE-TO-ONE MAPPING DEMO
			 */
//			// Create the objects
//			/*Instructor tempInstructor = new Instructor("Wezley", "Singleton", "ws@gmail.com");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("Java", "Astronomy");*/
//			
//			Instructor tempInstructor = new Instructor("Blake", "Kruppa", "bk@gmail.com");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("JavaScript", "Turtles");
//			
//			// Associate the objects
//			tempInstructor.setInstructorDetail(tempInstructorDetail);
//			
//			// Start a transaction
//			session.beginTransaction();
//			
//			/* 
//			 * Save the Instructor object, and since CascadeType.ALL is specified on the mapping, 
//			 * the InstructorDetail object will be saved to the DB as well 
//			 */
//			System.out.println("Saving instructor: " + tempInstructor);
//			session.save(tempInstructor);
//			
//			// Commit the transaction
//			session.getTransaction().commit();
//			
//			System.out.println("Instructor successfully saved!");
			
			//-------------------------------------------------------------------------------------------
			
//			/*
//			 * ONE-TO-ONE MAPPING CASCADE DELETE DEMO
//			 */
//			// Create the session
//			session = factory.getCurrentSession();
//		
//			
//			// Start a transaction
//			session.beginTransaction();
//			
//			// Get the instructor by primary key
//			int instructId = 2;
//			Instructor tempInstructor = session.get(Instructor.class, instructId);
//			
//			System.out.println("Instructor retrieved: " + tempInstructor);
//			
//			// Delete the Instructor and the InstructorDetail objects from the DB
//			if (tempInstructor != null) {
//				System.out.println("Deleting: " + tempInstructor);
//				session.delete(tempInstructor);
//			}
//			
//			// Commit the transaction
//			session.getTransaction().commit();
			
			//--------------------------------------------------------------------------------
			
			/*
			 * BI-DIRECTIONAL ONE-TO-ONE MAPPING DEMO
			 */
			// Get session, begin transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Get a InstructorDetail object using a PK
			int instructDetailId = 4;
			InstructorDetail tempDetail = session.get(InstructorDetail.class, instructDetailId);
			System.out.println("tempDetail: " + tempDetail);
			
			// See that the associated instructor is available to us without having to call .get() for the Instructor
			System.out.println("the associated instructor: " + tempDetail.getInstructor());
			
			// Commit the transaction
			session.getTransaction().commit();
		
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
