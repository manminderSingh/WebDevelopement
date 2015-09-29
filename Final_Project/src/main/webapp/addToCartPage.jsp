 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add To Cart</title>


 
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
  padding: 50;
  margin: 10;
  border-collapse: collapse;
  border: 1px solid #333;
  font-family: "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
  font-size: 1.5em;
  color: #000;
  background: #A9E2F3; url("widget-table-bg.jpg") top left repeat-x;
  position:center;
           top:80%;
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
    
    <script type="text/javascript">

        function valid()
        {
            var a = document.getElementById("selectedQuantity");
            var b = document.getElementById("orderedQuantity");
            
            var valid = true;
            if(a.value<=0||b.value<a.value)
                {
                    alert("Check the Selected Quantity Field!");
                    valid = false;
                    return valid;
                }
            return valid;
            
        };
        
        </* span id="error1" style="color: Red; display: none">* Input digits (0 - 9)</span>
        var specialKeys = new Array();
        specialKeys.push(8); //Backspace
        function IsNumeric(e) {
            var keyCode = e.which ? e.which : e.keyCode
            var rett = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
            document.getElementById("error1").style.display = rett ? "none" : "inline";
            return rett;
        }
         */
        
         
         
        </script>
    
  </head>



    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" >
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href= "welcomeCustomer.jsp">Home</a></li>
            <!--   <li class="active"><a href= "ViewCart.jsp">View Cart</a> -->
       
              <li><a href="contactus.jsp">Contact Us</a></li>
             
            </ul>
         
            
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

      <body>



  
 

      <!-- Main hero unit for a primary marketing message or call to action -->
      <div>
          <h1 align="center">Add a Quantity</h1>
          </div>
        <!-- Start your all forms here -->
        
        
  
  <div class="container">
        <form action="proceedToCheckout.htm" onsubmit="valid();" method="POST" >
    
              
         
                
                <table border="1" class="pretty-table" align="center" > 
            <col width="50"/>
            <col width="50"/>
            <tr>
                
               
                <th>Select Products </th>
                <th>Product Name</th>
                <th>Product Quantity </th>
                <th>Product Price</th> 
                <th>Select Quantity<th>
                <!-- <th>Duration of Insurance </th>
                <th>Price </th> -->
                 
          
            </tr>
            
          

        
 			<c:forEach items="${orderedItems}" var="ordered"> 

 





                <tr>
                    
                    
               	<td><input type="checkbox" name="check" value="${ordered.productId}" checked onclick="return false"/></td>
                    <%-- <td><input type="text" name="planName" value="${ordered.productId}" readonly/>  </td> --%>
                   
                    <td><input type="text" name="orderedProductName" value="${ordered.productName}" readonly/>  </td>
                    <td><input type="text" id="orderedQuantity" name="orderedQuantity" value="${ordered.quantity}" readonly/>  </td>
                    <td><input type="text" name="orderedPrice" value="${ordered.price}" readonly/>  </td>
                    <td><input type="text" id="selectedQuantity" onkeypress="return IsNumeric(event);"class="form-control input-lg" ondrop="return false;" onpaste="return false;" name="selectedQuantity"/></td>
                 <%--    <td><input type="text" name="noofDays" value="${ordered.noofDays}" readonly/>  </td>
                    <td><input type="text" name="price" value="${offer.price}" readonly/>  </td> --%>
                 

                   


                </tr>
                
                </c:forEach> 
                
              
                    </table>
                 <div
				id="search">
				<input type= "submit" name = "Search" value="Submit" class="btn btn-success btn-large">
				</div>
               
                
            </form>
         
           
            </div>
</body>


        <!-- End your all forms here!! -->
      
      
    

    
   

   

  </body>
</html>
      
        <!--            <tt>index.jsp</tt>  <tt>redirect.jsp</tt> 
                    <tt>web.xml</tt>.</p>-->
        
    </body>
</html>



</body>
</html>