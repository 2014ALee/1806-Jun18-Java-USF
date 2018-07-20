package com.revature.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory buildSessionFactory() {
        try {
            
            // Create the SessionFactory using the hibernate.cfg.xml file
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml"); // not required if you kept the default config file name (Hibernate looks for it automatically)
            return config.buildSessionFactory();
            
        } catch (Throwable t) {
            t.printStackTrace();
            throw new ExceptionInInitializerError(t);
        }
    }
//	private static SessionFactory buildSessionFactory() {
//		try {
//			Configuration config = new Configuration();
//			config.configure("hibernate.cfg.xml"); 
//			//put a file name in the config.configure() or else it will look for hibernate.cfg.xml
//			
//			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
//			
//			return config.buildSessionFactory(serviceRegistry);
//			
//		}catch(Throwable t) {
//			t.printStackTrace();
//			throw new ExceptionInInitializerError(t);
//		}
//	}
//	public static SessionFactory getSessionFactory() {
//		if(sessionFactory == null) {
//			sessionFactory = buildSessionFactory();
//		}
//		return sessionFactory;
//	}
}
