package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sf;
	
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactry using the hibernate.cfg.xml
			Configuration config = new Configuration();
			// With no arguments, looks for hibernate.cfg.xml
			config.configure("hibernate.cfg.xml");
			
			return config.buildSessionFactory();
		} catch(Throwable t) {
			t.printStackTrace();
			throw new ExceptionInInitializerError();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return (sf == null) ? sf = buildSessionFactory() : sf;
	}

}
