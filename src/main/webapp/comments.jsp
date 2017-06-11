<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<title>Comments</title>
</head>
<body>
<center>

	
	<table class="table table-striped table-nonfluid table-bordered" style="width:auto">
	<c:forEach items="${comments}" var="item">
		<tr>
			<td colspan="2">${item.comment}</td>
		</tr>
		<tr>
			<td><i>${item.commentDate}</i></td>
			<td><i>${item.username}</i></td>
		</tr>
		<tr>
			<td colspan="2" bgcolor="#606060"></td>
		</tr>
		<tr>
			<td colspan="2" bgcolor="#606060"></td>
		</tr>
	</c:forEach>
	</table>
	
	
</center>
</body>
</html>