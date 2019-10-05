<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
	<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>CarManagement</title>
			<link href="resources/css/style.css" rel="stylesheet" type = "text/css">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
			
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
			<script type="text/javascript" src="resources/js/carManagement.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<%@ include file = "adminNavHead.jsp" %>
		<h3>Please Select an option :</h3>
		<select id="carSelect" class="options"  class="dropdown">
			  <option value="createCar">Create a Car</option>
			  <option value="deleteCar">Delete a Car</option>
		</select>
		
		<div id="create">
			<form method="post" action="createCar" class="form">
				<br/>
				<label>Model</label>  		: <br/>&nbsp; <input type="text" name = "model" required="required"><br/><br>
				<label>Size </label>		: <br/>&nbsp; <select name="size" class="options">
														  <option value="LARGE">Large</option>
														  <option value="MEDIUM">Medium</option>
														  <option value="SMALL">Small</option>
													</select><br/><br>
				<label>Gear </label>	: <br/>&nbsp; <input type="text" name = "gear" required="required"><br/><br>
				<label>Occupancy</label>	: <br/>&nbsp; <input type="number" name = "occupancy" required="required"><br/><br>
	    		<input style="float: middle" type="submit" value="create" class="button"/>
	    		<br/><br/>
			</form>
		</div>
		<div id="remove">
			<form method="post" action="deleteCar" class="form">
				<br/>
				<label>Car ID</label>  		: <br/>&nbsp; <input type="text" name = "carId" required="required"><br/><br>
	    		<input style="float: middle" type="submit" value="remove" class="button"/>
	    		<br/><br/>
			</form>
		</div>
	</body>
</html>