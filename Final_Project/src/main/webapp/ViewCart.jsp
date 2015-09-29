<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>View Cart</title>
</head>

        
       

  <head>
    <meta charset="utf-8">
    <title>Bootstrap, from Twitter</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
     
      
      #search {
    padding-left : 510px;
    padding-top: 120px;
    size: 20px;
    
    width: 20em; 
     height: 20em;
}
      body {
        padding-top: 60px;
        padding-bottom: 20px;
      }
      .pretty-table
{
  padding: 20;
  margin: 10;
  border-collapse: collapse;
  border: 1px solid #333;
  font-family: "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
  font-size: 1.5em;
  color: #000;
  background: #A9E2F3; url("widget-table-bg.jpg") top left repeat-x;
  position:center;
           top:60%;
           left:0%; 
}

.pretty-table caption
{
  caption-side: bottom;
  font-size: 0.9em;
  font-style: italic;
  text-align: right;
  padding: 0.5em 0;
}

.pretty-table th, .pretty-table td
{
  border: 1px dotted #666;
  padding: 0.5em;
  text-align: center;
  color: #632a39;
}

.pretty-table th[scope=col]
{
  color: #000;
  background-color: #FFFFCC;
  text-transform: uppercase;
  font-size: 0.9em;
  border-bottom: 2px solid #333;
  border-right: 2px solid #333;
}

.pretty-table th+th[scope=col]
{
  color: #fff;
  background-color: #7d98b3;
  border-right: 1px dotted #666;
}

.pretty-table th[scope=row]
{
  background-color: #FFFFCC;
  border-right: 2px solid #333;
}

.pretty-table tr.alt th, .pretty-table tr.alt td
{
  color: #2a4763;
}
    </style>
    <link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    
  </head>

  

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="welcomeCustomer.jsp">Home</a></li>
            
              <li><a href="contactus.jsp">Contact Us</a></li>
             
            </ul>
         
            
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
<body>
    

      <!-- Main hero unit for a primary marketing message or call to action -->
      <div>
          <h1 align="center">View Cart</h1>
          </div>
        <!-- Start your all forms here -->
  
  <div class="container">
        <form action="lastPage.htm" method="POST">
    
                
         
                
                <table border="1" class="pretty-table" align="center" > 
            <col width="50"/>
            <col width="50"/>
            <tr>
                
               
                <th>Product ID </th>
                <th>Product Name</th>
                <th>Product Quantity </th>
             <!--    <th>Total Quantity</th> -->
                <th>Product Price</th> 
                <th>Total Price</th> 
                <!-- <th>Duration of Insurance </th>
                <th>Price </th> -->
                 
          
            </tr>
            
          


 			<c:forEach items="${finalPayment}" var="ordered"> 

 





                <tr>
                    
               	
                    <td><input type="text" name="productId" value="${ordered.productId}" readonly/>  </td>
                   
                    <td><input type="text" name="productName" value="${ordered.productName}" readonly/>  </td>
                    <td><input type="text" name="selectedQuantity" value="${ordered.selectedQuantity}" readonly/>  </td>
                   <%--   <td><input type="text" name="totalQuantity" value="${ordered.totalQuantity}" readonly/>  </td> --%>
                    <td><input type="text" name="productPrice" value="${ordered.price}" readonly/>  </td>
                  <td><input type="text" name="totalCost" value="${ordered.totalCost}" readonly/>  </td>
                 
					<input type="hidden" name="totalQuantity" value="${ordered.totalQuantity}" readonly/> 
					
                   
</tr>

                
                
                </c:forEach> 
                
               
                    </table>
                    
                      <div
				id="search">
				   Total: <input type="text" name="total" value="${total}" readonly/>
				<input type= "submit" name = "Search" value="Submit" class="btn btn-success btn-large">
				</div>
               
                       
                   
                    
               
               
            </form>
        
        
         <%-- <table>
               <tr>
               <td>${total}</td>
               </tr>
               </table> --%>
                
           
            </div>
</body>


        <!-- End your all forms here!! -->
      
      
    

    
   

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../assets/js/jquery.js"></script>
    <script src="../assets/js/bootstrap-transition.js"></script>
    <script src="../assets/js/bootstrap-alert.js"></script>
    <script src="../assets/js/bootstrap-modal.js"></script>
    <script src="../assets/js/bootstrap-dropdown.js"></script>
    <script src="../assets/js/bootstrap-scrollspy.js"></script>
    <script src="../assets/js/bootstrap-tab.js"></script>
    <script src="../assets/js/bootstrap-tooltip.js"></script>
    <script src="../assets/js/bootstrap-popover.js"></script>
    <script src="../assets/js/bootstrap-button.js"></script>
    <script src="../assets/js/bootstrap-collapse.js"></script>
    <script src="../assets/js/bootstrap-carousel.js"></script>
    <script src="../assets/js/bootstrap-typeahead.js"></script>

  </body>
</html>
      
        <!--            <tt>index.jsp</tt>  <tt>redirect.jsp</tt> 
                    <tt>web.xml</tt>.</p>-->
        
    </body>
</html>



</body>
</html>