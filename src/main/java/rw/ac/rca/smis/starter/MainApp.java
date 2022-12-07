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
     Student student1 = new Student();
     Student student2 = new Student();
     Course course1 = new Course("Biology" , 12 , 120);
     Course course2 = new Course("Chemistry" , 10 , 100);
     Instructor instructor1 = new Instructor();
     Instructor instructor2 = new Instructor();

     //the first instructor
     instructor1.setAddress(address1);
     instructor1.setDob(new Date(1980 , 06 , 16));
     instructor1.setPhoneNumber("0788671071");
     instructor1.setGender('M');
     instructor1.setName("Jazzy Bruno");

     //the second instructor
     instructor1.setAddress(address2);
     instructor1.setDob(new Date(1950 , 05 , 16));
     instructor1.setPhoneNumber("0788099764");
     instructor1.setGender('F');
     instructor1.setName("Joice Mary");

     //the first student
     student1.setAddress(address1);
     student1.setDob(new Date(2005 , 05 , 16));
     student1.setName("Ganza Vivens");
     student1.setPhoneNumber("0798980764");

     //the second students
     student1.setAddress(address2);
     student1.setDob(new Date(2007 , 05 , 16));
     student1.setName("Gwiza Rolande");
     student1.setPhoneNumber("0798985664");

     course1.setStudent(student1);
     course1.setStudent(student2);

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
