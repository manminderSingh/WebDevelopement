 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Products</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
</head>


<body>


<span id="error1" style="color: Red; display: none">* Input digits (0 - 9)</span>
<script type="text/javascript">

var specialKeys = new Array();
specialKeys.push(8); //Backspace
function IsNumeric(e) {
    var keyCode = e.which ? e.which : e.keyCode
    var rett = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
    document.getElementById("error1").style.display = rett ? "none" : "inline";
    return rett;	
    
    
}

function validate()
{
	var a = document.getElementById("productName");
    var b = document.getElementById("price");
    var c = document.getElementById("quantity");
    
    var valid = true;
    if(b.value<=0||c.value<=0||a.value<=0)
        {
            alert("Check the Empty Fields!");
            valid = false;
            return valid;
        }
};
</script>



<h1 align="center">Welcome ${name} </h1>


<h1 align="center">Add Products</h1>



<form:form action="addProducts.htm" method="POST" onsubmit="return validate();">

 	
			<div class="container">
				<div class="row">
		 <div class="col-md-6 col-md-offset-3"> 
			<div class="form-group">
				<input align="middle" type="text" name="productName" id="productName" class="form-control input-lg" placeholder="Product Name" tabindex="3">
			</div>
		
			
			<div class="form-group">
				<input type="text" name="price" id="price" class="form-control input-lg" placeholder="Price" tabindex="4">
			</div>
		
		
			<div class="form-group">
				<input type="text" name="quantity" id="quantity" class="form-control input-lg" placeholder="Quantity"
				onkeypress="return IsNumeric(event);" tabindex="5">
			</div>
			<div class="row">
				<div class="col-md-12"><input align="middle" type="submit" value="Add Products" 
				class="btn btn-primary btn-lg btn-success" tabindex="11" ></div>
				
			</div>
			</div>
			</div>
		 	</div>
			 
			

</form:form>
</body>
</html>