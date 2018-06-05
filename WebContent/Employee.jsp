<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="create.css">
<script type="text/javascript">
function create() {
	window.location="CreateEmployee.jsp"
}

function retrive(){
	window.location="EmployeeRetrive"
}

function update(){
	window.location="updateemp.jsp"
}

function deletee(){
	window.location="DeleteEmployee.jsp"
}
</script>
</head>
<body>

<div class="container" style="padding-top: 150px">
<div id="contact">
<h3>Employee</h3>
<button onclick="create();" id="contact-submit" name="submit">Create</button>
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