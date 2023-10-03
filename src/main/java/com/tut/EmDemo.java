package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	
	public static void main(String args[])
	{
		 SessionFactory factory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();
		 Student student1 = new Student();
		 student1.setId(202);
		 student1.setCity("mumbai");
		 student1.setName("Prakash");
		 
		 Certificate certi = new Certificate();
		 certi.setCourse("android");
		 certi.setDuration("2 months");
		 student1.setCerti(certi);
		Session s = factory.openSession() ;
		Transaction tx = s.beginTransaction();
		//obj save
		s.save(student1);
		
		tx.commit();
;
		s.close();
		 factory.close();
		 
	}

}
