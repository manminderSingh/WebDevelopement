<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

 <%@ page language="java" contentType="text/html; charset=US-ASCII"

    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout Page</title>
 <link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css" rel="stylesheet">
 <!-- 
 <script  type="text/javascript">
 $(function(){
	 var textfield = $("input[name=user]");
	             $('button[type="submit"]').click(function(e) {
	                 e.preventDefault();
	                 //little validation just to check username
	                 if (textfield.val() != "") {
	                     $("#output").addClass("alert alert-success animated fadeInUp").html("Welcome back " + "<span style='text-transform:uppercase'>" + textfield.val() + "</span>");
	                     $("#output").removeClass(' alert-danger');
	                     $("input").css({
	                     "height":"0",
	                     "padding":"0",
	                     "margin":"0",
	                     "opacity":"0"
	                     });
	                     //change button text 
	                     $('button[type="submit"]').html("continue")
	                     .removeClass("btn-info")
	                     .addClass("btn-default").click(function(){
	                     $("input").css({
	                     "height":"auto",
	                     "padding":"10px",
	                     "opacity":"1"
	                     }).val("");
	                     });
	                     
	                     //show avatar
	                     $(".avatar").css({
	                         "background-image": "url('http://api.randomuser.me/0.3.2/portraits/women/35.jpg')"
	                     });
	                 } else {
	                     //remove success mesage replaced with error message
	                     $("#output").removeClass(' alert alert-success');
	                     $("#output").addClass("alert alert-danger animated fadeInUp").html("sorry enter a username ");
	                 }
	                 //console.log(textfield.val());

	             });
	 });

 </script> -->
 <style type="text/css">
.colorgraph {
  height: 5px;
  border-top: 0;
  background: #c4e17f;
  border-radius: 5px;
  background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
}
</style>

<script  type="text/javascript">

function validate()
{
	var a = document.getElementById("firstName");
    var b = document.getElementById("lastName");
    var c = document.getElementById("ccd");
    var d = document.getElementById("cvv");
    
    var valid = true;
    if(b.value<=0||c.value<=0||a.value<=0||d.value<=0)
        {
            alert("Check the Empty Fields!");
            valid = false;
            return valid;
        }
};

<span id="error1" style="color: Red; display: none">* Input digits (0 - 9)</span>
var specialKeys = new Array();
specialKeys.push(8); //Backspace
function IsNumeric(e) {
    var keyCode = e.which ? e.which : e.keyCode
    var rett = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
    document.getElementById("error1").style.display = rett ? "none" : "inline";
    return rett;
}


</script>
</head>
<body>

 


                   <hr class="colorgraph">
                   <hr class="colorgraph">
                   <hr class="colorgraph">
                   <hr class="colorgraph">
                   <hr class="colorgraph">
                 
                <form:form action="checkOutPage.htm" method="POST" onsubmit="return validate();">
                <div "container" align="center" >
                <div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
                   <input name="firstName" id="firstName" type="text" placeholder="First Name"/>
                   </div>
                   </div>
                   </div>
                   
                   <div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
                    <input name="lastName" id="lastName" type="text" placeholder="Last Name"/>
                    </div>
                    </div>
                    </div>
                    
                    <div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
                    <input name="ccd" id="ccd" type="text" placeholder="Credit Card Details"  onkeypress="return IsNumeric(event);"
                    class="form-control input-lg" ondrop="return false;" onpaste="return false;"/>
                    </div>
                    </div>
                    </div>
                    <div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
                 <input type="text" placeholder="Cvv" name="cvv" id="cvv"  onkeypress="return IsNumeric(event);"
                    class="form-control input-lg" ondrop="return false;" onpaste="return false;"/>
                    </div>
                    </div>
                    </div>
                    <div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
   Total:           <input type="text" name="total" value="${total}" readonly/>
                   </div>
                   </div>
                   </div>
                    <button class="btn btn-lg btn-danger" type="submit">Pay</button>
                    </div>
                </form:form>
            
          <!--   </div> -->
          
        

</body>
</html>