package com.myneu.project.Dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.myneu.project.pojo.Product;
import com.myneu.project.pojo.Supplier;
import com.myneu.project.pojo.Users;
public class SupplierDao {
	
	List<Users> users;
	List<Users> userTemp;
public List<Supplier> approveSupplier(String tempName){
		
	
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        List<Supplier> userAccount;
        // creating session factory object
        SessionFactory factory = cfg.buildSessionFactory();
        // creating session object
        Session session = factory.openSession();
       
        // creating transaction object
        session.beginTransaction();
        
        Query query = session.createQuery("from Supplier where status ='"+tempName+"'");
     
        
	    userAccount = query.list();    
	    
		session.close();
		factory.close();
        
		
        
        return userAccount;
		
	}
/////////////////////////////////////////////////////////////////////////////////////////////
	/*ArrayList<List<Supplier>> supList = new ArrayList<List<Supplier>>();
	public  ArrayList<List<Supplier>> approved(int supplierId, int [] a){*/
 List<Supplier> supList = new ArrayList<Supplier>();
public  String approved(int supplierId, int [] a){
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	
	Query query;
//	List<Product> prodList = new ArrayList<Product>();
	//ArrayList<List<Product>> prodList = new ArrayList<List<Product>>();
	
	SessionFactory factory = cfg.buildSessionFactory();
	
	Session session = factory.openSession();
	Transaction t = session.beginTransaction();
	Supplier s2 = null ;
	String temp = null;

	
	
	query = session.createQuery("from Supplier where SupplierID = '" + supplierId + "'");
	  if(query.list().size() == 0){
	    	temp= "empty";
	    }
	  else{
	    
	
		System.out.print("hello "+query.list());
     supList = (List<Supplier>)query.list();
	
	
	List<Supplier> l2 = new ArrayList<Supplier>();
	Users u = null;
	
	
	for(Supplier s3: supList){
		s3.setStatus("Approved");
		u = s3.getUserAccount();
		u.setStatus("Approved");
		
	}
	session.save(u);
	t.commit();
	session.close();
	  }
	return temp;
}
public void deleteSupplier(int supplierId, int a[]){
	
	
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	
	Query query;
	
	SessionFactory factory = cfg.buildSessionFactory();
	
	Session session = factory.openSession();
	Transaction t = session.beginTransaction();
	
	
	
	List<Supplier> l = new ArrayList<Supplier>();
	if(a.length!=0){
		
	
	Supplier s1 = null;
	Users u = null;
	query = session.createQuery("from Supplier where SupplierID = '" + supplierId + "'");
    l = (List<Supplier>) query.list();
	for(Supplier s: l){
	u = s.getUserAccount();
	
	}
	session.delete(u);
	t.commit();
	session.close();
}
	
}
public List<Supplier> viewAllSuppliers(){
	
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	
	Query query;
	
	SessionFactory factory = cfg.buildSessionFactory();
	
	Session session = factory.openSession();
	Transaction t = session.beginTransaction();
	
	
	List<Supplier> al = new ArrayList<Supplier>();
	ArrayList<List> l = new ArrayList<List>();
	
		
	
	
	query = session.createQuery("from Supplier");
	al = query.list();
	t.commit();
	session.close();
	return al;
}
	public void addProductSupplier(Supplier supplier){
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file
        
        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();
        // creating session object
        Session session = factory.openSession();
       /* Session session1 = factory.openSession();
*/
        // creating transaction object
        session.beginTransaction();
       /* session1.beginTransaction();*/
        
        session.save(supplier);
     /*   session1.save(prod);*/
     
        session.getTransaction().commit();
       /* session1.getTransaction().commit();
        session1.close();*/
		session.close();
		factory.close();
        
}
	
	public List<Product> viewAllProducts(int sId){
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		Query query;
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		List<Product> prod = null;
		
		Transaction t = session.beginTransaction();
		
		query = session.createQuery("from Product where supplier_supplierID = '" + sId + "'");
		
		prod = (List<Product>) query.list();
		
		t.commit();
		
		session.close();
		
		return prod;
		
		
	}
	
	
	public Product viewRelatedProducts(int Pid){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		Query query;
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		query = session.createQuery("from Product as product where product.productId = '" + Pid + "'");
		
		Product product = (Product) query.list().get(0);
		
		t.commit();
		
		session.close();
		
		return product;
	}
	
}