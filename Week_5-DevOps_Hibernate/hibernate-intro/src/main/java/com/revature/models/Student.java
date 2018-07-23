package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * Named Queries
 * 
 * 	- Can be configured using XML or annotations
*/
// Named Queries = HQL
@NamedQueries({
	@NamedQuery(
			name="findStudentByIdHQL",
			query="from Student s where s.id = :id"
			),
	@NamedQuery(
			name="findStudentByNameHQL",
			query="from Student s where s.firstName like :first_name"
			)
})
// Named Native Queries = SQL
@NamedNativeQueries({
	@NamedNativeQuery(
			name="findStudentByIdSQL",
			query="select * from students where id = :id",
			resultClass=Student.class
			),
	@NamedNativeQuery(
			name="findStudentByNameSQL",
			query="select * from students where first_name like :first_name",
			resultClass=Student.class
			)
})

@Entity 				// lets Hibernate know that this class is an entity that will be mapped to a table
@Table(name="Students")	// maps the class to a specified table
@SequenceGenerator(name="student_seq", sequenceName="student_seq", allocationSize=1) // designates the sequence that should be used to generate PKs
public class Student {

	@Id		// designates this field as mapping to the primary key of the table
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="student_seq") // chooses a generation strategy using the given sequence generator
	@Column(name="id") // maps the class to a specified column
	private int id;
	
	@Column(name="first_name")
	private String firstName; // name of the field does NOT have to match the column name 
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= {
			CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH
	})
	@JoinTable(
			name="course_student",
			joinColumns=@JoinColumn(name="student_id"),
			inverseJoinColumns=@JoinColumn(name="course_id")
			)
	List<Course> courses;
																																																																																
	public Student() { }

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Student(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
//	// Add convenience method
//	public void addStudentCourse(Course course) {
//		if(courses == null) {
//			courses = new ArrayList<>();
//		}
//		courses.add(course);
//	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}
