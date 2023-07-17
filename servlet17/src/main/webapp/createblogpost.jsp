<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Blog Post</title>
</head>
<body>
	<center>
		<h1>Create Blog Post</h1>
		<form method="POST" action="servletcontroller/addform">
			<table>
				<tr>
					<th><label for="title">Title:</label></th>
					<td><input type="text" id="title" name="title" required></td>
				</tr>
				<br>
				<br>
				<tr>
					<th><label for="description">Description:</label></th>
					<td><textarea id="description" name="description" required></textarea></td>
				</tr>
				<br>
				<br>
				<tr>
					<th><label for="content">Content:</label></th>
					<td><textarea id="content" name="content" required></textarea></td>
				</tr>
				<br>
				<br>
				<tr>
					<center>
					<th><input type="submit" value="Submit"></th>
					</center>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
