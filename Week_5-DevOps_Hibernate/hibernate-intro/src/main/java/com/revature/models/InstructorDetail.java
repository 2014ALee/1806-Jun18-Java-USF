package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INSTRUCTOR_DETAILS")
@SequenceGenerator(name="instruct_detail_seq", sequenceName="instructor_detail_seq", allocationSize=1)
public class InstructorDetail {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="instruct_detail_seq")
	private int id;
	
	@Column(name="focus")
	private String focus;
	
	@Column(name="hobby")
	private String hobby;
	
	/* 
	 * Including a one-to-one mapping here establishes a bi-directional relationship to our Instructor class.
	 * 
	 * "mappedBy" tells Hibernate:
	 * 		- look at the instructorDetail property in the Instructor class
	 * 		- use that information from Instructor class @JoinColumn to help find the associated instructor
	 */
	@OneToOne(mappedBy="instructorDetail", cascade=CascadeType.ALL) 
	private Instructor instructor;
	
	public InstructorDetail() { }

	public InstructorDetail(String focus, String hobby) {
		super();
		this.focus = focus;
		this.hobby = hobby;
	}

	public InstructorDetail(int id, String focus, String hobby) {
		super();
		this.id = id;
		this.focus = focus;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", focus=" + focus + ", hobby=" + hobby + "]";
	}
	
}
