<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send Email</title>
  <link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css" rel="stylesheet">
  <script  type="text/javascript">
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
var a=document.forms["Form"]["from"].value;
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
<form:form action="feedback.htm" method="POST">


    <div class="container">
	<div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="well well-sm">
          <form class="form-horizontal" name="Form" action="Contactus.htm" method="post" onsubmit="return validate()">
          <fieldset>
            <legend class="text-center">Send Email</legend>
    
            <!-- Name input-->
            <div class="form-group">
              <label class="col-md-3 control-label" for="name">From</label>
              <div class="col-md-9">
                <input id="name" name="from" id="from" type="text" value="sodhimanmindersingh@gmail.com" class="form-control">
              </div>
            </div>
    
            <!-- Email input-->
            <div class="form-group">
              <label class="col-md-3 control-label" for="email">To</label>
              <div class="col-md-9">
                <input id="email" name="email" id="email" type="email" value="${email}" class="form-control" readonly/>
              </div>
            </div>
    
            <!-- Message body -->
            <div class="form-group">
              <label class="col-md-3 control-label" for="message">Your message</label>
              <div class="col-md-9">
                <textarea class="form-control" id="message" id="message" name="message" placeholder="Please enter your message here..." rows="5">
                </textarea>
              </div>
            </div>
     
            <!-- Form actions -->
            <div class="form-group">
              <div class="col-md-12 text-right">
                <button type="submit" class="btn btn-primary btn-lg btn-success">Submit</button>
        	</div>
            </div>


      
          </fieldset>
          </form>
           </div>
            </div>
      </div>
      </div>
          </form:form>
       

</body>
</html>