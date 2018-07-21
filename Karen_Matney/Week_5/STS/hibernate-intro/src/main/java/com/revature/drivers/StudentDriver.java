package com.revature.drivers;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Student;

public class StudentDriver {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Create SessionFactory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		// Retrieve a Session from the SessionFactory
		Session session = factory.getCurrentSession();
		
		try {
			/*
			 * CREATE STUDENT DEMO
			 */
//			// Create a Student object
//			System.out.println("Creating a new student object...");
//			Student myStudent = new Student("Wezley", "Singleton", "ws@gmail.com");
//			
//			// Start a transaction
//			session.beginTransaction();
//			
//			// Save the student
//			System.out.println("Saving the student to the DB");
//			session.save(myStudent);
//			
//			// Commit the transaction
//			session.getTransaction().commit();
//			
//			System.out.println("Student successfully saved!");
			
			/*
			 * HIBERNATE & PRIMARY KEYS
			 */
//			// Create an array of students
//			System.out.println("Creating students array");
//			Student[] students = {
//					new Student("Blake","Kruppa","bk@gmail.com"),
//					new Student("Steven","Kelsey","sk@gmail.com"),
//					new Student("Genesis","Bonds","gb@gmail.com")
//			};
//			
//			// Start transaction
//			session.beginTransaction();
//			
//			// Save each studint the array to the DB
//			System.out.println("Saving the students to the DB");
//			for(Student student: students) {
//				session.save(student);
//			}
//			
//			// Commit the transaction
//			session.getTransaction().commit();
//			
//			System.out.println(students.length + " students saved to the DB");
			
			/*
			 * READ STUDENT DEMO
			 */
//			// Add a new Student to the DB
//			Student myStudent = new Student("Carolyn","Rehm","cr@gmail.com");
//			session.beginTransaction();
//			session.save(myStudent);
//			session.getTransaction().commit();
//			
//			// See that our student has an accessible id value
//			System.out.println("New student added with id: " + myStudent.getId());
//			
//			// Get a new session and begin a transaction
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// Retrieve the student from the dB using its PK
//			System.out.println("Retrieving student with id: " + myStudent.getId());
//			Student student = session.get(Student.class, myStudent.getId());
//			System.out.println("Student successfully retrieved: " + student);
//			
//			// Close the transaction
//			session.getTransaction().commit();
			
			/*
			 * READ STUDENT DEMO (USING QUERY)
			 */
			// Start a transaction
			session.beginTransaction();
			
			// Query for all students
			System.out.println("Retrieving all students");
			List<Student> students = session.createQuery("from Student").getResultList();
			
			displayStudents(students);
			
			// Query for all students with last name 'Singleton'
			System.out.println("Retrieving all students with last name 'Singleton'");
			students = session.createQuery("from Student s where s.lastName = 'Singleton'").getResultList();
	
			displayStudents(students);
			
			// Query for all students with last name 'Singleton' OR first name 'Blake'
			System.out.println("Retrieving all students with last name 'Singleton' OR first name 'Blake'");
			Query query = session.createQuery("from Student s where s.lastName = ? OR s.firstName = ?");

			query.setParameter(0, "Singleton");
			query.setParameter(1, "Blake");
			students = query.getResultList();
	
			displayStudents(students);
			
			// Query for students where email ends with 'k@gmail.com'
			System.out.println("Retrieveing students with email ending with 'k@gmail.com'");
			students = session.createQuery("from Student s where s.email like '%k@gmail.com'").getResultList();
			displayStudents(students);
			
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for(Student student : students) {
			System.out.println(student);
		}
	}
}
