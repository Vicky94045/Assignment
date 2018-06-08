<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" type="text/css" href="create.css">
<script type="text/javascript">
function SignUp() {
	window.location="SignUp.jsp"
}

</script>

</head>
<body>
<% String error=(String)request.getAttribute("Fial"); %>
<div class="container">
<form method="post" action="LoginServlet" id="contact">
<h3>Login form</h3>
<span><%if(error!=null) {out.print(error);} %></span>
<fieldset>
Enter user name <input name="uname" type="text" required>
</fieldset>
<fieldset>
Enter password<br><input name="password" type="password" style="width: 100%;height: 40px;" required>
</fieldset>
<fieldset>
<input type="submit" value="Login">
<button type="button" onclick="SignUp()">Create User</button>
</fieldset>
</form>
</div>
</body>
</html>