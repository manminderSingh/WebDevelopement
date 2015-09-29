<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>E-Commerce</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 120px;	
        padding-bottom: 120px;
      }
    </style>
    <link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

   
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        <!--   <a class="brand" href="#">E-Commerce</a> -->
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              
              <li><a href="registrationSeller.htm">Register Supplier</a></li>
           <!--    <li><a href="Testemail.htm">testemail</a></li> -->
              <li><a href = "Contactus.htm">Contact Us</a></li>
              <li><
             
            </ul>
              <!-- start your form here and copy your code   -->
            <form:form class="navbar-form pull-right" method="POST"  action="login.htm">
              <input class="span2" name="userName" placeholder="User Name" type="text"/><font color="red">
               <form:errors path="userName" /></font>
              <input name="password" type="password" placeholder="Password"/>
              <font color="red"><form:errors path="password" /></font>
              <button type="submit" class="btn">Sign in</button>
            </form:form>
              <!-- end your form here -->
          </div><!--/.nav-collapse -->
        </div>
      </div>	
    </div>














    <div class="container">

      <!-- Main hero unit for a primary marketing message or call to action -->
     <div class="hero-unit">
     	<div class="row">
<div class="span4">
 <h1>Welcome To  ECommerce Website </h1>
      <form:form class="form-signin" method="POST" action="registrationCustomer.htm">
       <div>
       <h2>Not a member yet?</h2>
        
          <button type="submit" class="btn btn-large btn-primary btn-success">Register Here!</button>  </div>
      </form:form>

</div>
<div class="span4">
</div>
<div class="span6">
 <img src='resources/ecommerce-seo.jpg' style='width:400%;height:100%' alt='[]' />

</div>

     
      </div>

      <!-- Example row of columns -->
    

    
    </div> <!-- /container -->

  </body>
</html>