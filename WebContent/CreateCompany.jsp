<%@page import="com.smartekprog.company.model.Company"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Company</title>
<link rel="stylesheet" type="text/css" href="create.css">
<script type="text/javascript">
function Mysubmit() {
	var cid=document.forms["myform"]["cid"].value;
	var cn=document.forms["myform"]["cname"].value;
	var ca=document.forms["myform"]["caddress"].value;
	var cnum=document.forms["myform"]["cnumber"].value;
	var ct=document.forms["myform"]["ctype"].value;
	if(cid == "" || cn == "" || ca == "" || cnum == "" || ct== ""  ){
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
<a href="Company.jsp">Company Function</a> <a href="Select.jsp">Home</a>
<% String cid=(String)request.getAttribute("present"); 
Company comp=(Company)request.getAttribute("comp");
%>
<div class="container">
<form method="post" action="craeteservlet" id="contact" name="myform" onsubmit="return Mysubmit()">
<h3>Company Registration form</h3>
<span><%if(comp!=null){ out.print("Duplicate entry company id already present");}%></span>
<fieldset>
<input type="text" name="cid" placeholder="Enter Company Id" <% if(comp!=null){ %> value="<% out.print(comp.getCompany_id());%>" <%} %> >
<%if(cid!=null){ %><%} %><span id="ciderr"></span>
</fieldset>
<fieldset> 
<input type="text" name="cname" placeholder="Enter Company Name" <% if(comp!=null){ %> value="<% out.print(comp.getCompany_Name());%>" <%} %>>
</fieldset>
<fieldset>
<input type="text" name="caddress" placeholder="Enter Company Address" <% if(comp!=null){ %> value="<% out.print(comp.getCompany_Address());%>" <%} %>>
</fieldset>
<fieldset>
<input type="text" name="cnumber" placeholder="Enter Company Number" <% if(comp!=null){ %> value="<% out.print(comp.getCompany_Contact_No());%>" <%} %>><span id="cnoerr"></span>
</fieldset>
<fieldset> 
<input type="text" name="ctype" placeholder="Enter Company Type i.e IT,BPO,Etc.." <% if(comp!=null){ %> value="<% out.print(comp.getType());%>" <%} %>>
</fieldset>
<fieldset>
<input type="submit" value="Register" id="contact-submit" name="submit">
</fieldset>
</form>
</div>
</body>
</html>