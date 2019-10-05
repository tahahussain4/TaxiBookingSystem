<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Tracking</title>
			<link href="resources/css/style.css" rel="stylesheet" type = "text/css">
	    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
			<script type="text/javascript" src="resources/js/tracking.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<%@ include file = "customerNavHead.jsp" %>
		
		<div class="tabs">
			<ul class="nav nav-tabs">
			  <li class="active"  id="userBookingsTab"><a href="#">All</a></li>
			  <li id="allBookingsTab"><a href="#">Active</a></li>
			   <li id="allFavouritesTab"><a href="#">Favourites</a></li>
			</ul>
		</div>

		<div id = "userBookings">
			<table class="table table-hover">
				<tr>
						<th>Booking Id</th> 
						<th>Date:Time</th>
						<th>PickUpAddress</th>
						<th>Destination</th>
						<th>Car Size</th>
						<th>Carpool Option</th>
						<th>Favourite</th>
				</tr>
				<c:forEach items="${allUserBookings}" var="booking">
					<tr>
						<td>${booking.bookingId}</td>
						<td>${booking.dateTime}</td>
						<td>${booking.pickUpLocation}</td>
						<td>${booking.destination}</td>
						<td>${booking.car.size}</td>
						<td>${booking.carPool}</td>
						<c:choose>
						<c:when  test="${booking.favourite != null}">
						<td>
							<form method="post" action="deleteFavourite">
								<input  type="hidden" name = "bookingId"  value="${booking.bookingId }">
								<button type="submit" class="btn btn-success" >Unfavourite</button>
							</form>
						</td>
						</c:when>
						<c:otherwise>
						<td>
							<form method="post" action="favouriteABooking">
								<input  type="hidden" name = "bookingId"   value="${booking.bookingId }">
								<button type="submit" class="btn btn-fail" >Favourite</button>
							</form>
						</td>
						</c:otherwise>
						</c:choose>
						
						
					</tr>

				</c:forEach>
			</table>
			</div>
			
		<div id = "allBookings">
			<table class="table table-hover">
				<tr>
						<th>Booking Id</th> 
						<th>Date:Time</th>
						<th>PickUpAddress</th>
						<th>Destination</th>
						<th>Car Size</th>
						<th>Carpool Option</th>
						<th>Favourite</th>
				</tr>
				<c:forEach items="${allActiveBookings}" var="booking">
					<tr>
						<td>${booking.bookingId}</td>
						<td>${booking.dateTime}</td>
						<td>${booking.pickUpLocation}</td>
						<td>${booking.destination}</td>
						<td>${booking.car.size}</td>
						<td>${booking.carPool}</td>
						<c:choose>
						<c:when  test="${booking.favourite != null}">
						<td>
							<form method="post" action="deleteFavourite">
								<input  type="hidden" name = "bookingId"  value="${booking.bookingId }">
								<button type="submit" class="btn btn-success" >Unfavourite</button>
							</form>
						</td>
						</c:when>
						<c:otherwise>
						<td>
							<form method="post" action="favouriteABooking">
								<input  type="hidden" name = "bookingId"   value="${booking.bookingId }">
								<button type="submit" class="btn btn-fail" >Favourite</button>
							</form>
						</td>
						</c:otherwise>
						</c:choose>
					</tr>

				</c:forEach>
			</table>
			</div>
			
		<div id = "allFavourites">
			<table class="table table-hover">
				<tr>
						<th>Booking Id</th> 
						<th>Date:Time</th>
						<th>PickUpAddress</th>
						<th>Destination</th>
						<th>Car Size</th>
						<th>Carpool Option</th>
						<th>Favourite</th>
				</tr>
				<c:forEach items="${allUserBookings}" var="booking">
					<tr>
						<c:if test="${booking.favourite != null}">
						<td>${booking.bookingId}</td>
						<td>${booking.dateTime}</td>
						<td>${booking.pickUpLocation}</td>
						<td>${booking.destination}</td>
						<td>${booking.car.size}</td>
						<td>${booking.carPool}</td>
						
						<td>
							<form method="post" action="deleteFavourite">
								<input  type="hidden" name = "bookingId"  value="${booking.bookingId }">
								<button type="submit" class="btn btn-success" >Unfavourite</button>
							</form>
						</td>
						</c:if>

					</tr>

				</c:forEach>
			</table>
			</div>
	</body>
</html>