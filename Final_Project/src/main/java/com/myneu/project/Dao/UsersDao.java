package com.myneu.project.Dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.myneu.project.pojo.Product;
import com.myneu.project.pojo.Users;
    public class UsersDao {
	
	public String validate(String userName, String pass)
	{
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");  // populates the data of the
                                            // configuration file
        Users users = new Users();
        users.setUserName(userName);
        users.setPassword(pass);
        String temp  ;
	    SessionFactory factory = cfg.buildSessionFactory();
	
	    Session session = factory.openSession();
	
	    Transaction t = session.beginTransaction();
	
	    Query query = session.createQuery("from Users where userName ='"+userName+"' and password='"+pass+"'");
	    System.out.println("the value is query"+query);
	    
	    if(query.list().size() == 0){
	    	temp= "empty";
	    }
	    
	    else{
	    Users userAccount =  (Users)query.list().get(0);
	    
	    int flag=0;
	    
	    t.commit();
	    
	    if(userAccount.getUserRole().equals("Supplier")&& userAccount.getStatus().equals("Approved"))
	    {
	    	flag=1;
	    }
	    if(userAccount.getUserRole().equals("Supplier")&& userAccount.getStatus().equals("Pending"))
	    {
	    	flag=2;
	    }
	    if(userAccount.getUserRole().equals("Admin"))
	    {
	    	flag=3;
	    }
	    
	    session.close();
	    if (flag==0)
	    	return "Customer";
	    else if (flag==1)
	    	return "SupplierApproved";
	    else if (flag==2)
	    	return "SupplierPending";
	    else
	    	return "Admin";
     
	    }
	    return temp;
	}
	
	public void registerCustomer(Users users)
	{
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();
        // creating session object
        Session session = factory.openSession();
        // creating transaction object
        session.beginTransaction();
        
        session.save(users);
        
        session.getTransaction().commit();
		session.close();
		factory.close();
        
	}		
	
	public void registerSupplier(Users users)
	{
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();
        // creating session object
        Session session = factory.openSession();
        // creating transaction object
        session.beginTransaction();
        
        session.save(users);
        session.getTransaction().commit();
		session.close();
		factory.close();
        
	}		
	
	
	
	public Users checkUser(String userName, String password){
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");  // populates the data of the
                                            // configuration file
        Users users = new Users();
        users.setUserName(userName);
        users.setPassword(password);
        
	    SessionFactory factory = cfg.buildSessionFactory();
	
	    Session session = factory.openSession();
	
	    Transaction t = session.beginTransaction();
	
	    Query query = session.createQuery("from Users where userName ='"+userName+"' and password='"+password+"'");
	    System.out.println("the value is query"+query);
	    Users userAccount =  (Users)query.list().get(0);
	    
	    if(userAccount.getUserName().equals(userName)&& userAccount.getPassword().equals(password)){
	    	System.out.println("The user matches");
	    }
//	    if(userAccount.getUserRole().equals("Admin"))
	
	    return userAccount;
	    
	}
	
	public Product searchProduct(String productName){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Query query;
		Product product  = null;
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		
		if(productName == null || productName == "" || productName.isEmpty()){
			query = session.createQuery("from Product");
			product = (Product) query.list().get(0);
			t.commit();
			
			session.close();
			factory.close();
			return product;
		}
		else{
		query = session.createQuery("from Product where productName = '" + productName + "'");
		if(query.list().size()!=0){
		product = (Product) query.list().get(0);
		
		session.close();
		factory.close();
		}
		return product;
		}
		
	}
	
	public List<Product> produtList(String productName){
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		Query query;
		List<Product> productList;
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		
		if(productName == null || productName == "" || productName.isEmpty()){
		query = session.createQuery("from Product");
		productList = query.list();
		t.commit();
		
		session.close();
		return productList;
		
		}
		else{
		query = session.createQuery("from Product where productName = '" + productName + "'");
		
		
		productList = query.list();
		
		t.commit();
		
		session.close();
		return productList;
		}
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
	
    public Users lookUpUserName(String userName){
    	Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        // creating seession factory object
        String temp = null;
        SessionFactory factory = cfg.buildSessionFactory();
        // creating session object
        Session session = factory.openSession();
        Query query;
        // creating transaction object
        session.beginTransaction();
        
        
    	query = session.createQuery("from Users where userName = '" + userName + "'");
        Users user = (Users) query.list().get(0);
        

        session.getTransaction().commit();
		session.close();
		factory.close();
		
		return user;
       
        	
        
        
      
     
        
    }
    
}