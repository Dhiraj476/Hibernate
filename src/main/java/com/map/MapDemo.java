package com.map;
import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args)
	{
		 SessionFactory factory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();
		//creating ans
			Answer answer = new Answer();
			answer.setAnswerId(344);
			answer.setAnswer("it is prog lang");
			
			Answer answer1 = new Answer();
			answer1.setAnswerId(345);
			answer1.setAnswer("it is platform independent lang");
			Answer answer2 = new Answer();
			answer2.setAnswerId(346);
			answer2.setAnswer("it is popular lang");
			List<Answer> answers = new ArrayList<Answer>();
			answers.add(answer);
			answers.add(answer1);
			answers.add(answer2);
			
			
			
			
		 
		 // creating Question
		Question q1 = new Question();
		q1.setQuestionId(101);
		q1.setQuestion("what is java");
		q1.setAnswers(answers);
		answer.setQuestion(q1);
		answer1.setQuestion(q1);
		answer2.setQuestion(q1);
		// setting bidirectional one to one mapping 
		
		
		
		
		 
		// creating Question
//				 Question q2 = new Question();
//				 q2.setQuestionId(1213);
//				 q2.setQuestion("what is spring");
//				 
//				 // creating answer 
//				 Answer answer1 = new Answer();
//				 answer1.setAnswerId(344);
//				 answer1.setAnswer("it is java framework");
//				 q2.setAnswer(answer1);
		 // session 
		
	
		 
		 Session s = factory.openSession();
		 Transaction tx = s.beginTransaction();
			
//		 s.save(q1);
//	     s.save(answer);
//		s.save(answer1);
//		s.save(answer2);
		 
		
		Question q = (Question)s.get(Question.class, 101);
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		// lazy loading 
		//System.out.println(q.getAnswers().size());
		
		 
		 tx.commit();
		 
		
		 s.close();
		 factory.close();
	}

}
