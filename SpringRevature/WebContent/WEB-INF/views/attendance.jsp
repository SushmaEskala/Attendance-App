<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#ed5b1c"><br><br><br><br><br><br>
<center>
	<h1> Attendace Page </h1>
	
	<form action="present" modelAttribute="student">
	<table border="3" align="center">
	<tr>
		<th>Student Name</th>
		<th>14/09/2020</th>
		<th>15/09/2020</th>
		<th>16/09/2020</th>
		<th>17/09/2020</th>
		<th>18/09/2020</th>
		<th>19/09/2020</th>
		<th>20/09/2020</th>
	</tr>
		<c:forEach var="s" items="${studentList}">
			<tr>
				<td>${s.getName()}</td>
				<td><input type="checkbox" id="cb1" name="cb1" value="present"></td>
				<td><input type="checkbox" id="cb2" name="cb2" value="present"></td>
				<td><input type="checkbox" id="cb3" name="cb3" value="present"></td>
				<td><input type="checkbox" id="cb4" name="cb4" value="present"></td>
				<td><input type="checkbox" id="cb5" name="cb5" value="present"></td>
				<td><input type="checkbox" id="cb6" name="cb6" value="present"></td>
				<td><input type="checkbox" id="cb7" name="cb7" value="present"></td>
				
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="submit" id="submit"/>
	</form>
</center>
</body>
</html>