package com.myneu.project.Dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.myneu.project.pojo.Contactus;
import com.myneu.project.pojo.Product;
public class CustomerDao {
	
	public List<Product> existingProducts(int a){
		
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();
        // creating session object
        Session session = factory.openSession();
        Query query;
        // creating transaction object
        Transaction t = session.beginTransaction();
	
        query = session.createQuery("from ProductAddToCart where customerId = '" + a + "'");
	
		List<Product> product =(List<Product>) query.list();
        
       /* session.save(product);*/
	
        session.getTransaction().commit();
		session.close();
		factory.close();
        return product;
	}
	
	public void addContactus(Contactus contactUs){
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();
        // creating session object
        Session session = factory.openSession();
        // creating transaction object
        session.beginTransaction();
        
        session.save(contactUs);
     
        session.getTransaction().commit();
		session.close();
		factory.close();
        
		
	}
}