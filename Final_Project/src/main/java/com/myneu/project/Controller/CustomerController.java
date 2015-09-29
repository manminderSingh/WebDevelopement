package com.myneu.project.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.myneu.project.Dao.CustomerDao;
import com.myneu.project.pojo.Contactus;

@Controller
@SessionAttributes
public class CustomerController {

	@RequestMapping(value="StoreContactUs.htm")
	protected ModelAndView storeContatUs(HttpServletRequest request, HttpServletResponse response){
		
		String name= request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		Contactus contactus = new Contactus();
		contactus.setName(name);
		contactus.setEmail(email);
		contactus.setMessage(message);
		CustomerDao customerDao =new CustomerDao ();
		customerDao.addContactus(contactus);
		
		return new ModelAndView ("getBackToYou");
	}
}
