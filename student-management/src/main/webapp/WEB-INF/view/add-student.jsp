
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD Student</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

</head>
<body class="p-3 mb-2 bg-info-subtle text-info-emphasis">

	<div align="center">
		<h3>Add Student</h3>
		<form:form action="SaveStudent" modelAttribute="student" method="POST">
		<form:hidden path="id"/>
			<label>Student name</label>
			<form:input path="name" />
			<br />
			<label>mobile</label>
			<form:input path="mobile" />
			<br />
			<label>Country:</label>
			<form:input path="country" />
			<br />
			<input type="submit" value="Submit" class="btn btn-outline-info">

		</form:form>
	</div>

</body>
</html>