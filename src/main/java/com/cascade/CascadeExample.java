package com.cascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CascadeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SessionFactory factory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();
		 Session s = factory.openSession();
		 
		 
		 
		 s.close();
		 factory.close();
		 
	}

}
