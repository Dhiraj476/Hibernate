package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();
		
		// employees 
		
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		e1.setEid(34);
		e1.setName("Ram");
		e2.setEid(35);
		e2.setName("Shyam");
	
		
		
		// projects 
		Project p1 = new Project();
		Project p2 = new Project();
		p1.setPid(12121);
		p1.setProjectname("Library mgmt sys");
		p2.setPid(1324);
		p2.setProjectname("chatbot");
		
		List<Emp> list1 = new ArrayList<Emp>();
		List<Project> list2 = new ArrayList<Project>();
		list1.add(e1);
		list1.add(e2);
		list2.add(p2);
		list2.add(p1);
		
		p1.setEmps(list1);
		p2.setEmps(list1);
		e1.setProjects(list2);
		e2.setProjects(list2);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(e1);
		s.save(e2);
		s.save(p1);
		s.save(p2);
		tx.commit();
		s.close();
		
		 factory.close();

	}

}
