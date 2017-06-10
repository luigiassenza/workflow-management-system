<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<title>New Task</title>
</head>
<body>

	<% 
		if(session.getAttribute("username") == null) {
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	%>


<div align="right">
	<form action="WorkflowproLogout" method="post">
		<b><i>${username}</i></b> <button class="btn btn-default" type="submit">Logout</button>
	</form>
</div>

<center>
<h1>Register New Task</h1>
<form action="WorkflowproNewTaskRegister" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>Name*:</td>
			<td>
				<select name="name" class="form-control" data-style="btn-info" title="Name">
					<option disabled selected hidden>Employee Name</option>
						<c:forEach items="${employees}" var="item">
							<option value="${item.name}">${item.name}</option>
						</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td height="10">
			</td>
		</tr>
		<tr>
			<td>Task*:</td>
			<td><input type="text" name="task" class="form-control" placeholder="Enter new task"></td>
		</tr>
		<tr>
			<td height="10">
			</td>
		</tr>
		<tr>
			<td>Comments:</td>
			<td><textarea name="comments" rows="5" cols="50" class="form-control" placeholder="Enter a comment"></textarea></td>
		</tr>
		<tr>
			<td height="10">
			</td>
		</tr>
		<tr>
			<td>Documents to upload:</td>
			<td><input type="file" name="file" multiple></td>
		</tr>
		<tr>
			<td height="10">
			</td>
		</tr>
			<td></td>	
			<td><input type="submit" value="SUBMIT" class="btn btn-primary"></td>
		</tr>
	</table>
</form>

<br>

	<form action="WorkflowproUpdateBack" method="post">
		<button class="btn btn-default" type="submit">BACK</button>
    </form>
     
</center>
</body>
</html>