package com.revature.drivers;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Student;

public class StudentDriver {

	public static void main (String[] args) {
		
		// Create sessionfactory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
	
		// Retrieve a session from the session factory
		Session session = factory.getCurrentSession();
		
		try {
			/*
			 * Create Student Demo
			 */
			// Create a Student object
//			System.out.println("Creating a new student object");
//			Student myStudent = new Student("Wezley", "Singleton", "ws@gmail.com");
//			
//			// Start a transaction
//			session.beginTransaction();
//			
//			//Save the student
//			System.out.println("Saving the studen to the database");
//			session.save(myStudent);
//			
//			// Commit the transaction
//			session.getTransaction().commit();
//			
//			System.out.println("Student successufully saved.");
//			
			//-----------------------------------------------------------------------------------
			
			/*
			 * HIBERNATE AND PRIMARY  KEYS
			 */
			
//			// create an array of students
//			System.out.println("Creating Students array");
//			Student[] students = {
//					new Student("Blake", "King", "bk@gmail.com"),
//					new Student("Steve", "Kingsly", "sk@gmail.com"),
//					new Student("Geneisis", "Bonds", "gb@gmail.com")
//			};
//			
//			// Start transaction
//			session.beginTransaction();
//			
//			// Save each student in the array to the db
//			System.out.println("Saving the students to the db");
//			for(Student student : students) {
//				session.save(student);
//			}
//			
//			// Commit the transaction
//			session.getTransaction().commit();
//			
//			System.out.println(students.length + " students saved to the DB");
			
			//-----------------------------------------------------------------------------------
			
			/*
			 * READ STUDENT DEMO
			 */
			
//			Student myStudent = new Student("Carolyn", "Rehm", "cr@gmail.com");
//			session.beginTransaction();
//			session.save(myStudent);
//			session.getTransaction().commit();
//			
//			// See that our student has an accessible id value
//			System.out.println("New student add with id: " + myStudent.getId());
//			
//			// Get a new session and begin a transaction
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// retrieve the student from the DB using its pk
//			System.out.println("Retrieving student with id: " + myStudent.getId());
//			
//			Student student = session.get(Student.class, myStudent.getId());
//			System.out.println("Student successfully retrieved: " + student.toString());
//			
//			// Commit the transaction
//			session.getTransaction().commit();
			
			//--------------------------------------------------------------------------
			
			/*
			 * READ STUDENT DEMO USING QUERY
			 */
			
			// Start a transaction
			session.beginTransaction();
			
			// Query for all students
			System.out.println("Retrieving all students");
			List<Student> students = session.createQuery("from Student").getResultList();
			
			displayStudents(students);
			
			//Query for students with last name singleton
			System.out.println("Retrieving all students with name singleton");
			
			students = session.createQuery("from Student s where s.lastname = 'Singleton'").getResultList();
			
			displayStudents(students);
			
			// Query for students with lastname 'Singleton' or first name 'Blake'
			

			System.out.println("Retrieving all students with lastname singleton or first name Blake");
			
			Query query = session.createQuery("from Student s where s.lastname = ? or s.firstname = ?");
			query.setParameter(0, "Singleton");
			query.setParameter(1, "Blake");
			
			students = query.getResultList();
			
			displayStudents(students);
			
			//-----------------------------------------------------------------------------------------------
			
			// Query for students where email ends with 'k@gmail.com'
			System.out.println("Retrieving students with email ending with 'k@gmail.com'");
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
