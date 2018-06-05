<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<a href="Employee.jsp">Employee Function</a> <a href="Select.jsp">Home</a>
	<div class="container">
		
		<form method="post" action="CraeteEmpServlet" id="contact" name=myform onsubmit="return Mysubmit()">
		<h3>Employee Registration form</h1>
			<fieldset>
				<input placeholder="Enter your Employee No" type="text" name="Empno">
			</fieldset>
			<fieldset>
				<input placeholder="Enter First Name" type="text" name="Fname">
			</fieldset>
			<fieldset>
				<input placeholder="Enter Last Name" type="text" name="Lname">
			</fieldset>
			<fieldset>
				<input placeholder="Enter Age" type="text" name="Age">
			</fieldset>
			<fieldset>
				<input placeholder="Enter Emailid" type="text" name="Mail">
			</fieldset>
			<fieldset>
				<input placeholder="Enter Address" type="text" name="Address">
			</fieldset>
			<fieldset>
				Enter Date Of Birth &nbsp;<input placeholder="Enter Date of birth" type="date" name="dob">
			</fieldset>
			<fieldset>
				<input placeholder="Enter Salary" type="text" name="Salary">
			</fieldset>
				<fieldset>
			<div>Enter Gender</div>
			<%-- <input type="text" value=" <%out.print(emp.getGender());%>"	name="gender"> --%>
			<input type="radio" name="gender" value="Male" checked="checked"> Male
			<input type="radio" name="gender" value="Female">Female
  			<input type="radio" name="gender" value="other">Other  
			</fieldset>
			<fieldset>
				<input placeholder="Enter Mobile Number" type="text" name="Mobile">
			</fieldset>
			<fieldset>
				Enter Hire date &nbsp; <input placeholder="Enter Hiredate" type="date" name="Hiredate">
			</fieldset>
			<fieldset>
				<input placeholder="Enter Company Id" type="text" name="cid">
			</fieldset>
			<fieldset>
				<input placeholder="Enter Company Name" type="text" name="cname">
			</fieldset>
			<fieldset>
				<input type="submit" value="Employee Registration" id="contact-submit" name="submit">
			</fieldset>
		</form>
	</div>
</body>
</html>