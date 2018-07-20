package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity		// Lets hibernate know that this calss is an entity to be mananged
@Table(name="STUDENTS")		// maps this class to the spciied DB table
@SequenceGenerator(name="stu_seq", sequenceName="student_seq", allocationSize=1) 	// designates the sequence that should be used to generate pks
public class Student {

	@Id		// designate this field as  mapping to a pk of the table
	@Column(name="id")		// maps the fireld to a spcified column name
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="stu_seq") 		// chooses a gerneration strategy and generator to generate pks
	private int id;

	@Column(name="first_name")
	private String firstname;

	@Column(name="last_name")
	private String lastname;

	@Column(name="email")
	private String email;
	
	public Student() {
		
	}

	public Student(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public Student(int id, String firstname, String lastname, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + "]";
	}
	
}
