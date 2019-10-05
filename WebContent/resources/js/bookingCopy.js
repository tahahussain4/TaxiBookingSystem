$(document).ready(function(){
	$("#create").hide();
	$("#workBooking").hide();
	
	$("#bookingSelect").click(function(){
		if($("#bookingSelect").val() == "createBooking"){
			$("#workBooking").hide();
			$("#create").show();
		}
		if($("#bookingSelect").val() == "workBooking"){
			$("#create").hide();
			$("#workBooking").show();
		}
	})
})