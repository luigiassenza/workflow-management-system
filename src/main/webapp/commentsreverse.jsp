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

<title>Comments Reverse</title>
</head>
<body>

<center>

	<table class="table table-striped table-nonfluid table-bordered" style="width:auto">
	<c:forEach items="${commentsReverse}" var="item">
		<tr>
			<td>
				<form action="WorkflowproUpdate" method="post">
					<input type="hidden" name="id" value="${item.idWorkflowpro}">
					<button type="submit" class="btn btn-link"><i>${item.idWorkflowpro}</i></button>
				</form>
			</td>
			<td><i>${item.commentDate}</i></td>
			<td><i>${item.username}</i></td>
			<td><i>${item.comment}</i></td>
		</tr>
	</c:forEach>
	</table>
	
</center>

</body>
</html>