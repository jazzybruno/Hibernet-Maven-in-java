package rw.ac.rca.smis.starter;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import rw.ac.rca.smis.admin_entities.*;

import javax.persistence.Id;

public class ExecutionApp {
    public static void main(String args[]){

        //the provinces
        Province province1 = new Province("Eastern" , 7);
        Province province2 = new Province("Northern" , 5);
        Province province3 = new Province("Southern" , 8);
        Province province4 = new Province("Western" , 7);
        Province province5 = new Province("Kigali" , 3);

        //the districts
        District district1 = new District(province1 , "Bugesera" , 15);
        District district2 = new District(province2 , "Musanze" , 15);
        District district3 = new District(province3 , "Huye" , 15);
        District district4 = new District(province4 , "Rubavu" , 15);
        District district5 = new District(province5 , "Gasabo" , 15);

        //the sectors
        Sector sector1 = new Sector(province1 , district1 , "Nyamata" , 20);
        Sector sector2 = new Sector(province2 , district2 , "Buriza" , 20);
        Sector sector3 = new Sector(province3 , district3 , "Tumba" , 20);
        Sector sector4 = new Sector(province4 , district4 , "Gisenyi" , 20);
        Sector sector5 = new Sector(province5 , district5 , "Masoro" , 20);

        //the cells
        Cell cell1 = new Cell(sector1 , district1, province1 , "Nyamataville1" , 30);
        Cell cell2 = new Cell(sector2 , district2, province2 , "Burizaville1" , 30);
        Cell cell3 = new Cell(sector3 , district3, province3 , "Tumbaville1" , 30);
        Cell cell4 = new Cell(sector4, district4, province4 , "gisenyiville1" , 30);
        Cell cell5 = new Cell(sector5 , district5, province5 , "masoroville1" , 30);

        //the villages
        Village village1 = new Village(cell1,sector1,district1,province1,"bugeseraville1");
        Village village2 = new Village(cell2,sector2,district2,province2,"musanzeville1");
        Village village3 = new Village(cell3,sector3,district3,province3,"huyeville1");
        Village village4 = new Village(cell4,sector4,district4,province4,"rubavuville1");
        Village village5 = new Village(cell5,sector5,district5,province5,"gasaboville1");

        //the configuration file
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        System.out.println("The configuration file .............");

        try{
            @SuppressWarnings("deprecated")
            SessionFactory factory = config.buildSessionFactory();
            Session session = factory.openSession();
            System.out.println("Finished opening the session................");

            Transaction transaction = session.beginTransaction();
            System.out.println("Transaction begun.........");

            session.saveOrUpdate(province1);
            session.saveOrUpdate(province2);
            session.saveOrUpdate(province3);
            session.saveOrUpdate(province4);
            session.saveOrUpdate(province5);

            session.saveOrUpdate(district1);
            session.saveOrUpdate(district2);
            session.saveOrUpdate(district3);
            session.saveOrUpdate(district4);
            session.saveOrUpdate(district5);

            session.saveOrUpdate(sector1);
            session.saveOrUpdate(sector2);
            session.saveOrUpdate(sector3);
            session.saveOrUpdate(sector4);
            session.saveOrUpdate(sector5);

            session.saveOrUpdate(cell1);
            session.saveOrUpdate(cell2);
            session.saveOrUpdate(cell3);
            session.saveOrUpdate(cell4);
            session.saveOrUpdate(cell5);

            session.saveOrUpdate(village1);
            session.saveOrUpdate(village2);
            session.saveOrUpdate(village3);
            session.saveOrUpdate(village4);
            session.saveOrUpdate(village5);

            System.out.println("Finished saving the data..........");

            transaction.commit();
            System.out.println("Finished committing the transaction...........");
            session.close();
            factory.close();
            System.out.println("Closed the factory and session.........");

        }catch (HibernateException e){
            e.printStackTrace();
        }
    }
}
