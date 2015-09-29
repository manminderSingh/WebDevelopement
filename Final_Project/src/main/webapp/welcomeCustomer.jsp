 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Welcome ${name}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
    
    #vcontainer1 {
			  display: table;
			  height: 120%;
			  width: 100%;
			  	padding-top : 50px;
			}
    
			    #vcontainer {
			  display: table;
			  height: 120%;
			  width: 100%;
			  	padding-top : 180px;
			}
			#hcontainer {
			  display: table-cell;
			  vertical-align: middle;
			  text-align: center;
			}
			#content {
		
			  display: inline-block;
			  border: black 1px solid;
			  background-color: black;
			  text-align: left;
			}
    
    #search {
    padding-left : 610px;
    padding-top: 20px;
    size: 20px;
    
    width: 20em; 
     height: 20em;
}
    
      body {
        padding-top: 140px;	
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
              <li class="active"><a href="login.jsp">Home</a></li>
             <li class="active"> <a href = "oldProducts.htm">Last Order</a> </li>
            </div>
            </div>
            </div>
				            
				            <form action="productSearch.htm" method="POST">
				            <div id="vcontainer1">
				<h1 align="center"> Welcome ${name} </h1>
				</div>
			<!-- 	<table align="center" > <tr>
				<tr>
				<td>
				<td>
				<td> -->
				 <div id="vcontainer"><div id="hcontainer">
   					 <div id="content">
				<input align="right" type = "text" style="font-size:20pt;height:30px;width:680px" size="95" placeholder="Product Search" name="productSearch">
			<!-- 	</td>
				</td>
				</td>
				</tr>
				</tr>
				<tr>
				<td> -->
				</div>
				<div
				id="search">
				<input type= "submit" name = "Search" value="Submit" class="btn btn-success btn-large">
				</div>
			<!-- 	</td>
				</tr>
				</table> -->
				
				</form>
				              
             
            </ul>
           
          </div><!--/.nav-collapse -->
        </div>
      </div>	
    </div>




      <!-- Example row of columns -->
    

    
    </div> <!-- /container -->

  </body>
</html>