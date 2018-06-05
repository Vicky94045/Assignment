<%@page import="com.smartekprog.employee.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee Data</title>
<link rel="stylesheet" type="text/css" href="create.css">
</head>
<body>
<a href="Employee.jsp">Employee Function</a> <a href="Select.jsp">Home</a>
	<%
		Employee emp = (Employee) session.getAttribute("emp");
	%>
	<div class="container">
	<form action="UpdateEmployee" method="post" id="contact">
	<h3>Update Employee Data</h3>
			<fieldset>
			 Enter Employee number <input type="text" value="<%out.print(emp.getEmpNo());%>" name="Empno">
			</fieldset>
			<fieldset>
			Enter First Name<input type="text" value="<%out.print(emp.getFirst_Name());%>"	name="Fname">
			</fieldset>
			<fieldset>
			Enter Last Name<input type="text" value="<%out.print(emp.getLast_Name());%>"name="Lname">
			</fieldset>
			<fieldset>
			Enter Age<input type="text" value="<%out.print(emp.getAge());%>" name="Age">
			</fieldset>
			<fieldset>
			Enter Email Id<input type="text" value="<%out.print(emp.getMailId());%>" name="Mail"">
			</fieldset>
			<fieldset>
			Enter Address<input type="text" value="<%out.print(emp.getAddress());%>" name="Address">
			</fieldset>
			<fieldset>
			Date of birth &nbsp; <input type="date" value="<%out.print(emp.getBirthdate());%>" name="dob">
			</fieldset>
			<fieldset>
			Enter Salary<input type="text" value="<%out.print(emp.getSalary());%>" name="Salary">
			</fieldset>
			<fieldset>
			<div>Enter Gender</div>
			<%-- <input type="text" value=" <%out.print(emp.getGender());%>"	name="gender"> --%>
			<input type="radio" name="gender" value="Male"  <%if (emp.getGender().equalsIgnoreCase("Male")) { %>  checked <% }%>> Male<br>
			<input type="radio" name="gender" value="Female" <%if (!emp.getGender().equalsIgnoreCase("Male")) { %>  checked <% }%>> Female<br>
  			<input type="radio" name="gender" value="Other"> Other
			</fieldset>
			<fieldset>
			Enter Mobile No<input type="text" value="<%out.print(emp.getMobile_No());%>"name="Mobile">
			</fieldset>
			<fieldset>
			Hire Date&nbsp;<input type="date" value="<%out.print(emp.getHire_date());%>" name="Hiredate">
			</fieldset>
			<fieldset>
			Enter Company Id<input type="text" value="<%out.print(emp.getCompany_id());%>" name="cid">
			</fieldset>
			<fieldset>
			<input type="submit" value="Update">
			</fieldset>
	</form>
	</div>
</body>
</html>