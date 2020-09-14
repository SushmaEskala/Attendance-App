<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center" bgcolor='orange'>
	<h1> Edit student Details</h1>
	<form action="editDetails" modelAttribute="edit">
	<table border="1" align="center">
		<tr>
			<td> Name </td>
			<td> ${student.getName()}</td>
		</tr>
		<tr>
			<td> Place </td>
			<td><input type="text" id="place" name="place"></td>
		</tr>
		<tr>
			<td> Department </td>
			<td><input type="text" id="dept" name="dept"></td>
		</tr>
	</table>
	<input type="submit" id="submit" value="Edit">
	</form>
</body>
</html>