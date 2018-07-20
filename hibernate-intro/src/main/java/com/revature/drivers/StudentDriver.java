package com.revature.drivers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Student;

public class StudentDriver {


	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		

		try {
			/*
			
			Student[] students = {
					new Student("Blake","Kruppa","bk@gmail.com"),
					new Student("Steven","Kruppa","bk@gmail.com"),
					new Student("Genesis","Kruppa","bk@gmail.com")
			};

			session.beginTransaction();
			
			for(int i = 0; i<students.length; i++) {
				session.save(students[i]);
			}
			
			session.getTransaction().commit();
			 
		
		Student myStudent = new Student("Dave", "Fay", "df@gmail.com");
		session.beginTransaction();
		session.save(myStudent);

		session.getTransaction().commit();
		System.out.println("Student saved!");
			

		session = factory.getCurrentSession();
		session.beginTransaction();
		Student student = session.get(Student.class, myStudent.getId());
		System.out.println(student);
		
		session.getTransaction().commit();
		*/
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<Student> students =session.createQuery("from Student").getResultList();
			
			displayStudents(students);
			
			session.getTransaction().commit();
			
		students = session.createQuery("from Student s where s.lastName = 'Singleton'").getResultList();
			displayStudents(students);
			
			
			session.getTransaction().commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			factory.close();
		}

		
		System.out.println("creating students array");

	
	}

	private static void displayStudents(List<Student> students) {
		for(Student student : students) {
			System.out.println(student);
		}
	}
	

}
	

