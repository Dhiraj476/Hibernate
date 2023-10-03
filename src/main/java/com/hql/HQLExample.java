package com.hql;

import java.util.Arrays;
import org.hibernate.query.*;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLExample {
	public static void main(String[] args) {
		  SessionFactory factory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();
		 
		  // HQL 
		  //Syntax
		  
		  String query = "from Student as s where s.city=:x and s.name=:n";
		  
		  Session s = factory.openSession();
		  
		 
		  Query q = s.createQuery(query);
		  q.setParameter("x", "mumbai");
		  q.setParameter("n", "mahesh");
		  //  single result
		  // multiple result 
	List<Student> list	 =  q.list();
		  
	 for(Student stud:list)
	 {
		 System.out.println(stud.getName()+" certification :" +stud.getCerti().getCourse() );
	 }
	 
	 Transaction tx = s.beginTransaction();
	 
		
	 System.out.println("_______________________________________");
//	 deleting student
//	 Query v = s.createQuery("delete from Student where city=:c");
//	  v.setParameter("c", "mumbai");
//	  int r = v.executeUpdate();
//	  System.out.println("deleted "+ r);
//	  tx.commit();

	 // updating student 
//	 Query v =s.createQuery("update Student set city=:c where name=:n");
//	 v.setParameter("c", "Satara");
//	 v.setParameter("n", "manoj");
//	 int k = v.executeUpdate();
//	 System.out.println(k + "objects updated");
//	 tx.commit();
	 
	 // join query 
	 
	 
	 Query v = s.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answers as a");
	  List<Object[] > list3 = v.getResultList();
	  for(Object[] arr:list3)
	  {
		  System.out.println(Arrays.toString(arr));
	  }
	  s.close();
		  factory.close();
	}
	
	
}
