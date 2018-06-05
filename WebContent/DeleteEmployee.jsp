<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Employee</title>
<link rel="stylesheet" type="text/css" href="create.css">
</head>
<body>
<a href="Employee.jsp">Employee Function</a> <a href="Select.jsp">Home</a>
<div class="container" >
<form action="DeleteEmployee"  method="post" id="contact">
<h3>Delete Employee</h3>
<input type="text" name="eid" placeholder="Enter Employee id">
<input type="submit" value="Delete Record">
</form>
</div>
</body>
</html>