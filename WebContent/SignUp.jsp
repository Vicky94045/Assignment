<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SingUp Page</title>
<link rel="stylesheet" type="text/css" href="create.css">
<script type="text/javascript">
function Mysubmit() {	
	var un=document.forms["myform"]["un"].value;
	var pw=document.forms["myform"]["pw"].value;
	var rpw=document.forms["myform"]["rpw"].value;
	var email=document.forms["myform"]["email"].value;
	if(un == "" || pw == "" || rpw == "" || email == "" ){
		alert("Enter data in all the fields");
		return false;
	}else if(pw!=rpw){
		alert("Password did not match");
		document.getElementById("match").innerHTMl="Password didnt match";
		return false;
		}
		
	}
	
	function loginpage() {
		window.location="Index.jsp"
	}

</script>
</head>
<body>
<div class="container">
<form action="SignUp" id="contact" method="post" name="myform" onsubmit="return Mysubmit()"> 
<h3>Sign Up</h3>
<span><% 
if(request.getAttribute("present")!=null)
{
String error=(String)request.getAttribute("present"); 
out.print(error);
}%></span>
<fieldset>
<input type="text" name="un" placeholder="Enter User Name">
</fieldset>
<fieldset>
<input type="password" name="pw" placeholder="Enter Password">
</fieldset>
<fieldset>
<input type="password" name="rpw" placeholder="Reenter Password">
</fieldset>
<span id="match"></span>
<fieldset>
<input type="text" name="email" placeholder="Enter email Id">
</fieldset>
<fieldset>
<input type="submit" name="submit" value="Create User">
</fieldset>

<button type="button" onclick="loginpage();">Login</button>
</form>
</div>
</body>
</html>