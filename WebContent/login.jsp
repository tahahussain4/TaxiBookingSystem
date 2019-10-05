<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		<style>
			.error{color :red}
		</style>
	</head>
	<link href="resources/css/style.css" rel="stylesheet" type = "text/css">
	<body >
		<h1><br/>McCab<br/><br/></h1>
		<h2 class="error">${errorMsg}</h2>
		<form method="post" action="login" class="form">
			<br/>
			Username : &nbsp; <input type="text" name = "username"><br/><br>
			Password : &nbsp; <input type = "password" name = "password"><br/><br/>
			<input type="submit" value = "Login">
			<br/><br/>
		</form>
		<br/>
		<ul>
		
		</ul>
		<form id="formReg" action="register">
    		<input style="float: middle" type="submit" value="Register"/>
		</form>
	</body>
</html>