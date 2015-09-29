<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Customer Registration Form</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
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
<script>

function validate()
{
	var a = document.getElementById("firstName");
    var b = document.getElementById("lastName");
    var c = document.getElementById("emailID");
    var d = document.getElementById("text1");
    var e = document.getElementById("userName");
    var f = document.getElementById("password");
    var g = document.getElementById("gender");
    var h = document.getElementById("text2");
    var i = document.getElementById("street");
    var j = document.getElementById("city");
    var k = document.getElementById("state");
    var l = document.getElementById("country");
    
    var valid = true;
    if(b.value<=0||c.value<=0||a.value<=0||d.value<=0||e.value<=0||f.value<=0||g.value<=0||h.value<=0||
    		i.value<=0||j.value<=0||k.value<=0||l.value<=0)
        {
            alert("Check the Empty Fields!");
            valid = false;
            return valid;
        }
};

</script>
</head>
 
<body>
<h3 align="center">Customer Registration Form</h3>
<!-- <font><img src="resources\ebay_logo_gross.jpg" style='width:20%;height:10%'/>Supplier Registration Form</font> -->
<form:form action="registerCustomer.htm" onsubmit="return validate();" method="POST">
 <!-- xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx -->
 
<div class="container">
<div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
    <hr class="colorgraph">
			<h2 align="center">Please Sign Up </h2>
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
                        <input type="text" name="firstName" id="firstName" class="form-control input-lg" placeholder="First Name" tabindex="1">
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="text" name="lastName" id="lastName" class="form-control input-lg" placeholder="Last Name" tabindex="2">
					</div>
				</div>
			</div>
			<div class="form-group">
				<input type="email" name="emailID" id="emailID" class="form-control input-lg" placeholder="Email ID" tabindex="3">
			</div>
			<div class="form-group">
				<input type="text"  id="text1" onkeypress="return IsNum(event);" ondrop="return false;" onpaste="return false;" name="phoneNumber" class="form-control input-lg" placeholder="Mobile Number" tabindex="4">
		
			
		<!--  ..........Validation for the input whether number or not ....... -->
			
			 <span id="error" style="color: Red; display: none">* Input digits (0 - 9)</span>
            <script type="text/javascript">
             var specialKeys = new Array();
             specialKeys.push(8); //Backspace
             function IsNum(e) {
             var keyCode = e.which ? e.which : e.keyCode
             var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
             document.getElementById("error").style.display = ret ? "none" : "inline";
             return ret;
        }
        </script>
			
			
			</div>
			<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="form-group">
				<input type="text" name="userName" id="userName" class="form-control input-lg" placeholder="Username" tabindex="5">
			</div>
			</div>
			<div class="col-xs-6 col-sm-3 col-md-3">
			<div class="form-group">
				<input type="radio" name="gender" id="gender" value="Male" tabindex="6">&nbsp;Male
			</div>
			</div>
			<div class="col-xs-6 col-sm-3 col-md-3">
			<div class="form-group">
				<input type="radio" name="gender" id="gender" value="Female" tabindex="7">&nbsp;Female
			</div>
			</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password" tabindex="8">
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-lg" placeholder="Confirm Password" tabindex="9">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
                        <input type="text" name="street" id="street" class="form-control input-lg" placeholder="Street" tabindex="10">
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="text" name="zipCode" id="text2" onkeypress="return IsNumeric(event);" ondrop="return false;" onpaste="return false;"  class="form-control input-lg" placeholder="Zip code" tabindex="11">
					
									
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
        </script>
							
					
					
					
					
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-8 col-sm-4 col-md-4">
					<div class="form-group">
                        <input type="text" name="city" id="city" class="form-control input-lg" placeholder="City" tabindex="12">
					</div>
				</div>
				<div class="col-xs-8 col-sm-4 col-md-4">
					<div class="form-group">
						<input type="text" name="state" id="state" class="form-control input-lg" placeholder="State" tabindex="13">
					</div>
				</div>
				<div class="col-xs-8 col-sm-4 col-md-4">
					<div class="form-group">
						<input type="text" name="country" id="country" class="form-control input-lg" placeholder="Country" tabindex="14">
					</div>
				</div>
			</div>
			
			<hr class="colorgraph">
			<div class="row">
				<div class="col-md-12"><input type="submit" value="Register" class="btn btn-primary btn-block btn-lg btn-success" tabindex="15"></div>
				
			</div>
			<hr class="colorgraph">
	</div>
</div>
</div>
<!-- xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx -->
</form:form>
 
</body>
</html>