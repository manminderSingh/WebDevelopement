
package com.myneu.project.Controller;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.myneu.project.Dao.CustomerDao;
import com.myneu.project.Dao.EmailDao;
import com.myneu.project.Dao.OrderDao;
import com.myneu.project.Dao.PaymentDao;
import com.myneu.project.Dao.PdfDao;
import com.myneu.project.Dao.ProductDao;
import com.myneu.project.Dao.SupplierDao;
import com.myneu.project.Dao.UsersDao;
import com.myneu.project.pojo.AddressCustomer;
import com.myneu.project.pojo.AddressSupplier;
import com.myneu.project.pojo.Contactus;
import com.myneu.project.pojo.Customer;
import com.myneu.project.pojo.EmailPojo;
import com.myneu.project.pojo.FinalProductsOrder;
import com.myneu.project.pojo.Order;
import com.myneu.project.pojo.OrderTemp;
import com.myneu.project.pojo.Payment;
import com.myneu.project.pojo.Product;
import com.myneu.project.pojo.ProductAddToCart;
import com.myneu.project.pojo.Supplier;
import com.myneu.project.pojo.Users;
/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	HttpSession session;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	Users userCheck;
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	 protected ModelAndView handleRequestInternal(
	            HttpServletRequest request,
	            HttpServletResponse response) throws Exception {
	        response.setContentType("text/html;charset=UTF-8");
	        
	        String userName = request.getParameter("userName");
	        String password = request.getParameter("password")	;
	        
	        UsersDao usersDao = new UsersDao();
	        String result = usersDao.validate(userName, password);
	        if(result.equals("empty")){
	        	return new ModelAndView("errorPage");
	        }
	        userCheck = usersDao.checkUser(userName, password);
	   /*     String name = userCheck.getSupplier().getFirstName();*/
	        if (result.equals("Customer"))
	        {
	        	String s = userCheck.getCustomer().getFirstName();
	        	return new ModelAndView("welcomeCustomer","name",s);
	        }
	        else if(result.equals("SupplierApproved")){
	        	String s = userCheck.getSupplier().getFirstName();
	        	return new ModelAndView("welcomeSeller", "name", s);
	        }
	        else if(result.equals("SupplierPending")){
	        	SupplierDao suppl = new SupplierDao();
	        	suppl.approveSupplier("Pending");
	        	return new ModelAndView("unAuthorisedSeller");
	        }
	        else if(result.equals("Admin"))
	        	return new ModelAndView("adminHome");
	  
	        else
	        	return new ModelAndView("login");
	 }
	
	
	@RequestMapping("/approveSupplier.htm")
	public ModelAndView approveSupplier() {
		
	SupplierDao supplierDao = new SupplierDao();
	
	List<Supplier> s=  supplierDao.approveSupplier("Pending");
	
		
		return new ModelAndView("pendingRequests", "approved", s);
	}
	
	
	@RequestMapping("/approved.htm")
	public ModelAndView approved(@RequestParam("check") String a [], HttpServletRequest request, HttpServletResponse response){
		
		
		/*ArrayList<List<Supplier>> supList = new ArrayList<List<Supplier>>();*/
		List<Supplier> supList = new ArrayList<Supplier>();
		String values[] = request.getParameterValues("check");
	
		int val [] = new int [values.length];
		for(int i=0 ; i<values.length; i++) {
			val [i] = Integer.parseInt(values[i]);
		}
		String temp = null;
		SupplierDao supplierDao = new SupplierDao();
		for(int s1: val){
			temp = supplierDao.approved(s1, val);
		
		}
		
		/*if(temp.equals("empty")){
			return new ModelAndView("supplierDoesNotExist");
		}
		else{*/
		
		
	
		if(values.length!=0){
			//Product p;
			List<Supplier> l1 = new ArrayList<Supplier>();
			
	
		
		
		return new ModelAndView ("approvedSupplier");		}
		else{
			return new ModelAndView ("pendingRequests");
		}
	
	
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	
	
	@RequestMapping("/registrationCustomer.htm")
	public ModelAndView showCustomerRegistration() {
		
		return new ModelAndView("registrationCustomer", "command", new Customer());
	}
	 
	@RequestMapping(value = "/registerCustomer.htm", method = RequestMethod.POST)
	 protected ModelAndView registerCustomer(@ModelAttribute("registrationCustomer") Customer customer,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		UsersDao usersDao = new UsersDao();
		
		Users newUser = new Users();
		
		/*String name1 = request.getParameter("userName");
		String tempPassword = request.getParameter("tempPassword");
		Users u = usersDao.checkUser(name1, tempPassword);
		
		if(u.getUserName().equals(name1)){
			return new ModelAndView ("UserNameAlreadyExists");
		}
		*/
				
		newUser.setUserName(request.getParameter("userName"));
		
		newUser.setPassword(request.getParameter("password"));
		
		
		newUser.setUserRole("Customer");
		
		newUser.setCustomer(customer);
		
		newUser.setStatus("Approved");
		
		customer.setUserAccount(newUser);
		
		
		AddressCustomer addressCustomer = new AddressCustomer();
		addressCustomer.setCity(request.getParameter("city"));
		
		addressCustomer.setCustomer(customer);
		addressCustomer.setCountry(request.getParameter("country"));
		addressCustomer.setZipCode(Integer.parseInt(request.getParameter("zipCode")));
		addressCustomer.setStreet(request.getParameter("street"));
		
		
		customer.setAddress(addressCustomer);
		
		
		usersDao.registerCustomer(newUser);
		
		return new ModelAndView("login");
		
	 }
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	@RequestMapping("/registrationSeller.htm")
	public ModelAndView showSellerRegistration() {
		
		return new ModelAndView("registrationSeller", "command", new Supplier());
	}
	
	@RequestMapping(value = "/registerSeller.htm", method = RequestMethod.POST)
	 protected ModelAndView registerSeller(@ModelAttribute("registrationSeller") Supplier supplier,
			 BindingResult result,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		UsersDao usersDao = new UsersDao();
		Users newUser = new Users();
		String name1 = request.getParameter("userName");
		
	
		
	/*	
		if(.getUserName().equals(name1)){
			return new ModelAndView ("UserNameAlreadyExists");
		}*/
		
		
		newUser.setUserName(request.getParameter("userName"));
		newUser.setPassword(request.getParameter("password"));
		newUser.setSupplier(supplier);
		newUser.setUserRole("Supplier");
		supplier.setUserAccount(newUser);
		supplier.setStatus("Pending");
		AddressSupplier addressSupplier = new AddressSupplier();
		addressSupplier.setCity(request.getParameter("city"));
		addressSupplier.setSupplier(supplier);
		
		newUser.setStatus("Pending");
		
		
		
		addressSupplier.setCountry(request.getParameter("country"));
		addressSupplier.setZipCode(Integer.parseInt(request.getParameter("zipCode")));
		addressSupplier.setStreet(request.getParameter("street"));
		
		supplier.setAddress(addressSupplier);
		
		SupplierDao supplierDao = new SupplierDao();
		
		if(newUser.getStatus().equalsIgnoreCase("Pending")){
			supplierDao.approveSupplier("Pending");
		}
		
		usersDao.registerSupplier(newUser);
		
		return new ModelAndView("login");
	 
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	
	@RequestMapping("/addProd.htm")
	public ModelAndView addProd(){
		return new ModelAndView("AddProducts", "name", userCheck.getSupplier().getFirstName());
	}
	
	@RequestMapping("/addProducts.htm")
	 protected ModelAndView addProducts(@ModelAttribute("welcomeSeller") Product product,
			 BindingResult result,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		
		UsersDao usersDao = new UsersDao();
		
	Product p = new Product(request.getParameter("productName"));

	product.setProductName(request.getParameter("productName"));
	product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
	product.setPrice(Double.parseDouble(request.getParameter("price")));	
		
		
		System.out.println("value of Product" + p.toString());
		
		
		
//		Supplier supplier = userCheck.getSupplier();
		/*p.getSupplier().add(supplier);*/
//		System.out.println("value of Supplier" + supplier.toString());
		userCheck.getSupplier().getProduct().add(product);
		product.setSupplier(userCheck.getSupplier());
		
	ProductDao prodDao = new ProductDao();
		
		
		
	   prodDao.addProduct(product);
		
		return new ModelAndView("ProductAddedSuccessfully","name", userCheck.getSupplier().getFirstName());
	
}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	
	
	
	@RequestMapping ("/prodSearch.htm")
	protected ModelAndView prodSearch(){
		return new ModelAndView("productSearch", "command", new Product());
	}
	@RequestMapping (value = "/productSearch.htm")
	protected ModelAndView productSearch(@ModelAttribute("prodSearch") Product product, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		UsersDao usersDao = new UsersDao();
		
		String productName = request.getParameter("productSearch");
		List<Product> products = usersDao.produtList(productName);
		
		if(productName == null){
			return new ModelAndView ("displayProduct", "product", products);
			
		}
		else{
		product.setProductName(productName);
		Product prod = usersDao.searchProduct(productName);
		if(prod==null){
			return new ModelAndView("ProductNotFound");
		}
	
		for(Product p: products){
			if(p.getProductName().equalsIgnoreCase(prod.getProductName())){
			
				
				return new ModelAndView("displayProduct", "product", products);
			}
		}
		}
		
		return new ModelAndView("productSearch");
		
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	
	ArrayList<List<Product>> prodList = new ArrayList<List<Product>>();
	
	@RequestMapping  (value="/placeOrder.htm")
	protected ModelAndView placeOrder(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		List<Product> orderList = null;
//	ArrayList<List<Product>> prodList = new ArrayList<List<Product>>();
		OrderDao orderDao = new OrderDao();
		
		String checkValues [] = request.getParameterValues("check");
		
		int chekValues [] = new int [checkValues.length];
		for(int i=0; i<checkValues.length; i++){
			
			chekValues[i] = (Integer.parseInt(checkValues[i]));
		
		}
	
		for(int s1: chekValues){
			
			prodList = orderDao.placeOrder(s1, chekValues);
		
		}
	
		if(checkValues.length!=0){
			//Product p;
			List<Product> l1 = new ArrayList<Product>();
			
		for(List<Product> l: prodList){
		
			
			l1.add(l.get(0));
		}
		return new ModelAndView ("addToCartPage", "orderedItems", l1);		}
		else{
			return new ModelAndView ("displayProduct");
		}
		
	}
	
	
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	
	
	@RequestMapping ("/proceedToCheckout.htm")
	protected ModelAndView proceedToCheckout(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
	/*List<Product> list  = new ArrayList<Product>();
       for(List<Product> lp : prodList){
    	   list.add(lp.get(0));*/
		
		String values [] = request.getParameterValues("check");
		int val [] = new int [values.length];
		String selectQuantity [] = request.getParameterValues("selectedQuantity");
		int selectedQuantity [] = new int[selectQuantity.length];
		
		double sumTotal = 0;
		ProductAddToCart product = new ProductAddToCart();
		ArrayList<List<ProductAddToCart>> lp1 = new ArrayList<List<ProductAddToCart>>();
		ArrayList<List<Product>> prod = new ArrayList<List<Product>>();
		
		int tempQuantity = 0;
		int b1 = 0  ;
	
		OrderDao od =new OrderDao();
		UsersDao ud = new UsersDao();
	/*	ArrayList<List<ProductAddToCart>> lp = new ArrayList<List<ProductAddToCart>>();*/
		List<Product> l1 = new ArrayList<Product>();
		List<ProductAddToCart> kpl = new ArrayList<ProductAddToCart> ();
		List<ProductAddToCart> kpl1 = new ArrayList<ProductAddToCart> ();
		ProductDao productDao = new ProductDao ();
		
		
	
		
		for(int i=0;i<val.length;i++){
			if(selectQuantity[i]==""||selectQuantity[i]==null||selectQuantity[i].isEmpty()){
				return new ModelAndView ("addToCartPage")	;		
				}
			else{
				
			
			selectedQuantity[i] = Integer.parseInt(selectQuantity[i]);
			val [i] = Integer.parseInt(values[i]);
			int b = val[i];
			prod = od.OrderedProd(b);
			tempQuantity = selectedQuantity[i];
			double t1 ;
			
			
			for(List<Product> list1: prod){
			for(Product per : list1){
				
				
				double total = (per.getPrice() * selectedQuantity[i]);
				System.out.println("The value pf total is - - - - - - - - - - - - - - - - - - - - - - -" + total);
				/*if(per.getQuantity()!=0){
				int a = per.getQuantity();
				 b1 = a - tempQuantity;
				 
				 
				  
					ud.updateProduct(per.getProductId(), b1);*/
					
				
					product.setProductId(per.getProductId());
					product.setProductName(per.getProductName());
					product.setPrice(per.getPrice());
					product.setTotalQuantity(per.getQuantity());
					product.setSelectedQuantity(tempQuantity);
					product.setTotalCost(total);
					product.setCustomerId(userCheck.getCustomer().getCustomerID());
					
					ProductAddToCart pda = od.addProductTemp(product);
					kpl = od.lookUp(pda.getId());
					
					 sumTotal  = sumTotal + pda.getTotalCost(); 
					kpl1.add(kpl.get(0));
			}
			}
			
		}
		}
			
			
      /* PdfDao pf = new PdfDao();
       pf.proceedToCheckout(request, response, prod);*/
       
	model.addAttribute("total", sumTotal);
		
     /*  EmailDao ed = new EmailDao();
       ed.doSendEmail("manmindersingh89@gmail.com");*/
		return new ModelAndView("ViewCart", "finalPayment" , kpl1);
	}	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	@RequestMapping(value = "/deleteSupplier.htm")
	protected ModelAndView deleteSupplier(HttpServletRequest request, HttpServletResponse response ){
		
		
		SupplierDao supplierDao = new SupplierDao();
		List<Supplier> sl = supplierDao.viewAllSuppliers();
		
		
		return new ModelAndView("displayAllSuppliers", "allSuppliers", sl);
		
	}
	
	@RequestMapping(value = "/del.htm", method = RequestMethod.POST)
	protected ModelAndView delSupplier (@ModelAttribute("deleteSupplier") Supplier supplier, BindingResult binding,
			HttpServletRequest request, HttpServletResponse response){
		
		String [] check = request.getParameterValues("check");
		SupplierDao supplierDao = new SupplierDao();
		
		int ch [] = new int [check.length];
		for(int i = 0 ; i<ch.length; i++){
			ch[i] = Integer.parseInt(check[i]);
			
		}
		
		for(int in: ch){
			supplierDao.deleteSupplier(in, ch);
		}
		
		return new ModelAndView ("supplierDeletedSuccessfully");
	}
	@RequestMapping(value="viewOwnProducts.htm")
	protected ModelAndView viewOwnProduct(@ModelAttribute("prodSearch") Product product, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		Supplier supplier = userCheck.getSupplier();
		
		SupplierDao supplierDao = new SupplierDao();
		List<Product> l1 = null;
		l1 = supplierDao.viewAllProducts(supplier.getSupplierID());
	
		return new ModelAndView("viewOwnProducts", "allProducts" , l1);
	}
	
	
	@RequestMapping(value ="oldProducts.htm")
	 protected ModelAndView oldProducts(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		int a = userCheck.getCustomer().getCustomerID();
		CustomerDao cd = new CustomerDao();
		
		List<Product> lp = cd.existingProducts(a);
		
		return new ModelAndView("existingProducts" , "existingProducts", lp );
}
	
	
	int orderId = 1;
	
	int [] productId;
	int selectedQuantity [] ;
	double productPrice [] ;
	double totalCost [] ;
	int totalQuantity [] ;
	int count = 0;
	String [] productName ;
	
	@RequestMapping(value="lastPage.htm")
	protected ModelAndView lastPage(HttpServletRequest request, HttpServletResponse response){
		
		
		String [] productI = request.getParameterValues("productId");
		productName = request.getParameterValues("productName");
		String [] selectQuantity = request.getParameterValues("selectedQuantity");
		String [] productPr  = request.getParameterValues("productPrice");
		String [] totalCo = request.getParameterValues("totalCost");
		String [] totalQu = request.getParameterValues("totalQuantity");
		
		productId = new int [productI.length];
		selectedQuantity = new int [selectQuantity.length];
		productPrice = new double [productPr.length];
		totalCost = new double [totalCo.length];
		totalQuantity =new int [totalQu.length];
		count = productI.length;
	
		
		for(int i =0 ;i<count; i++){
			productId [i] = Integer.parseInt(productI[i]);
			selectedQuantity [i] = Integer.parseInt(selectQuantity[i]);
			productPrice [i] = Double.parseDouble(productPr[i]);
			totalCost [i] = Double.parseDouble(totalCo[i]);
			totalQuantity [i]= Integer.parseInt(totalQu[i]);
			
		}
		
	
		double total = Double.parseDouble(request.getParameter("total"));
	
		return new ModelAndView("checkoutPage","total", total);
	}
	
	@RequestMapping(value="checkOutPage.htm")
	protected ModelAndView checkoutPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
		
		Order order =new Order();
		OrderDao orderDao = new OrderDao();
		FinalProductsOrder prods = new FinalProductsOrder();
		OrderTemp fp1 = new OrderTemp();
		ProductDao productDao =new ProductDao();
		
		
		order.setCustomerID(userCheck.getCustomer().getCustomerID());
		
		Order orde = orderDao.addOrder(order);
		
		
		float fTotal =  Float.parseFloat(request.getParameter("total"));
		
		Customer customer = userCheck.getCustomer();
		customer.getOrders().add(orde);
		Product prod = null;
		
		int o3 = orderDao.lookUpOrderID(orde.getId());
		
		fp1.setOrderId(o3);
		
		 OrderTemp fp3 = orderDao.addOrderTemp(fp1);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		/*
		double totCost [] = new double [totalCost.length];
		int [] prodId = new int [productId.length] ;
		int [] selectedQuantity = new int [selectQuantity.length];
		int [] totalQuantity1 = new int [toalQuantity.length];*/
		
		
		
		
		int a = 0;
		double b = 0;
		int seQuantity = 0;
		int totalQuantity1 = 0;
		int tt = 0;
		ArrayList<FinalProductsOrder> al = new ArrayList<FinalProductsOrder>();
		PdfDao pdf =new PdfDao();
		
		for(int i=0; i<count; i++){
			/*totCost[i] = Double.parseDouble(totalCost[i]);
			prodId [i] = Integer.parseInt(productId [i]);
			selectedQuantity [i] = Integer.parseInt(selectQuantity [i]);
			totalQuantity1 [i] = Integer.parseInt(toalQuantity[i]);*/
			
			
			seQuantity = selectedQuantity[i]; 
			tt = totalQuantity[i];
			
			a = productId[i] ;
			// b = totCost[i];*/
			
			totalQuantity1 = tt-seQuantity;
			
			
			 prod = orderDao.lookUpProductID(a);
			 prods.setProductId(prod.getProductId());
			 prods.setProductName(prod.getProductName());
			 prods.setPrice(totalCost[i]);
			 prods.setProductName(productName[i]);
			 prods.setOrder(fp3);
			 
			 al.add(prods);
			 
			 fp3.getProduct().add(prods);
			 totalQuantity1 = tt - seQuantity;
			 fp3.setOrderId(orde.getId());
			 
			 
			 
			 productDao.addProductFinally(prods);
			 productDao.updateProduct(prod.getProductId(), totalQuantity1);
			 
			
			 
		
		
		}
		
			
		pdf.proceedToCheckout(request, response, al, userCheck.getCustomer().getFirstName(), fTotal);
		
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		long ccd = Long.parseLong(request.getParameter("ccd"));
		int cvv = Integer.parseInt(request.getParameter("cvv"));
		 java.util.Date date= new java.util.Date(); 	
		 
		 PaymentDao paymentDao = new PaymentDao();
		
		Payment payment = new Payment();
		payment.setCvv(cvv);
		payment.setCardNumber(ccd);
		payment.setFirstName(firstName);
		payment.setLastName(lastName);
		payment.setCustomerID(userCheck.getCustomer().getCustomerID());
		payment.setTimeStamp(new Timestamp(date.getTime()));
 
		paymentDao.paymentStored(payment);
		
		
		return new ModelAndView ("FeedBackPage","email", userCheck.getCustomer().getEmailID());
	}
	
	
	@RequestMapping(value = "/Testemail.htm")
	protected ModelAndView testEmail(HttpServletRequest request, HttpServletResponse response ){
		
		String from = request.getParameter("from");
		String message = request.getParameter("message");
		
	//	Users userLocal = userCheck;
		
		EmailPojo pj = new EmailPojo();
	EmailDao emailDao = new EmailDao();
	pj.setFrom(from);
	pj.setMessage(message);
	
	System.out.print("====================================================================");
	System.out.print(userCheck.getCustomer().getEmailID());
	
	
	emailDao.addEmail(pj);
		
		
		return new ModelAndView("ThankYouPage");
		
	}
	
	@RequestMapping(value ="Contactus.htm")
	protected ModelAndView contactus(HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView("contactus");
		
	}
	
	
	

}