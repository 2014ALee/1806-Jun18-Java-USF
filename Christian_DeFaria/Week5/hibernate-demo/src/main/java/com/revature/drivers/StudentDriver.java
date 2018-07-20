package com.revature.drivers;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Student;

public class StudentDriver {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
//			System.out.println("Creating a new student object");
//			Student myStudent = new Student("Wezley", "Singleton", "wsingleton@gmail.com");
//			
//			session.beginTransaction();
//			
//			session.save(myStudent);
//			
//			session.getTransaction().commit();
//			
//			System.out.println("Student successfully saved!");
			
			//--------------------------------------------------------------------------------------------
			
//			System.out.println("Creating students array");
//			
//			Student[] students = {
//				new Student("Blake", "Kruppa", "bkruppa@gmail.com"),
//				new Student("Steve", "Kelsey", "skelsey@gmail.com"),
//				new Student("Genesis", "Bonds", "gbonds@gmail.com")
//			};
//			System.out.println("Saving students to the DB");
//			for(Student s : students) {
//				session.save(s);
//			}
//			
//			session.getTransaction().commit();
//			
//			System.out.println(students.length + " students added to the DB");
			
			//--------------------------------------------------------------------------------------------
			
//			Student myStudent = new Student("Carolyn", "Rehm", "crehm@gmail.com");
//			session.beginTransaction();
//			session.save(myStudent);
//			session.getTransaction().commit();
//			
//			System.out.println("New student added with ID of " + myStudent.getId());
//			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			System.out.println("Retrieving student with ID: " + myStudent.getId());
//			
//			Student student = session.get(Student.class, myStudent.getId());
//			System.out.println("Student successfully retrieved: " + student);
//			
//			session.getTransaction().commit();
			
			//--------------------------------------------------------------------------------------------
			
			session.beginTransaction();
			
			System.out.println("Retrieving all students");
			@SuppressWarnings("unchecked")
			List<Student> students = session.createQuery("from Student").getResultList();
			displayStudents(students);
			
			System.out.println("Retrieving students with the last name Singleton");
			students = session.createQuery("from Student s where s.lastName = 'Singleton'").getResultList();
			displayStudents(students);
			
			System.out.println("Retrieving students with the last name Singleton or first name Blake");
			Query q = session.createQuery("from Student s where s.lastName = ? OR s.firstName=?");
			q.setParameter(0, "Singleton");
			q.setParameter(1, "Blake");
			students = q.getResultList();
			displayStudents(students);
			
			System.out.println("Retrieving student with email ending with k@gmail.com");
			students = session.createQuery("from Student s where s.email like '%k%@gmail.com'").getResultList();
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
			System.out.println(s);
		}
	}

}
