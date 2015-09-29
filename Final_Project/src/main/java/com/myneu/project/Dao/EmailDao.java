package com.myneu.project.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.myneu.project.pojo.Contactus;
import com.myneu.project.pojo.EmailPojo;
public class EmailDao {

	
	
	    private JavaMailSender mailSender;
	     
	 
	    public String doSendEmail(String s) {
	    	
	    	
	    	System.out.print("================================================");
	    	System.out.print(s);
	        // takes input from e-mail form
	        String recipientAddress = s;
	        String subject = "OrderedItems";
	        String message = "Thank you for Shopping with us!";
	         
	        // prints debug info
	        System.out.println("To: " + recipientAddress);
	        System.out.println("Subject: " + subject);
	        System.out.println("Message: " + message);
	         
	        // creates a simple e-mail object
	        SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo("manmindersingh89@gmail.com");
	        email.setSubject(subject);
	        email.setText(message);
	         
	        // sends the e-mail
	        mailSender.send(email);
	         
	        // forwards to the view named "Result"
	        return "ThanksForFeedback";
	    }
	    
	    public void contactUs(Contactus contactus){
	    	
	    	
	    	Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");// populates the data of the
	                                            // configuration file
	        
	        // creating seession factory object
	        SessionFactory factory = cfg.buildSessionFactory();
	        // creating session object
	        Session session = factory.openSession();
	        // creating transaction object
	        session.beginTransaction();
	        
	        session.save(contactus);
	     
	        session.getTransaction().commit();
			session.close();
			factory.close();
	        
	    	
	    }
	    
	    public void addEmail(EmailPojo email){
	    	Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");// populates the data of the
	                                            // configuration file
	        
	        // creating seession factory object
	        SessionFactory factory = cfg.buildSessionFactory();
	        // creating session object
	        Session session = factory.openSession();
	        // creating transaction object
	        session.beginTransaction();
	        
	        session.save(email);
	     
	        session.getTransaction().commit();
			session.close();
			factory.close();
	    }
	
}