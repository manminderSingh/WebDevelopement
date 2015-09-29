package com.myneu.project.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.myneu.project.pojo.Payment;
public class PaymentDao {
	
	public void paymentStored (Payment payment){
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();
        // creating session object
        Session session = factory.openSession();
        // creating transaction object
        session.beginTransaction();
        
        session.save(payment);
     
        session.getTransaction().commit();
		session.close();
		factory.close();
        
		
		
		
	}
}