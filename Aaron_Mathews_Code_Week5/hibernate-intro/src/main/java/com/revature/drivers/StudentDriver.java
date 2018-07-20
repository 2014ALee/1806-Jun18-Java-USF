package com.revature.drivers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Student;

public class StudentDriver {
	
	public static void main(String[] args) {
		
		//Create SessionFactory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		//Retrieve session from factory
		Session session = factory.getCurrentSession();
		
		try {
		/*	
			
			 * Create Student Demo
			 
			//Create student obj
			System.out.println("Creating a new student object");
			Student myStudent = new Student("Wezley", "Singleton", "ws@gmail.com");
			
			//Start transaction
			session.beginTransaction();
			
			//Save student
			System.out.println("Saving the student");
			session.save(myStudent);
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Student successfully saved");
			*/
			
			/*
			 * Primary keys
			 */
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
