<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		<link href="resources/css/style.css" rel="stylesheet" type = "text/css">
	</head>
	
	<body >
		<h1 class="heading">Ride It!</h1>
		<h2 class="error">${errorMsg}</h2>
		<h2 class="success">${successMsg} </h2>
		<div class="formHolder">
			<form method="post" action="login" class="form" style="vertical-align:top";>
				Username 		: <br/>&nbsp; <input type="text" name = "username"><br/><br>
				Password 		: <br/>&nbsp; <input type = "password" name = "password"><br/><br/>
				<input type="submit" value = "Login" class="button"/>
				<br/><br/>
			</form>
			<form method="post" action="register" class="form" >
				<label>Username</label>  		: <br/>&nbsp; <input type="text" name = "username" required="required"><br/><br>
				<label>Password </label> 		: <br/>&nbsp; <input type = "password" name = "password" required="required"><br/><br/>
				<label>Firstname </label>		: <br/>&nbsp; <input type="text" name = "firstname" required="required"><br/><br>
				<label>Lastname </label> 		: <br/>&nbsp; <input type="text" name = "lastname" required="required"><br/><br>
				<label>Date Of Birth(DD/MM/YYYY) </label>	: <br/>&nbsp; <input type="date" name = "dateOfBirth" required="required"><br/><br>
				<label>Preferred PickUpLocation </label> 		: <br/>&nbsp; <input type="text" name = "preferredPickup"><br/><br>
	    		<input style="float: middle" type="submit" value="Register" class="button"/>
	    		<br/><br/>
			</form>
		</div>
	</body>
</html>