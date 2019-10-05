<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Booking</title>
		<link href="resources/css/style.css" rel="stylesheet" type = "text/css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="resources/js/booking.js"></script>
	</head>
	<body>
		<%@ include file = "customerNavHead.jsp" %>
		<div class="tabs">
			<ul class="nav nav-tabs">
			  <li class="active"  id="createTab"><a href="#">Add</a></li>
			  <li id="updateTab"><a href="#">Update</a></li>
			</ul>
		</div>
		<div id="create">
			<div class="form">
				<form method="post" action="createBooking" id="createForm">
						<label>Time</label>  		: <br/>&nbsp; <input type="time" name = "time"  required="required"><br/><br>
						<label>Date</label> 		: <br/>&nbsp; <input type = "date" name = "date" required="required"><br/><br/>
						<label>Size </label>		: <br/>&nbsp; <select name="size" class="options" required="required">
																  <option value="LARGE">Large</option>
																  <option value="MEDIUM">Medium</option>
																  <option value="SMALL">Small</option>
															</select><br/><br>
						<label>PickUpAddress </label>	: <br/>&nbsp; <input type="text" name = "pickUpAddress" required="required"><br/><br>
						<label>Destination</label>	: <br/>&nbsp; <input type="text" name = "destination" required="required"><br/><br>
						<label>Carpool Preference </label> 		: &nbsp; <select name="carpoolOption" class="options">
																  <option value="true">Yes</option>
																  <option value="false">No</option>
															</select><br/><br>		
						 <input style="float: middle" type="submit" value="Register" class="button"/>
									
				</form>
				</div>
		</div>
		
		<div id = "update">
			<table class="table table-hover">
				<tr>
						<th>Booking Id</th> 
						<th>Date:Time</th>
						<th>PickUpAddress</th>
						<th>Destination</th>
						<th>Car Size</th>
						<th>Carpool Option</th>
						<th>Update</th>
						<th>Delete</th>
				</tr>
				<c:forEach items="${allBookings}" var="booking">
					<tr>
						<td>${booking.bookingId}</td>
						<td>${booking.dateTime}</td>
						<td>${booking.pickUpLocation}</td>
						<td>${booking.destination}</td>
						<td>${booking.car.size}</td>
						<td>${booking.carPool}</td>
						<td>
							<button type="button" class="btn btn-primary" id="updateSubmitButton${booking.bookingId} }" data-toggle="modal" data-target="#updateBooking">Update</button>
						</td>
						<td>
							<button type="button" class="btn btn-danger" id="deleteSubmitButton${booking.bookingId} }" data-toggle="modal" data-target="#deleteBooking">Delete</button>
						</td>
					</tr>

				</c:forEach>
			</table>
			</div>
<!-- ==========================================Update Modal ===================================================-->
		        <div id="updateBooking" class="modal fade" role="dialog">
                     <div class="modal-dialog">
                           <div class="modal-content">
                            <div class="modal-header">
                                         <button type="button" class="close" data-dismiss="modal">&times;</button>
                                         <h4 class="modal-title">Update Booking</h4>
                            </div>
                            <div class="modal-body">
                            	<form method="post" action="updateBooking" >
										<input id="updateBookingId" type="hidden" name = "bookingId"  >
										<label>Time</label>  		: <br/>&nbsp; <input id="updateTime" type="time" name = "time"  ><br/><br>
										<label>Date</label> 		: <br/>&nbsp; <input id="updateDate" type = "date" name = "date" ><br/><br/>
										<label>Size </label>		: <br/>&nbsp; <select id="updateSize" name="size" class="options" >
																				  <option value="LARGE">Large</option>
																				  <option value="MEDIUM">Medium</option>
																				  <option value="SMALL">Small</option>
																			</select><br/><br>
										<label>PickUpAddress </label>	: <br/>&nbsp; <input id="updateAddress" type="text" name = "pickUpAddress" ><br/><br>
										<label>Destination</label>	: <br/>&nbsp; <input id="updateDestination" type="text" name = "destination" ><br/><br>
										<label>Carpool Preference </label> 		: &nbsp; <select  id="updateCarPoolOption" name="carpoolOption" class="options">
																				  <option value="true">Yes</option>
																				  <option value="false">No</option>
																			</select><br/><br>	
										<input style="float: middle" type="submit" value="Register" class="button"/>	
                            </form>
                            </div>
                           </div>
                     </div>
              </div>
<!-- ==========================================Delete Modal ===================================================-->
		
		        <div id="deleteBooking" class="modal fade" role="dialog">
                     <div class="modal-dialog">
                           <div class="modal-content">
                            <div class="modal-header">
                                         <button type="button" class="close" data-dismiss="modal">&times;</button>
                                         <h4 class="modal-title"></h4>
                            </div>
                            <div class="modal-body">
                            <label>Are you sure</label>
                            	<form method="post" action="removeBooking" >
										<input id="deleteBookingId" type="hidden" name = "bookingId"  >
										<input style="float: middle" type="submit" value="Delete" class="button"/>	
                           	 </form>
                            </div>
                           </div>
                     </div>
              </div>
	</body>
</html>