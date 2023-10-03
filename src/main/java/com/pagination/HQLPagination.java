package com.pagination;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLPagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		
		  SessionFactory factory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();
			 
			 		Session s = factory.openSession();
		
		
		Query query = s.createQuery("from Student");
		
		// implementin pagination using hibernate 
		query.setFirstResult(0);
		query.setMaxResults(3);
	List<Student> list =	query.list();
		for(Student st:list)
		{
			System.out.println(st.getId()+":"+st.getName()+":"+st.getCity());
		}
		s.close();
		
		
		factory.close();
		
		
	}

}
