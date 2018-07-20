package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Course;
import com.revature.models.Instructor;
import com.revature.models.InstructorDetail;
import com.revature.models.Student;

public class ManyToManyDriver {

	public static void main(String[] args) {

		// Create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // not required, Hibernate will look for this file automatically
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// Retrieve the Session from the SessionFactory
		Session session = factory.getCurrentSession();
		
		try {
			// Start a transaction
			session.beginTransaction();
			
			// Create a course
			Course course = new Course("Angular 6 - Building Single Page Applications");
			
			// Save the course
			System.out.println("Saving the course: " + course);
			session.save(course);
			System.out.println("Course saved!");
			
			// Create students
			Student student1 = new Student("Christian", "Defaria", "cd@gmail.com");
			Student student2 = new Student("Derek", "Loisel", "dl@gmail.com");
			
			// Save the students
			System.out.println("Saving students...");
			session.save(student1);
			session.save(student2);
			System.out.println("Students successfully saved!");
			System.out.println(student1);
			System.out.println(student2);
			
			//------------------------------------------------
			
			// Re-establish session and transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Get a Student from the DB using PK
			int studentId = 23;
			Student student = session.get(Student.class, studentId);
			System.out.println("Student retrieved: " + student);
			
			// Get a Course from the DB using PK
			int courseId = 24;
			Course course = session.get(Course.class, courseId);
			System.out.println("Course retrieved: " + course);
			
			// Create more courses
			Course course2 = new Course("AJAX and Fetch API");
			Course course3 = new Course("Spring Framework");
			
			// Add student to courses
			course.addStudent(student);
			course2.addStudent(student);
			course3.addStudent(student);
			
			// Leave this commented out to discuss automatic dirty checking
//			session.save(course);
			
			// Save the other courses since they have never been persisted
			session.save(course2);
			session.save(course3);
			
			// Commit the transaction
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
