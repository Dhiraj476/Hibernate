package com.tut;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	
	public static void main(String[] args)
	{
		// get , load 
		Configuration cgf = new Configuration();
	cgf.configure("hibernate.config.xml");
	SessionFactory factory = cgf.buildSessionFactory();
	
	Session session = factory.openSession();
	
	//get-student:101
	        Student student=(Student)session.get(Student.class, 101);
	        System.out.println(student);
	
	
	        session.close();
			factory.close();
		
	}

}



