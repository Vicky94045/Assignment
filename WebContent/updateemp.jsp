<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee</title>

<link rel="stylesheet" type="text/css" href="create.css">

</head>
<body>
<a href="Employee.jsp">Employee Function</a> <a href="Select.jsp">Home</a>
<% String err=(String)request.getAttribute("Error"); %>
<div class="container"> 
<form action="Checkeeid" method="post" id="contact">
<h3>Update Employee</h3>
<fieldset>
<input type="text" name="eno" placeholder="Enter Employee id">
</fieldset>
<%if(err!=null){ %>Employee id not present <%} %>
<fieldset>
<input type="submit" value="Get Record for update">
</fieldset>
</form>
</div>
</body>
</html>