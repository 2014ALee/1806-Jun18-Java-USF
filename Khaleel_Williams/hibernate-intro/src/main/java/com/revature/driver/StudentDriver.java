package com.revature.driver;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Student;

public class StudentDriver {

	public static void main(String[] args) {
		
		// Create SessionFactory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		// Retrieve a session from the SessionFactory
		Session session = factory.getCurrentSession();
		
		try {
			
//			/*
//			 * CREATE STUDENT DEMO
//			 */
//			// Create a Student object
			System.out.println("Creating a new student object...");
			Student myStudent = new Student("Wezley", "Singleton", "ws@gmail.com");
			
//			//Start a transaction
			session.beginTransaction();
//			
//			// Save the Student
			System.out.println("Saving the student to the DB");
			session.save(myStudent);
			
//			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Student successfully saved!");
			
		/*
		 * HIBERNATE & PRIMARY KEYS
		 */
		
//		//Create an array of students
//		System.out.println("Creating students array");
//		Student[] student = {
//				new Student("Blake", "Kruppa", "bk@gmail.com"),
//				new Student("Steven", "Kelsy", "sk@gmail.com"),
//				new Student("Genesis", "Bonds", "gb@gmail.com")
//		};
//		
			
		/*
		 *  READ STUDENT DEMO
		 */
		// Add a new Student to the DB	
//		Student myStudent = new Student("David", "Fay", "df@gmail.com");
//		session.beginTransaction();
//		session.save(myStudent);
//		session.getTransaction().commit();
//		
//		System.out.println("New student added with id: " + myStudent.getId());
//		
//		// Get a new session and begin a transaction
//		session = factory.getCurrentSession();
//		session.beginTransaction();
//		
//		// Retrieve the student from the DB using its PK
//		System.out.println("Retrieving student with id: " + myStudent.getId());
//		Student student = session.get(Student.class, myStudent.getId());
//		System.out.println("Student successfully retrieved: " + student);
//		
//		// commit the transaction
//		session.getTransaction().commit();
		
			//----------------------------------------------------------------------------
			
			// Query for all students 
//			System.out.println("Retrieving all students");
//			List<Student> students = session.createQuery("from Student").getResultList();
//			displayStudents(students);
//			
//			System.out.println("Retrieving all students with last name 'Singleton'");
//			students = session.createQuery("from Student s where s.lastName = 'Singleton'").getResultList();
//			
//			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
		//----------------------------------------------------------------------------
	
	}

	private static void displayStudents(List<Student> students) {
		for(Student student: students) {
			System.out.println(student);
		}
	}
}
