<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Maven Project</title>
</head>
<body>
	<form method="post" action="Mavenservlet">
		<table>
			<tr>
				<td>Enter empNo: </td>
				<td><input type="text" name="empno"></td>
			</tr>
			<tr>
				<td>Enter name: </td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Enter Salary:</td>
				<td><input type="text" name="salary"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add"></td>
			</tr>
		</table>
	</form>
	<script>
		alert(<%= session.getAttribute("message") %>);
	</script>
</body>
</html>