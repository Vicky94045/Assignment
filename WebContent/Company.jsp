<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company Home</title>
<link rel="stylesheet" type="text/css" href="create.css">
<script type="text/javascript">
function create() {
	window.location="CreateCompany.jsp"
}

function retrive(){
	window.location="CompanyRetrive"
}

function update(){
	window.location="update.jsp"
}

function deletee(){
	window.location="Delete.jsp"
}
</script>
</head>
<body>
<a href="Select.jsp">Home</a>
<div class="container">
<div id="contact">
<h3>Company</h3>
<button onclick="create();">Create</button>
<br>
<button onclick="retrive();">Retrieve</button>
<br>
<button onclick="update();">Update</button>
<br>
<button onclick="deletee();">Delete</button>
</div>
</div>
</body>
</html>