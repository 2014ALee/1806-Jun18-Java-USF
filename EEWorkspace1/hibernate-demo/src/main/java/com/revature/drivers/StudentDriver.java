package com.revature.drivers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Student;

public class StudentDriver {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
//			
//			Student myStudent = new Student("Algustus", "Lee", "AL@gmail.com");
//			
//			//Start transaction
//			session.beginTransaction();
//			
//			//save the student
//			session.save(myStudent);
//			
//			//commit the student
//			session.getTransaction().commit();
			
//			Student[] students = {
//					new Student("Blake", "Kruppa", "bk@gmail.com"),
//					new Student("Steven", "Kelsey", "sk@gmail.com"),
//					new Student("Genesis", "Bonds", "bg@gmail.com"),
//			};
//			session.beginTransaction();
//			session.save(students);
//			session.getTransaction().commit();
			
//			Student myStudent = new Student("David", "Fay", "df@gmail.com");
//			session.beginTransaction();
//			session.save(myStudent);
//			session.getTransaction().commit();
//			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			Student student = session.get(Student.class, myStudent.getId());
			
			session.beginTransaction();
			List<Student> students = session.createQuery("from Student s where s.lastName = 'Singleton'").getResultList();
			displayStudents(students);
			
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for(Student s:students) {
			System.out.println(s);
		}
	}
}
