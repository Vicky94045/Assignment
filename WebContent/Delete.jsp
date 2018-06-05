<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="create.css">
<title>Delete Company Record</title>
<script type="text/javascript">
function Mysubmit() {
	var v=document.forms["myform"]["cid"].value;
	if(v == ""){
		alert("Enter Some value");
		return false;
	}
	/* if (v != ""){
		document.getElementByName("myform").submit();
	} */
}
</script>

</head>
<body>	
<a href="Company.jsp">Company Function</a> <a href="Select.jsp">Home</a>
	<div class="container">
		<form method="post" action="DeleteCompany" id="contact" name="myform" onsubmit="return Mysubmit()">
			<h3>Delete Company Record</h3>
			<fieldset>
			<input type="text" name="cid" placeholder="Enter Company id">
			</fieldset>
			<fieldset> 
			<input type="submit" value="Delete record" >
			</fieldset>
			<fieldset>
			<H4>
				<font style="font: bold;">NOTE:-</font>&nbsp; Company who already
				have employees in them can't be deleted
			</H4>
			</fieldset>
		</form>
	</div>
</body>
</html>