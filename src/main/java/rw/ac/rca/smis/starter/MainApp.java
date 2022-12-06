package rw.ac.rca.smis.starter;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import rw.ac.rca.smis.orm.Address;
import rw.ac.rca.smis.orm.Course;
import rw.ac.rca.smis.orm.Instructor;
import rw.ac.rca.smis.orm.Student;

import java.util.Date;

public class MainApp {
 public static void main(String args[]){
     @SuppressWarnings(value = "unchecked")
     Address address1 = new Address("Nyabihu" , "KN4 St13");
     Address address2 = new Address("Kigali" , "KG3 St18");
     Student student1 = new Student("Jazzy Bruno" );
     Student student2 = new Student("Hello There");
     Course course1 = new Course("Biology" , 12 , 120);
     Course course2 = new Course("Chemistry" , 10 , 100);
     Instructor instructor1 = new Instructor("Professor2" , new Date(2000 , 12 , 23) , 'M');
     Instructor instructor2 = new Instructor("Professor5" , new Date(1995 , 2 , 12) , 'F');

     instructor1.setAddress(address1);
     instructor2.setAddress(address1);

     student1.setAddress(address1);
     student2.setAddress(address2);

     course1.setStudent(student1);
     course1.setStudent(student1);

     course1.setInstructor(instructor1);
     course2.setInstructor(instructor1);

     Configuration config = new Configuration();
     config.configure("hibernate.cfg.xml");
     System.out.println("config file loaded ..............");

     try {
         @SuppressWarnings("deprecation")
         SessionFactory factory = config.buildSessionFactory();
         Session session = factory.openSession();

         System.out.println("Beginning transaction...............");

         Transaction transaction = session.beginTransaction();

         session.saveOrUpdate(address1);
         session.saveOrUpdate(address2);

         session.saveOrUpdate(instructor1);
         session.saveOrUpdate(instructor2);

         session.saveOrUpdate(course1);
         session.saveOrUpdate(course2);

         session.saveOrUpdate(student1);
         session.saveOrUpdate(student2);

         System.out.println("Committing the transactions...............");

         transaction.commit();
         System.out.println("Before closing the session..........");

         session.close();
         factory.close();

         System.out.println("Finished closing the factory and session..........");
     } catch (HibernateException e) {
         e.printStackTrace();
     }
 }
}
