package com.sql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.Student;

public class SQLExample {
	
	public static void main(String[] args) {
	//	SessionFactory factory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();
		 SessionFactory factory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();
		 
		Session s = factory.openSession();
		// sql query
		String Q = "select * from student ";
		NativeQuery createSQLQuery =s.createSQLQuery(Q);
		List<Object []> list =createSQLQuery.list();
		for(Object[] st:list)
		{
			System.out.println(Arrays.toString(st));
		}
		
		s.close();
		factory.close();
	}

}
