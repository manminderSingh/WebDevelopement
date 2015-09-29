package com.myneu.project.Controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myneu.project.Dao.EmailDao;
import com.myneu.project.pojo.Contactus;
@Controller
@RequestMapping("/feedback.htm")
public class EmailController {
 
    @Autowired
    private JavaMailSender mailSender;
     
    @RequestMapping(method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request) {
        // takes input from e-mail form
    	
    	String name = request.getParameter("name");
		String email1 = request.getParameter("email");
		String mess = request.getParameter("message");
       /* String recipientAddress = request.getParameter("recipient");
        String subject = request.getParameter("subject");*/
       /* String message = request.getParameter("message");*/
         
		
		EmailDao emailDao = new EmailDao();
		Contactus contactus =new Contactus();
		contactus.setEmail(email1);
		contactus.setMessage(mess);
		contactus.setName(name);
		
		emailDao.contactUs(contactus);
		
        // prints debug info
        System.out.println("To: " + email1);
        System.out.println("Subject: " + "Ordered Items");
        System.out.println("Message: " + "Thank you for Shopping!!! Please Visit Again");
         
        // creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(email1);
        email.setSubject("Order placed Successfully");
        email.setText("Thank you for Shopping!!!");
         
        // sends the e-mail
        mailSender.send(email);
         
        // forwards to the view named "Result"
        return "ThanksForFeedback";
    }
}