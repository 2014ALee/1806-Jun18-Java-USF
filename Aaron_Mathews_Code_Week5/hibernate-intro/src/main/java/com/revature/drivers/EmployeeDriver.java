package com.revature.drivers;

import java.util.Date;

import org.hibernate.Session;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDriver {
	
	public static void main(String[] args) {
		//Create transient Employee object
		Employee emp = new Employee();
		emp.setName("Wezley");
		emp.setRole("Developer");
		emp.setInsertTime(new Date());
		
		//Establish a session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		//Start transaction
		session.beginTransaction();
		
		//Save the emp to the db
		session.save(emp);
		
		//Commit
		session.getTransaction().commit();
		
		//Since the object is saved to the db and was in the persisted state, it has the id from the db now
		System.out.println("New employee added with id: " + emp.getId());
		
		//Close session factory
		HibernateUtil.getSessionFactory().close();
	}

}
