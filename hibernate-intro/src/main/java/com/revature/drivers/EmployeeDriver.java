package com.revature.drivers;

import java.util.Date;

import org.hibernate.Session;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDriver {

	public static void main(String[] args) {
		Employee emp = new Employee();
	
		emp.setName("Tom");
		emp.setRole("Developer");
		emp.setInsertTime(new Date());
		
		
		Session session  = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
		session.save(emp);
		
		session.getTransaction().commit();
		
		System.out.println("new employee id is: " + emp.getId());
		
		HibernateUtil.getSessionFactory().close();
		
	}
	
}
