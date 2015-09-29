package com.myneu.project.Dao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.myneu.project.pojo.FinalProductsOrder;
import com.myneu.project.pojo.Product;
import com.myneu.project.pojo.ProductAddToCart;
public class ProductDao {
	
	
	public void addProduct (Product product){
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();
        // creating session object
        Session session = factory.openSession();
        // creating transaction object
        session.beginTransaction();
        
        session.save(product);
     
        session.getTransaction().commit();
		session.close();
		factory.close();
        
		
		
		
	}
	
	ArrayList<List<ProductAddToCart>> patc = new ArrayList<List<ProductAddToCart>>();
	public ArrayList<List<ProductAddToCart>> addProductToCart (int pID){
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();
        Query query;
        
        // creating session object
        Session session = factory.openSession();
        // creating transaction object
        session.beginTransaction();
    	query = session.createQuery("from ProductAddToCart where productId = '" + pID + "'");
        
    	patc.add(query.list());
    	
        session.getTransaction().commit();
		session.close();
		factory.close();
        
		return patc;
		
		
	}
	
	/*public void addFinal (Payment_order_customer poc){
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();
        // creating session object
        Session session = factory.openSession();
        // creating transaction object
        session.beginTransaction();
        
        session.save(poc);
     
        session.getTransaction().commit();
		session.close();
		factory.close();
        
		
		
		
	}*/
	
	public FinalProductsOrder addProductFinally (FinalProductsOrder product){
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();
        // creating session object
        Session session = factory.openSession();
        // creating transaction object
        session.beginTransaction();
        
        session.save(product);
     
        session.getTransaction().commit();
		session.close();
		factory.close();
        
		
		return product;
		
	}
	
	 public void updateProduct (int prodId, int quantity){
			Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");// populates the data of the
	                                            // configuration file
	        
	        // creating seession factory object
	        SessionFactory factory = cfg.buildSessionFactory();
	        // creating session object
	        Session session = factory.openSession();
	        Query query;
	        // creating transaction object
	        session.beginTransaction();
	        
	        
	    	query = session.createQuery("from Product where productId = '" + prodId + "'");
	        Product product = (Product) query.list().get(0);
	        product.setQuantity(quantity);
	        session.save(product);
	     
	        session.getTransaction().commit();
			session.close();
			factory.close();
	        
			
	    }
	
	
}