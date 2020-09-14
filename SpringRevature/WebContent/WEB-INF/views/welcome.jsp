<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendance App</title>
</head>
<body bgcolor="#ed5b1c"><br><br><br><br><br><br>
<center>
	<h1> Student List </h1>
	<table border="3" align="center">
		<tr>
			<th>Name</th>
			<th>Place</th>
			<th>Department</th>
			<th colspan='2'>Action</th>
		</tr>
		<c:forEach var="stu" items="${studentList}">
			<tr>
				<td>${stu.name}</td>
				<td>${stu.place}</td>
				<td>${stu.dept}</td>
				<td><a href="edit/${stu.name}">Edit</a></td>
				<td><a href="delete/${stu.name}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	Do you Want to insert the student?<a href="insert">Insert</a><br><br>
	You can mark the students attendance here.<a href="mark">Mark The Attendace</a>
</center>
</body>
</html>