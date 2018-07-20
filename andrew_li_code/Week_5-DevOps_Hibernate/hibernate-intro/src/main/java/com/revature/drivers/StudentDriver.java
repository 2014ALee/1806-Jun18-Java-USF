package com.revature.drivers;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Student;

public class StudentDriver {

	public static void main(String[] args) {
		// Create SessionFactory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		// Retrive a Session from the SessionFactory
		Session session = factory.getCurrentSession();
		
		try {
			/*
			 * CREATE STUDENT DEMO
			 */
			// Create a student object
			// System.out.println("Creating a new student object...");
			// Student myStudent = new Student("Wezley", "Singleton", "ws@gmail.com");
			
			// Start a transaction
			// session.beginTransaction();
			
			// Save the student
			// System.out.println("Saving the student to the DB");
			// session.save(myStudent);
			
			// Commit the transaction
			// session.getTransaction().commit();
			
			// System.out.println("Student successfully saved!");
			//System.out.println("Creating students array");
			//Student[] students = {
			//		new Student("Blake", "Kruppa", "bk@gmail.com"),
			//		new Student("Steven", "Keilsey", "sk@gmail.com"),
			//		new Student("Genesis", "Bonds", "gb@gmail.com")
			//};
			//session.beginTransaction();
			
			//System.out.println("Saving the students to the DB");
			//for (Student student : students) {
			//	session.save(student);
			//}
			
			// Commit the transaction
			// session.getTransaction().commit();
			//Student myStudent = new Student("David", "Fay", "df@gmail.com");
			//session.beginTransaction();
			//session.save(myStudent);
			//session.getTransaction().commit();
			
			//System.out.println("New student added with id: " + myStudent.getId());
			
			//session = factory.getCurrentSession();
			//session.beginTransaction();
			
			// Retrieve the student from the DB using its PK.
			
			// System.out.println("Retrieving student with id: " + 13);
			// Student student = session.get(Student.class, 13);
			// System.out.println("Student successfully retrieved: " + student);
			
			// Commit the transaction
			// session.getTransaction().commit();
			session.beginTransaction();
			// Query for all students
			System.out.println("Retrieving all students");
			session.createQuery("from Student");
			System.out.println("Retriving all students with last name \'Singleton\'");
			List<Student> students = session.createQuery("from Student s where s.lastName = \'Singleton\'").getResultList();
			displayStudents(students);
			Query query = session.createQuery("from Student s where s.lastName = ? OR s.firstName = ?");
			query.setParameter(0, "Singleton");
			query.setParameter(1, "Blake");
			students = query.getResultList();
			displayStudents(students);
			
			// Query for students where email ends with 'k@gmail.com'
			System.out.println("Retrieving students with email ending with 'k@gmail.com'");
			students = session.createQuery("from Student s where s.email like '%k@mail.com'").getResultList();
			displayStudents(students);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	public static void displayStudents(List<Student> students) {
		for (Student st : students) {
			System.out.println(st);
		}
	}

}
