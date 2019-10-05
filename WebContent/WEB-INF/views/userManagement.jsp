<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
	<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>UserManagement</title>
			<link href="resources/css/style.css" rel="stylesheet" type = "text/css">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
			
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
			<script type="text/javascript" src="resources/js/userManagement.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<%@ include file = "adminNavHead.jsp" %>
		<h3>Please Select an option :</h3>
		<select id="userSelect"  class="dropdown">
			  <option value="createUser">Create a User</option>
			  <option value="updateUser">Update a User</option>
			  <option value="deleteUser">Delete a User</option>
		</select>
		
		<div id = "create">
			<form method="post" action="addUser" class="form">
				<br/>
				<label>Username</label>  		: <br/>&nbsp; <input type="text" name = "username" required="required"><br/><br>
				<label>Password </label> 		: <br/>&nbsp; <input type = "password" name = "password" required="required"><br/><br/>
				<label>Firstname </label>		: <br/>&nbsp; <input type="text" name = "firstname" required="required"><br/><br>
				<label>Lastname </label> 		: <br/>&nbsp; <input type="text" name = "lastname" required="required"><br/><br>
				<label>Date Of Birth(DD/MM/YYYY) </label>	: <br/>&nbsp; <input type="date" name = "dateOfBirth" required="required"><br/><br>
				<label>Role </label> 			: <br/>&nbsp; <input type="text" name = "role" required="required"><br/><br>
				<label>Preferred PickUpLocation </label> 		: <br/>&nbsp; <input type="text" name = "preferredPickup" required="required"><br/><br>

	    		<input style="float: middle" type="submit" value="Create" class="button"/>
	    		<br/><br/>
			</form>
		</div>
		<div id="update">
			<form method="post" action="updateUser" class="form">
				<br/>
				<label>User ID</label>  		: <br/>&nbsp; <input type="number" name = "userId" required="required"><br/><br>
				<label>Username</label>  		: <br/>&nbsp; <input type="text" name = "username" ><br/><br>
				<label>Password </label> 		: <br/>&nbsp; <input type = "password" name = "password" ><br/><br/>
				<label>Firstname </label>		: <br/>&nbsp; <input type="text" name = "firstname" ><br/><br>
				<label>Lastname </label> 		: <br/>&nbsp; <input type="text" name = "lastname" ><br/><br>
				<label>Preferred PickUpLocation </label> 		: <br/>&nbsp; <input type="text" name = "preferredPickup" ><br/><br>

	    		<input style="float: middle" type="submit" value="Update" class="button"/>
	    		<br/><br/>
			</form>
		</div>
		<div id="remove">
			<form method="post" action="deleteUser" class="form">
				<br/>
				<label>User Name</label>  		: <br/>&nbsp; <input type="text" name = "username" required="required"><br/><br>
	    		<input style="float: middle" type="submit" value="Remove" class="button"/>
	    		<br/><br/>
			</form>
		</div>
	</body>
</html>