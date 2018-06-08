<%@page import="com.smartekprog.employee.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Employee</title>
<link rel="stylesheet" type="text/css" href="create.css">
<script type="text/javascript">
function Mysubmit() {
	var eno=document.forms["myform"]["Empno"].value;
	var fn=document.forms["myform"]["Fname"].value;
	var ln=document.forms["myform"]["Lname"].value;
	var age=document.forms["myform"]["Age"].value;
	var mail=document.forms["myform"]["Mail"].value;
	var add=document.forms["myform"]["Address"].value;
	var dob=document.forms["myform"]["dob"].value;
	var sal=document.forms["myform"]["Salary"].value;
	var mob=document.forms["myform"]["Mobile"].value;
	var hd=document.forms["myform"]["Hiredate"].value;
	var cid=document.forms["myform"]["cid"].value;	
	if(eno == "" || fn == "" || ln == "" || age == "" || mail== ""  || add== "" || bod== "" || sal== "" || mob== "" || hd== "" || cid== "" ){
		alert("Enter data in all the fields");
		return false;
	}else if(isNaN(cid)==true){
		/* alert("Company Id Must be number"); */
		document.getElementById("ciderr").innerHTML="Company Id Should be number";
		return false;
	}else if(isNaN(cnum)==true){
		/* alert("Company Number should be number"); */
		document.getElementById("cnoerr").innerHTML="Company No. Should be number";
		return false
	}		
	}
</script>
</head>
<body>
<a href="Select.jsp">Home</a>
	<div class="container">		
		<form method="post" action="CraeteEmpServlet" id="contact" name=myform onsubmit="return Mysubmit()">
		<h3>Employee Registration form</h1>
		<%String error=null; 
		Employee emp=null;%>
		<%if(request.getAttribute("present")!=null)
		{
			error=(String)request.getAttribute("present");
			emp=(Employee)request.getAttribute("emp");
			out.print(error);
			
		}
			%>
			<fieldset>
				<input placeholder="Enter your Employee No" type="text" name="Empno" value="<%if(error!=null){ out.print(emp.getEmpNo());}%>">
			</fieldset>
			<fieldset>
				<input placeholder="Enter First Name" type="text" name="Fname" value="<%if(error!=null){ out.print(emp.getFirst_Name());}%>">
			</fieldset>
			<fieldset>
				<input placeholder="Enter Last Name" type="text" name="Lname" value="<%if(error!=null){ out.print(emp.getLast_Name());}%>"> 
			</fieldset>
			<fieldset>
				<input placeholder="Enter Age" type="text" name="Age" value="<%if(error!=null){ out.print(emp.getAge());}%>">
			</fieldset>
			<fieldset>
				<input placeholder="Enter Emailid" type="text" name="Mail" value="<%if(error!=null){ out.print(emp.getMailId());}%>">
			</fieldset>
			<fieldset>
				<input placeholder="Enter Address" type="text" name="Address" value="<%if(error!=null){ out.print(emp.getAddress());}%>">
			</fieldset>
			<fieldset>
				Enter Date Of Birth &nbsp;<input placeholder="Enter Date of birth" type="date" name="dob" value="<%if(error!=null){ out.print(emp.getBirthdate());}%>">
			</fieldset>
			<fieldset>
				<input placeholder="Enter Salary" type="text" name="Salary" value="<%if(error!=null){ out.print(emp.getSalary());}%>">
			</fieldset>
				<fieldset>
			<div>Enter Gender</div>
			<input type="radio" name="gender" value="Male" checked="checked"> Male
			<input type="radio" name="gender" value="Female">Female
  			<input type="radio" name="gender" value="other">Other  
			</fieldset>
			<fieldset>
				<input placeholder="Enter Mobile Number" type="text" name="Mobile" value="<%if(error!=null){ out.print(emp.getMobile_No());}%>">
			</fieldset>
			<fieldset>
				Enter Hire date &nbsp; <input placeholder="Enter Hiredate" type="date" name="Hiredate" value="<%if(error!=null){ out.print(emp.getHire_date());}%>">
			</fieldset>		
			<fieldset>
				<input placeholder="Enter Company Name" type="text" name="cname" value="<%if(error!=null){ out.print(emp.getCompany_Name());}%>">
			</fieldset>
			<fieldset>
				<input type="submit" value="Employee Registration" id="contact-submit" name="submit">
			</fieldset>
		</form>
	</div>
</body>
</html>