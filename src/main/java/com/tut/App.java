package com.tut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        SessionFactory factory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();
        System.out.println(factory.isClosed());
        // creating student 
         Student st = new Student();
         st.setId(101);
         st.setName("john");
         st.setCity("mumbai");
         System.out.println(st);
         
               
      // creating obj of address
         Address ad = new Address();
         ad.setStreet("street 1");
         ad.setCity("Delhi");
         ad.setOpen(true);
         ad.setAddedDate(new Date());
         ad.setX(100.98);
      // reading image
         FileInputStream fis = new FileInputStream("src/main/java/dhiraj.jpg");
          byte[] data = new byte[fis.available()];
          ad.setImage(data);
         
         
     Session session =    factory.openSession();
     
   Transaction tx =  session.beginTransaction();
     session.save(st);
     session.save(ad);
     tx.commit();
        session.close();        
        }
    
}






