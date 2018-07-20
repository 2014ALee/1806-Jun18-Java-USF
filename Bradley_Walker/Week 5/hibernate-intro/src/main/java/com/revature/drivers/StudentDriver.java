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
		// Don't need to specify configuration file.
		// The configure method looks for hibernate.cfg.xml
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		// Retrieve a session from the session factory
		Session session = factory.getCurrentSession();
		
		try {
			// Create a student
//			System.out.println("Creating a new student object");
//			Student stu = new Student("Bradley", "Walker", "bwalker@revature.com");
//			
//			// Start the transaction
//			session.beginTransaction();
//			
//			// Save the student
//			session.save(stu);
//			
//			// Commit
//			session.getTransaction().commit();
//			
//			System.out.println("Student successfully saved");
//			System.out.println("===================================================");
			
			/*
			 * Hibernate and primary keys
			 */
			// Create an array of student
//			System.out.println("Creating array");
//			Student[] students = {
//				new Student("Bradley", "Walker", "bwalker@revature.com"),
//				new Student("Wezley", "Singleton", "wsingleton@revature.com"),
//				new Student("Lamine", "Kaba", "lkaba@revature.com")
//			};
//			
//			// Start transaction
//			session.beginTransaction();
//			
//			// Save each student in array to DB
//			System.out.println("Saving students");
//			for(Student s : students) {
//				session.save(s);
//			}
//			
//			// Commit
//			session.getTransaction().commit();
//			
//			System.out.println(students.length + " students saved to the DB");
			
			/*
			 * Reading data from the DB
			 */
//			Student s = new Student("Carolyn", "Rehm", "cr@gmail.com");
//			session.beginTransaction();
//			session.save(s);
//			session.getTransaction().commit();
//			
//			// See that our student has an accessible id
//			System.out.println("New student added with id: " + s.getId());
//			
//			// Get a new session and begin another transaction
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// Retrieve the student from the DB using PK
//			System.out.println("Getting student with id " + s.getId());
//			Student s2 = session.get(Student.class, s.getId());
//			System.out.println("Stident successfully retrieved: " + s2.toString());
//			
//			// Close the transaction
//			session.getTransaction().commit();
			
			/*
			 * Read student using query
			 */
			session.beginTransaction();
			
			// Query for all students
			System.out.println("Retrieving all students");
			List<Student> students = session.createQuery("from Student").getResultList();
			displayStudents(students);
			
			
			// Query for studet with last name singleton
			System.out.println("Getting singletons");
			students = session.createQuery("from Student s where s.lastName = 'Singleton'").getResultList();
			displayStudents(students);
			
			// Query for singletons or lamines
			System.out.println("Getting singletons and lamines");
			Query q = session.createQuery("from Student s where s.lastName = 'Singleton' OR s.firstName=?");

			q.setParameter(0, "Lamine");
			students = q.getResultList();
			displayStudents(students);
			
			// Query for students where email ends with "@gmail.com"
			System.out.println("getting gmail students");
			students = session.createQuery("from Student s where s.email like '%@gmail.com'").getResultList();
			displayStudents(students);
			
			session.getTransaction().commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for(Student s : students) {
			System.out.println(s.toString());
		}
	}

}
