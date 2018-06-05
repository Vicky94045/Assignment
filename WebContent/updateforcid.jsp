<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.smartekprog.company.model.Company"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Company Record</title>
<link rel="stylesheet" type="text/css" href="create.css">
</head>
<body>
<a href="Company.jsp">Company Function</a> <a href="Select.jsp">Home</a>
	<%
		Company co = (Company) session.getAttribute("company");
		HttpSession newsession = request.getSession();
	%>
	</h1>
	<div class="container">
	<form action="CompanyUpdateData" method="post" id="contact">
	<h3>
		Update data of Company with id:
		<%
		out.print(co.getCompany_id());
	%>
	</h3>
		<table>
			<tr>
				<td>Company Id (Not Editable)</td>
				<td><input type="text" name="cid" value=<%out.print(co.getCompany_id());%> readonly="readonly"></td>
			</tr>

			<tr>
				<td>Company name</td>
				<td><input type="text" name="cname"
					value=<%out.print(co.getCompany_Name());%>></td>
			</tr>

			<tr>
				<td>Company Address</td>
				<td><input type="text" name="caddress"
					value=<%out.print(co.getCompany_Address());%>></td>
			</tr>

			<tr>
				<td>Company Contact Number</td>
				<td><input type="text" name="cnumber"
					value=<%out.print(co.getCompany_Contact_No());%>></td>
			</tr>

			<tr>
				<td>Company Type</td>
				<td><input type="text" name="ctype"
					value=<%out.print(co.getType());%>></td>
			</tr>
		</table>
		<input type="submit" value="Update">
	</form>
	</div>
</body>
</html>