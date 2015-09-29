package com.myneu.project.Dao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.myneu.project.pojo.Order;
import com.myneu.project.pojo.OrderTemp;
import com.myneu.project.pojo.Product;
import com.myneu.project.pojo.ProductAddToCart;
public class OrderDao {
	List<Product> productList;
	int i = 0;
	ArrayList<List<Product>> prodList = new ArrayList<List<Product>>();
	public  ArrayList<List<Product>> placeOrder(int productId, int [] a){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		Query query;
	
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		
		if(a.length!=0){
			
		
		
	query = session.createQuery("from Product where productId = '" + productId + "'");
		System.out.print("hello "+query.list());
	prodList.add(query.list());
		
		
		System.out.println("The value in " + prodList.indexOf(i));
	i++;
		
		}
		t.commit();
		session.close();
		return prodList;
	
}
	
	
	public ArrayList<List<Product>> OrderedProd(int a){
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        ArrayList<List<Product>> lpo = new ArrayList<List<Product>>();
        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();
        // creating session object
        Session session = factory.openSession();
        Query query;
        // creating transaction object
        Transaction t = session.beginTransaction();
	
        query = session.createQuery("from Product where productId = '" + a + "'");
		System.out.print("hello "+query.list());
		List<Product>po = query.list();
        lpo.add(po);
		
       /* session.save(product);*/
	
        session.getTransaction().commit();
		session.close();
		factory.close();
        return lpo;
		
		
	}
	
	public ProductAddToCart addProductTemp (ProductAddToCart product){
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
	
	public List<ProductAddToCart> lookUp (int a){
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        ArrayList<List<Product>> lpo = new ArrayList<List<Product>>();
        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();
        // creating session object
        Session session = factory.openSession();
        Query query;
        // creating transaction object
        Transaction t = session.beginTransaction();
	
        query = session.createQuery("from ProductAddToCart where Id = '" + a + "'");
	
		List<ProductAddToCart> po = (List<ProductAddToCart>)query.list();
      
		
       /* session.save(product);*/
	
        session.getTransaction().commit();
		session.close();
		factory.close();
        return po;
		
	}
	
	public Product lookUpProductID(int a){
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        ArrayList<List<Product>> lpo = new ArrayList<List<Product>>();
        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();
        // creating session object
        Session session = factory.openSession();
        Query query;
        // creating transaction object
        Transaction t = session.beginTransaction();
	
        query = session.createQuery("from Product where ProductId = '" + a + "'");
	
		Product po = (Product)query.list().get(0);
      
		
       /* session.save(product);*/
	
        session.getTransaction().commit();
		session.close();
		factory.close();
        return po;
		
	}
	
	public Order addOrder (Order o1){
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();
        // creating session object
        Session session = factory.openSession();
        // creating transaction object
        session.beginTransaction();
        
        session.save(o1);
     
        session.getTransaction().commit();
		session.close();
		factory.close();
        return o1;
		
		
	}
	
	public int lookUpOrderID (int o1){
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
        
        query = session.createQuery("from Order where OrderId = '" + o1 + "'");
     
        Order order =(Order) query.list().get(0);
        session.getTransaction().commit();
		session.close();
		factory.close();
        return o1;
		
		
	}
	public OrderTemp addOrderTemp (OrderTemp o1){
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();
        // creating session object
        Session session = factory.openSession();
        // creating transaction object
        session.beginTransaction();
        
        session.save(o1);
     
        session.getTransaction().commit();
		session.close();
		factory.close();
        return o1;
		
}
}