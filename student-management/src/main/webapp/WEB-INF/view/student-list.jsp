<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>


<div class="container">
<h1 align="center">Student Management</h1>
<form action="showAddStudent">
<input type="submit" value="ADD" class="btn btn-outline-success">
</form>
<br/>
	<table border="1" class="table table-striped">

		<thead>
			<tr>

				<td>id</td>
				<td>name</td>
				<td>mobile</td>
				<td>country</td>

			</tr>

		</thead>

		<c:forEach var="temp" items="${Student}">
			<tr>
				<td>${temp.id}</td>
				<td>${temp.name}</td>
				<td>${temp.mobile}</td>
				<td>${temp.country}</td>
				<td><a href="UpdateStudent?Userid=${temp.id}">UPDATE</a></td>
				<td><a href="DeleteStudent?Userid=${temp.id}" onclick="if(!confirm('are you sure'))return false">DELETE</a></td>
			</tr>
		</c:forEach>

	</table>
</div>


</body>
</html>