<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Company Record</title>
<link rel="stylesheet" type="text/css" href="create.css">
</head>
<body>
<a href="Company.jsp">Company Function</a> <a href="Select.jsp">Home</a>
<% String err=(String)request.getAttribute("Error"); %>
<div class="container"> 
<form method="post" action="CompanyUpdate" id="contact" >
<h3>Update Company</h3>
<fieldset>
<input type="number" name="cid" placeholder="Enter Company id" style="font-size: 16px"><br>
<%if(err!=null){ %>Company id not present <%} %>
<input type="submit" value="update">
</fieldset>
</form>
</div>
</body>
</html>