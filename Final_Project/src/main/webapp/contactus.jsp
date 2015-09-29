	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Contact Us!!!</title>
    <style>
        body {padding-top:20px;}
    </style>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="bootstrap.min.css" />
    
    <style type="text/css">

.color{ height: 5px;
  border-top: 0;
  background: #c4e17f;
  border-radius: 5px;
  background-image: -webkit-linear-gradient(left, #c4A57f, #c4217f 12.5%, #f7f3ca 12.5%, #f76dca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -moz-linear-gradient(left, #c4e17f, #c4A17f 12.5%, #f7fdca 12.5%, #f7f6ca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -o-linear-gradient(left, #c4d17f, #c4A17f 12.5%, #f76dca 12.5%, #f7f3ca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: linear-gradient(to right, #c4e15f, #c4A15f 12.5%, #f7f5ca 12.5%, #f7f5ca 25%, #fecf51 25%, #fecf51 37.5%, #f0A76c 37.5%, #fA776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
}

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

<script type="text/javascript">
function validateForm()
{
var x=document.forms["myForm"]["fname"].value;
if (x==null || x=="")
  {
  alert("First name must be filled out");
  return false;
  }
}
 if(documet.getElementById("name").value == "")
	 {
	 alert ("The name field is Empty");
	 }

function validate()
{
var a=document.forms["Form"]["name"].value;
var b=document.forms["Form"]["email"].value;
var c=document.forms["Form"]["message"].value;

if (a==null || a=="",b==null || b=="",c==null || c=="")
  {
  alert("Please Fill All Required Field");
  return false;
  }
}
</script>

    
    
</head>
<body>


     
    <div class="container">
   
	<div class="row">
	
      <div class="col-md-6 col-md-offset-3">
      
        <div class="well well-sm">
         <hr class="colorgraph"> 
          <form:form class="form-horizontal" name="Form" action="StoreContactUs.htm" method="post" onsubmit="return validate()">
          <fieldset>
        
            <legend class="text-center"><h2>Contact us</h2></legend>
          <hr class="colorgraph"> 
            <!-- Name input-->
            <div class="form-group">
      
              <label class="col-md-3 control-label" for="name">Name</label>
              <div class="col-md-9">	
                <input id="name" name="name" type="text" id="name" placeholder="Your name" class="form-control">
              </div>
            </div>
    
            <!-- Email input-->
            <div class="form-group">
              <label class="col-md-3 control-label" for="email">Your E-mail</label>
              <div class="col-md-9">
                <input id="email" name="email" type="email" placeholder="Your email" class="form-control">
              </div>
            </div>
            
         <!--   <div class="form-group">
				<input type="email" name="emailID" id="emailID" class="form-control input-lg" placeholder="Email ID" tabindex="3">
			</div>  -->
    
            <!-- <!-- Message body -->
            <div class="form-group">
              <label class="col-md-3 control-label" for="message">Your message</label>
              <div class="col-md-9">
                <textarea class="form-control" id="message" name="message" placeholder="Please enter your message here..." rows="5"></textarea>
              </div>
            </div> 
    
            <!-- Form actions -->
            <div class="form-group">
              <div class="col-md-12 text-right">
                <button type="submit" class="btn btn-primary btn-lg btn-success">Submit</button>
              </div>
            </div>
         
        	

            
          </fieldset>
          </form:form>
             </div>
        </div>
      </div>
	</div>

</body>
</html>
