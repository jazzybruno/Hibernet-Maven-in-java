package rw.ac.rca.smis.starter;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import rw.ac.rca.smis.orm.ClassRoom;

import javax.persistence.Id;

public class Starter {
    public static void main(String args[]) {
        ClassRoom classRoom1 = new ClassRoom(30, "incredibles", "Rwanda Coding");
        ClassRoom classRoom2 = new ClassRoom(40, "marveleous", "Rwanda Coding");
        ClassRoom classRoom3 = new ClassRoom(25, "trendremous", "Rwanda Coding");

        Configuration config = new org.hibernate.cfg.Configuration();
        config.configure("hibernate.cfg.xml");
        System.out.println("The configuration files are loaded..............");

        try {
            @SuppressWarnings("deprecated")
            SessionFactory factory = config.buildSessionFactory();
            Session session = factory.openSession();
            System.out.println("Opened the session.................");

            Transaction transaction = session.beginTransaction();
            System.out.println("Transaction begun.............");

            session.saveOrUpdate(classRoom1);
            session.saveOrUpdate(classRoom2);
            session.saveOrUpdate(classRoom3);

            System.out.println("Finished saving the data..............");

            transaction.commit();

            System.out.println("Finished commiting the transactions...........");

            session.close();
            factory.close();

            System.out.println("Finished closing the session and factory..........");
        }catch (HibernateException e){
            e.printStackTrace();
        }

    }
}
