package com.revature;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Student;

public class Driver {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {

		// Create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // not required, Hibernate will look for this file automatically
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Retrieve the Session from the SessionFactory
		Session session = factory.getCurrentSession();

		try {

			//			/*
			//			 * CREATE STUDENT DEMO
			//			 */
			//			// Create a Student object
			//			System.out.println("Creating new student object...");
			//			Student student_1 = new Student("Wezley", "Singleton", "ws@gmail.com");
			//			
			//			// Start a transaction
			//			session.beginTransaction();
			//			
			//			// Save the Student
			//			System.out.println("Saving the student to the DB");
			//			session.save(student_1);
			//			
			//			// Commit the transaction
			//			session.getTransaction().commit();
			//			
			//			System.out.println("Student successfully saved!");

			//----------------------------------------------------------------------------------------------------------

			//			/*
			//			 * PRIMARY KEY DEMO
			//			 */
			//			// Create an array of students
			//			System.out.println("Creating students array");
			//			Student[] students = {
			//					new Student("Blake", "Kruppa", "bk@gmail.com"),
			//					new Student("Steven", "Kelsey", "sk@gmail.com"),
			//					new Student("Genesis", "Bonds", "gb@gmail.com")
			//			};
			//
			//			// Start a transaction
			//			session.beginTransaction();
			//
			//			// Save each student in the array
			//			System.out.println("Saving the students to the DB");
			//			for(Student student : students) {
			//				session.save(student);
			//			}
			//
			//			// Commit the transaction
			//			session.getTransaction().commit();
			//
			//			System.out.println(students.length + " students successfully saved!");

			//----------------------------------------------------------------------------------------------------------

			//			/*
			//			 * READ STUDENT DEMO
			//			 */
			//			// Add a new student to the DB
			//			Student student = new Student("David", "Fay", "df@gmail.com");
			//			session.beginTransaction();
			//			session.save(student);
			//			session.getTransaction().commit();
			//			
			//			// See that now our student has an accessible id value
			//			System.out.println("New student added with id " + student.getId());
			//			
			//			// Get a new session and begin transaction
			//			session = factory.getCurrentSession();
			//			session.beginTransaction();
			//			
			//			// Retrieve student from DB using PK
			//			System.out.println("\nRetrieving student with id: " + student.getId());
			//			Student myStudent = session.get(Student.class, student.getId()); // .get() will return null if there is no record with the given PK
			//			System.out.println("Student successfully retrieved: " + myStudent);

			//----------------------------------------------------------------------------------------------------------

			//			/*
			//			 * READ STUDENT DEMO (USING QUERY)
			//			 */
			//			// Start a transaction
			//			session.beginTransaction();
			//			
			//			// Query for all students
			//			System.out.println("\nRetrieving all students");
			//			// .list() is deprecated as of Hibernate 5.2, use .getResultList() instead
			//			//List<Student> students = session.createQuery("from Student").list();
			//			List<Student> students = session.createQuery("from Student").getResultList();
			//			displayStudents(students); // show Extract Method feature of Eclipse
			//			
			//			// Query for students with last name 'Singleton'
			//			System.out.println("\nRetrieving students with last name of 'Singleton'");
			//			students = session.createQuery("from Student s where s.lastName = 'Singleton'").getResultList();
			//			displayStudents(students);
			//			
			//			// Query for students with last name 'Singleton OR a first name 'Blake' using parameterized query
			//			System.out.println("\nRetrieving students with last name of 'Singleton' or first name 'Blake'");
			//			Query studentQuery = session.createQuery("from Student s where s.lastName = ? OR s.firstName = ?").getResultList();
			//			studentQuery.setString(0, "Singleton");
			//			studentQuery.setString(1, "Blake");
			//			students = studentQuery.list();
			//			displayStudents(students);
			//			
			//			// Query for students where email ends with 'k@gmail.com'
			//			System.out.println("\nRetrieving students with email ending with 'k@gmail.com'");
			//			students = session.createQuery("from Student s where s.email like '%k@gmail.com'").getResultList();
			//			displayStudents(students);
			//			
			//			// Commit the transaction
			//			session.getTransaction().commit();

			//----------------------------------------------------------------------------------------------------------

			//			/*
			//			 * CALLING NAMED NATIVE QUERIES
			//			 */
			//			// Being transaction
			//			session.beginTransaction();
			//			
			//			// Generate a Query from our session using the named query defined in the Student class
			//			List<Student> students = session.getNamedNativeQuery("findStudentByNameSQL").setParameter("first_name", "Wezley").getResultList();
			//			for(Object obj : students) {
			//				System.out.println(obj);
			//			}

			//----------------------------------------------------------------------------------------------------------

			//			/*
			//			 * CALLING NAMED QUERIES
			//			 */
			//			// Being transaction
			//			session.beginTransaction();
			//			
			//			// Generate a Query from our session using the named query defined in the Student class
			//			List<Student> students = session.getNamedQuery("findStudentByNameHQL").setParameter("first_name", "Wezley").getResultList();
			//			displayStudents(students);

			//----------------------------------------------------------------------------------------------------------

			//			/*
			//			 * READ STUDENT DEMO (USING CRITERIA)
			//			 * 
			//			 * Criteria is all about programmatic query creation. Instead of manually typing out HQL statements
			//			 * we can create our queries using objects. As of Hibernate 5, the Criteria API is deprecated and
			//			 * is replaced with an implementation of JPA's CriteriaQuery.
			//			 */
			//			// Start a transaction
			//			session.beginTransaction();
			//
			//			// Create CriteriaBuilder to build CriteriaQueries for us
			//			CriteriaBuilder builder = session.getCriteriaBuilder();
			//
			//			// Query for all students
			//			// SQL = SELECT * FROM STUDENTS
			//			// HQL = from Student
			//			System.out.println("\nRetrieving all students");
			//
			//			// Create CriteriaQuery Hibernate 5+
			//			CriteriaQuery<Student> critQuery = builder.createQuery(Student.class);
			//
			//			// Set the query "root"
			//			Root<Student> root = critQuery.from(Student.class);
			//
			//			// Run the SELECT statement
			//			critQuery.select(root);
			//
			//			// Create and execute a query using the CriteriaQuery we created
			//			List<Student> students = session.createQuery(critQuery).getResultList();
			//			displayStudents(students);
			//
			//			// Query for student with email equal to "ws@gmail.com"
			//			// SQL = SELECT * FROM students WHERE email = "ws@gmail.com"
			//			// HQL = from Student s where s.email = "ws@gmail.com"
			//			String column = "email";
			//			String queryValue = "ws@gmail.com";
			//
			//			CriteriaQuery<Student> criteria = builder.createQuery(Student.class );
			//			Root<Student> studentRoot = criteria.from(Student.class );
			//			criteria.select( studentRoot );
			//			criteria.where(
			//					builder.equal(
			//							studentRoot.get(column), queryValue));
			//
			//			students = session.createQuery(criteria).getResultList();
			//			displayStudents(students);
			//
			//			// Commit the transaction
			//			session.getTransaction().commit();

			//----------------------------------------------------------------------------------------------------------

			//			/*
			//			 * UPDATE STUDENTS DEMO
			//			 */
			//			// Begin transaction
			//			session.beginTransaction();
			//			
			//			// Set some variable that has a value equal to some primary key in the DB
			//			int studentId = 14;
			//			
			//			// Retrieve the object with the specified ID
			//			Student myStudent = session.get(Student.class, studentId);
			//			
			//			// Update first name to 'August'
			//			myStudent.setFirstName("August");
			//			
			//			// Update last name to 'Duet'
			//			myStudent.setLastName("Duet");
			//			
			//			// Commit the transaction
			//			session.getTransaction().commit();
			//			
			//			/*
			//			 * We are able to update this object simply by changing the values of the fields we wish to
			//			 * update. This is possible because the 'myStudent' object is in the persistent state when
			//			 * it is retrieved from the DB. It remains persistent until we either detach it ourselves
			//			 * or its associated session is closed.
			//			 */
			//			
			//			// Retrieve current session and begin transaction
			//			session = factory.getCurrentSession();
			//			session.beginTransaction();
			//			
			//			// Update the email for the newly updated student - using .createQuery()
			//			session.createQuery("update Student s set s.email = 'ad@gmail.com' where s.firstName = 'August'").executeUpdate();
			//
			//			// Commit the transaction
			//			session.getTransaction().commit();

			//----------------------------------------------------------------------------------------------------------

			//			/*
			//			 * DELETE STUDENT DEMO
			//			 */
			//			// Begin transaction
			//			session.beginTransaction();
			//
			//			// Set a variable that has a value equal to some primary key in the DB
			//			int studentId = 7;
			//
			//			// Retrieve student based on id
			//			System.out.println("\nRetrieving student with id: " + studentId);
			//			Student myStudent = session.get(Student.class,  studentId);
			//
			//			// Delete the student
			//			System.out.println("Deleting student: " + myStudent);
			//			//session.delete(myStudent);
			//
			//			// Commit the transaction
			//			session.getTransaction().commit();
			//
			//			// Alternative method of deleting - using .createQuery()
			//			session = factory.getCurrentSession();
			//			session.beginTransaction();
			//
			//			// Set some variable that has a value equal to some primary key in the DB
			//			studentId = 5;
			//
			//			// Delete the student
			//			System.out.println("Deleting student with id of: " + studentId);
			//			session.createQuery("delete from Student s where s.id = 5").executeUpdate();
			//			
			//			// Commit the transaction
			//			session.getTransaction().commit();

		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
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
