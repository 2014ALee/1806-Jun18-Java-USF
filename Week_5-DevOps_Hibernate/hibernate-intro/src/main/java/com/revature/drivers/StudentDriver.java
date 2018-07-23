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
		
		//create session factory
		//we are just going to create session factory here instead of util class but usually youd do it as a util class like we did for the xml its just a little diff then the xml sesison factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
	
		Session session = factory.getCurrentSession();
		
		try {
			
//			//this part would be in dao
			
			/*
			 * create student here
			 */
//			System.out.println("creating a new student object");
//			Student myStudent = new Student("Derek", "Loisel", "djloisel19@gmail.com");
//			
//			//start a transaction
//			session.beginTransaction();
//			
//			//save the student
//			System.out.println("saving the student");
//			session.save(myStudent);
//			
//			//commit the transaction
//			session.getTransaction().commit();
//			System.out.println("student successfully saved");
//			
			//----------------------------------------------------------------------------------------
			
			
			/*
			 * hibernate and primary keys
			 */
			//create an array of students
//			System.out.println("creating students array");
//			Student[] students = {
//					new Student("blake", "kruppa", "bk@gmail.com"),
//					new Student("steve", "kelsey", "sk@gmail.com"),
//					new Student("genesis", "bonds", "gb@gmail.com")
//			};
//			
//			//start transaction
//			session.beginTransaction();
//			
//			//save each student in the array to the db
//			for(Student student : students) {
//				session.save(student);
//				
//			}
//			//commit the transaction
//			session.getTransaction().commit();
//			System.out.println(students.length + " students added to the db");
			
			/*
			 * READ student demo //need to take out table triggers when dealing with annotations.  so disable triggers on sql tables
			 */
			//add new student to db
//			Student myStudent = new Student("David", "Fay", "df@gmail.com");
//			session.beginTransaction();
//			session.save(myStudent);
//			session.getTransaction().commit();
//			
//			//see that our student has an accessible id value
//			System.out.println("new student added with id: "+ myStudent.getId());
//			
//			//get a new session and begin a transaction //if you call .commit it ends session and you need new one
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			//retrieve the student from the db using its pk
//			System.out.println("retrieving student with id: "+ myStudent.getId());
//			Student student = session.get(Student.class,  myStudent.getId());
//			System.out.println("student successfully retrieved: "+ student);
//			
//			//commit the transaction
//			session.getTransaction().commit();
			
			//-----------------------------------------------------------------------------
			
			/*
			 * READ demo using QUERY
			 */
			//start transaction
			session.beginTransaction();
			
			//query for all students
			System.out.println("retrieving all students");
			List<Student> students = session.createQuery("from Student").getResultList(); //using hql
			
			displayStudents(students);
						
			
			
			
			//Query for students with last name loisel
			System.out.println("retrieving all students with ln loisel");
			students = session.createQuery("from Student s where s.lastName = 'Loisel'").getResultList();
			
			//query for students with last name loisel or first name blake
			System.out.println("retrieving all students with ln loisel or fn blake");
			Query query = session.createQuery("from Student s where s.lastName = ? OR s.firstName = ?");
			query.setParameter(0, "Loisel");
			query.setParameter(1, "blake");
			students = query.getResultList();
			displayStudents(students);
			
			
			//Query for students where email ends with 'k@gmail.com'
			System.out.println("retrieving students with emails ending with k@gmail.com");
			students = session.createQuery("from Student s where s.email like '%k@gmail.com'").getResultList();
			displayStudents(students);
			
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			factory.close(); //could use in try with resources since it probably has auto closable which is needed for try with resources
		}
	
	}

	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
