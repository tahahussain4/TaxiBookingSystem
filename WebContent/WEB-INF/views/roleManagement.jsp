<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>RoleManagement</title>
			<link href="resources/css/style.css" rel="stylesheet" type = "text/css">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
			
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
			<script type="text/javascript" src="resources/js/roleManagement.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<%@ include file = "adminNavHead.jsp" %>
	
		<h3>Please Select an option :</h3>
		<select id="roleSelect" class="options"  class="selectpicker">
			  <option value="createRole">Create a Role</option>
			  <option value="deleteRole">Delete a Role</option>
		</select>
		
		<div id="create">
			<form method="post" action="createRole" class="form">
				<br/>
				<label>Role Name</label>	: <br/>&nbsp; <input type="text" name = "role" required="required"><br/><br>
	    		<input style="float: middle" type="submit" value="create" class="button"/>
	    		<br/><br/>
			</form>
		</div>
		<div id="remove">
			<form method="post" action="deleteRole" class="form">
				<br/>
				<label>Role ID</label>  		: <br/>&nbsp; <input type="number" name = "roleId" required="required"><br/><br>
	    		<input style="float: middle" type="submit" value="remove" class="button"/>
	    		<br/><br/>
			</form>
		</div>
	</body>
</html>