<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h1>View Students</h1>
	<a href="/">Register New Student</a>
	<table border="">
		<thead>
			<tr>
				<th>S.No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Course</th>
				<th>Timings</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${student.name}</td>
					<td>${student.email}</td>
					<td>${student.gender}</td>
					<td>${student.course}</td>
					<td>${student.timings}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
