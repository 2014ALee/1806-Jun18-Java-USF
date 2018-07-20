package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


									// ANNOTATIONS
@Entity
@Table(name="STUDENTS")
@SequenceGenerator(name="stu_seq", sequenceName="student_seq", allocationSize=1)

public class Student {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="stu_seq")
	private int id;
	
	@Column(name="first_name")
	private String fn;
	
	@Column(name="last_name")
	private String ln;
	
	@Column(name="email")
	private String email;
	
	public Student() {}

	public Student(int id, String fn, String ln, String email) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.email = email;
	}

	public Student(String fn, String ln, String email) {
		super();
		this.fn = fn;
		this.ln = ln;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fn=" + fn + ", ln=" + ln + ", email=" + email + "]";
	}
	
	

}
