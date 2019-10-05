<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
	<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Favourite</title>
			<link href="resources/css/style.css" rel="stylesheet" type = "text/css">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
			
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
			<script type="text/javascript" src="resources/js/favourite.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<%@ include file = "customerNavHead.jsp" %>

		<h3>Please Select  a option :</h3>
		<form method ="post" action="favouriteABooking" class="centered">
			Enter Booking Id : <br/><input type="number" name="bookingId"><br/><br/>
			<input  type="submit" value="Favourite" class="button"/>
		</form>
		<br/><p class="centered">OR<p/><br/>
		<form method ="post" action="allFavourites" class="centered">
			<input style="float: middle" type="submit" value="getAll" class="button"/>
		</form>
		<br/><p class="centered">OR<p/><br/>
		<br/>
		<form method ="post" action="deleteFavourite" class="centered">
			Enter Favourite ID : <br/><input type="number" name="favouriteId"> <br/><br/>
			<input type="submit" value="Delete" class="button"/>
		</form>
		<br/><br/>
		<c:choose>
			<c:when test="${requestScope.allFavourites != null}">
				<table class="table table-hover">
					<tr>
							<th>Booking Id</th>
							<th>Date:Time</th>
							<th>PickUpAddress</th>
							<th>Destination</th>
							<th>CarId</th>
							<th>Carpool Option</th>
					</tr>
					<c:forEach items="${allFavourites}" var="favourite">
						<tr>
							<td>${favourite.booking.bookingId}</td>
							<td>${favourite.booking.dateTime}</td>
							<td>${favourite.booking.pickUpLocation}</td>
							<td>${favourite.booking.destination}</td>
							<td>${favourite.booking.car.carId}</td>
							<td>${favourite.booking.carPool}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
		
		<br/><br/>
	</body>
</html>