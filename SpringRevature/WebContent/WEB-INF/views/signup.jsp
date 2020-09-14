<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendance App</title>
</head>
<body bgcolor="#ed5b1c"><br><br><br><br><br><br>
<center>
	<h1>Sign Up</h1>
	<br/>
	<br/>
	<form action="add" method="post" modelAttribute="admin">
		UserName : <input type="text" id="userName" name="userName"><br/>
		Password : <input type="password" id="password" name="password"><br/><br>
		<input type="submit" id="submit" value="Confirm">
	</form>
</center>
</body>
</html>