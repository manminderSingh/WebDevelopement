 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome - "${name}"</title>
 <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->

    <style type="text/css">
    
    #vcontainer1 {
			  display: table;
			  height: 120%;
			  width: 100%;
			  	padding-top : 50px;
			}
    
			
   	#search {
    padding-left : 45px;
    padding-top: 280px;
    size: 20px;
    
    width: 20em; 
     height: 20em;
}

#search1 {

  padding-left : 27px;
    padding-top: 80px;
    size: 20px;
    
    width: 20em; 
     height: 20em;
}
    
    
    </style>
    

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->
</head>
<body>

 


<table align="center">

<tr>

<td>

<form:form  action="addProd.htm" method="POST">
<div id="search">
<button type="submit" name="submit" class="btn btn-primary btn-lg btn-success">Add Products</button>
</div>
</form:form>

</td>
</tr>



<tr>
<td>
<form:form  action="viewOwnProducts.htm" method="POST">
<div id="search1">
<button type="submit" name="submit" class="btn btn-primary btn-lg btn-success"> View Own Products</button>
</div>
</form:form>

</td>
</tr>
</table>



</body>
</html>