<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h3>Student Registration Form</h3>
    <font color="green">${msg}</font>
    <form:form method="POST" action="register" modelAttribute="student">
        <table>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <form:radiobutton path="gender" value="male" /> Male
                    <form:radiobutton path="gender" value="female"/> Female
                </td>
            </tr>
            <tr>
                <td>Course:</td>
                <td>
                    <form:select path="course">
                        <form:option value="" label="--Select--" />
                        <form:options items="${courses}" />
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Timings:</td>
                <td>
                    <form:checkboxes items="${timings}" path="timings" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td colspan="2">
                    <input type="submit" value="Register" />
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
