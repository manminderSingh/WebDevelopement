	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Added Successfully</title>
<link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css" rel="stylesheet">
 <style type="text/css">

	#search {
    padding-left : 685px;
    padding-top: 280px;
    size: 20px;
    
    width: 20em; 
     height: 20em;
}
</style>
</head>
<body>

<h1 align="center">Product Added Successfully</h1>

<form:form  action="addProd.htm" method="POST">
<div id="search">
<button type="submit" name="submit" class="btn btn-primary btn-lg btn-success">Add More Products?</button>
</div>
</form:form>

</body>
</html>