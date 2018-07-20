package com.revature.drivers;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Student;

public class StudentDriver {

	public static void main(String[] args) {

		// create session factory 
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		// Retrieve a session from the session factory
		Session session = factory.getCurrentSession();
//		
//		try {
//			// CREATE STUDENT DEMO
//			// this would go into dao method
//			
//			System.err.println("Creating a new student object...");
//			Student myStudent = new Student("John", "Beineke", "jbein@gmail.com");
//			
//			// Start transaction
//			session.beginTransaction();
//			
//			// Save transaction
//			session.save(myStudent);
//			
//			// commit transaction
//			session.getTransaction().commit();
//			
//			System.out.print("Student successfully saved!");
			
			// ---------------------------------------------------------------------------------------------
			
			
			
//		}catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		}finally {
//			factory.close();
//		}
		
//		// HIBERNATE & PRIMARY KEYS
//		
//		Student[] students = {
//				new Student("Blake", "Kruppa", "bk@gmail.com"),
//				new Student("Bill", "Krup", "bk@gmail.com"),
//				new Student("Bob", "Kra", "bk@gmail.com")
//		};
//		
//		// begin the transaction
//		session.beginTransaction();
//		
//		// Save the students in the array to the db
//		for (Student student : students)
//			session.save(student);
//		
//		// commit the transaction
//		session.getTransaction().commit();
		
//		//						READ STUDENT DEMO
//		// add a new student
//		Student myStudent = new Student("David", "Fay", "dfay@yahoo.mail");
//		session.beginTransaction();
//		session.save(myStudent);
//		session.getTransaction().commit();
//	
//		System.out.println("How student added with id: " + myStudent.getId());
//		
//		// get a new session and begin a transaction
//		session = factory.getCurrentSession();
//		session.beginTransaction();
//		
//		// retrieve
//		System.out.println("Retrieving");
//		Student student = session.get(Student.class, myStudent.getId());
//		System.out.println("Student successfully retrieved" + student.toString());
//		
//		// commit the transaction	
//		session.getTransaction().commit();
		
		//----------------------------------------------------------------------------------
		
		// 							READ STUDENT DEMO USING QUERY
		session.beginTransaction();
		
		// Query for all students
		System.out.println("Retrieving all students");
		// using HQL here to reference the student object.. it knows where to map to in database
		List<Student> students = session.createQuery("From Student").getResultList();
		
		displayStudents(students);
		
		// query for students with last name beineke
		students = session.createQuery("from Student s where s.ln = 'Beineke'").getResultList();
		displayStudents(students);
		
		// query for students with last name 'Beineke' or firstName 'blake'
		Query query = session.createQuery("from Student s where s.ln OR s.fn = ?");
		query.setParameter(0, "Beineke");
		query.setParameter(1, "Blake");
		
		
		
		
		
		
		
		
	}

	private static void displayStudents(List<Student> students) {
		for(Student student : students) {
			System.out.println(student);
		}
	}

}
