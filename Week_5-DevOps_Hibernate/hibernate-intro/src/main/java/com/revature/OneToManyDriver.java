package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Course;
import com.revature.models.Instructor;
import com.revature.models.InstructorDetail;

public class OneToManyDriver {

	public static void main(String[] args) {

		// Create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // not required, Hibernate will look for this file automatically
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// Retrieve the Session from the SessionFactory
		Session session = factory.getCurrentSession();
		
		try {
			
//			/*
//			 * ONE-TO-MANY MAPPING DEMO
//			 */
//			// Create the objects
//			Instructor tempInstructor = new Instructor("Steven", "Kelsey", "sk@gmail.com");
//			InstructorDetail tempDetail = new InstructorDetail("Java", "Music");
//			
//			// Associate the objects
//			tempInstructor.setInstructorDetail(tempDetail);
//			
//			// Start a transaction
//			session.beginTransaction();
//			
//			// Save the instructor
//			System.out.println("Saving instructor: " + tempInstructor);
//			session.save(tempInstructor);
//			
//			// Commit the transaction
//			session.getTransaction().commit();
//			
//			System.out.println("Instructor saved!");
//			
//			session = factory.getCurrentSession();
//			
//			session.beginTransaction();
//			
//			// Get a instructor from the DB by PK
//			int instructId = 3;
//			Instructor tempInstructor = session.get(Instructor.class, instructId);
//			
//			// Create some courses
//			Course course1 = new Course("Hibernate Basics");
//			Course course2 = new Course("Hibernate Advanced Mappings");
//			
//			// Add courses to the instructor
//			tempInstructor.add(course1);
//			tempInstructor.add(course2);
//			
//			// Save the courses
//			session.save(course1);
//			session.save(course2);
//			
//			// Commit the transaction
//			session.getTransaction().commit();
//			
			//------------------------------------------------------------------
			
			/*
			 * ONE-TO-MANY MAPPING: BI-DIRECTIONAL
			 * Getting Courses from an Instructor
			 */
			// Get a session and begin transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Get an instructor from the DB
			int instructId = 3;
			Instructor tempInstructor = session.get(Instructor.class, instructId);
			
			System.out.println("Instructor: " + tempInstructor);
			
			// Get the instructor's courses
			System.out.println("Courses: " + tempInstructor.getCourses());
			
			// Commit the transaction
			session.getTransaction().commit();
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
