	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
    
    #vcontainer1 {
			  display: none;
			  height: 120%;
			  width: 100%;
			  	padding-top : 150px;
			}
			
			#search {
    padding-left : 5px;
    padding-top: 280px;
    size: 20px;
    
    width: 20em; 
     height: 20em;
}

#search1 {

  padding-left : 47px;
    padding-top: 80px;
    size: 20px;
    
    width: 20em; 
     height: 20em;
}
    </style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator Page</title>
 <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
 
 
</head>

<body >

 
<table align="center">

<tr>

<td>

<form:form  action="approveSupplier.htm" method="POST">
<div id="search">
<button type="submit" name="submit" class="btn btn-primary btn-lg btn-success">Approve Supplier Requests</button>
</div>
</form:form>

</td>
</tr>



<tr>
<td>
<form:form  action="deleteSupplier.htm" method="POST">
<div id="search1">
<button type="submit" name="submit" class="btn btn-primary btn-lg btn-success"> View All Supplier</button>
</div>
</form:form>

</td>
</tr>
</table>

</body>
</html>