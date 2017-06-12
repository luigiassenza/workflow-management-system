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

<title>Workflow management</title>
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
<h1>Workflow Management</h1>
<br>
<div class="row">
	<div class="col-md-1">
	</div>
	<div class="col-md-3 col-centered" >
		<h4>Last Tasks</h4>
		<div style="overflow-y:scroll; width:450px; height: 100px">
			<!-- Real time chat message system -->		
			<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        	<script>
	            $(document).ready(function(){
	                 setInterval(function() {
	                      $("#tasks").load("WorkflowproDisplayReverse");
	                 }, 3000);
	            });
	       	</script>
       		<div id="tasks"></div>
		</div>
	</div>
	<div class="col-md-1">
	</div>
	<div class="col-md-4 col-centered" >
		<h4>Last Comments</h4>
		<div style="overflow-y:scroll; width:450px; height: 100px">
			<!-- Real time chat message system -->		
			<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        	<script>
	            $(document).ready(function(){
	                 setInterval(function() {
	                      $("#comments").load("WorkflowproCommentsDisplayReverse");
	                 }, 3000);
	            });
	       	</script>
       		<div id="comments"></div>
		</div>
	</div>
	<div class="col-md-2 col-centered" >
		<h4>Go to Task Management Page</h4>
		<form action="WorkflowproDisplay" method="post">
			<button class="btn btn-primary" type="submit">Task Page</button>
		</form>
	</div>
</div>


<br>
<div class="row">
	<div class="col-md-1">
	</div>
    <div class="col-md-3 col-centered" >
    	<h4>Summary by Status</h4>
    	<table class="table table-striped table-nonfluid table-bordered table-condensed text-center" style="width:auto">
    		<tr>
    			<th>Status</th>
    			<th>#</th>
    		</tr>
				<c:forEach items="${statusDetail}" var="item">
					<tr>
 			    		<td>${item.status}</td>
 			    		<td>${item.count}</td>
 			    	</tr>
				</c:forEach>
		</table>
    </div>
    <div class="col-md-3 col-centered col-centered">
    	<h4>Summary by Name and Status</h4>
    	<table class="table table-striped table-nonfluid table-bordered table-condensed text-center" style="width:auto">
			<tr>
				<th>Name</th>
				<th>Status</th>
				<th>#</th>
			</tr>
			<c:forEach items="${statusNameDetail}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.status}</td>
					<td>${item.count}</td>
				</tr>
			</c:forEach>
		</table>
    </div>
    <div class="col-md-3 col-centered">
    	<h4>Summary by Name and Status (Outstanding)</h4>
    	<table class="table table-striped table-nonfluid table-bordered table-condensed text-center" style="width:auto">
			<tr>
				<th>Name</th>
				<th>Status</th>
				<th>#</th>
			</tr>
			<c:forEach items="${statusNameDetailOutstanding}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.status}</td>
					<td>${item.count}</td>
				</tr>
			</c:forEach>
		</table>
    </div>
</div>

</center>

</body>
</html>