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
	<h1> Insert Details </h1>
	<form action="addStudent" modelAttribute="insert">
	Name : <input type="text" id="name" name="name"><br/>
	Place : <input type="text" id="place" name="place"><br/>
	Department : <input type="text" id="dept" name="dept"><br/><br>
	<input type="submit" id="submit" value="Submit">
	</form>
</center>
</body>
</html>