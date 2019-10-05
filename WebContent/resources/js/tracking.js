var runOnce = false;
$(document).ready(function(){
	
//	$("button").click(function(){
//		console.log($(this));
//		if($(this)[0].innerText == "Update"){
//		var dateTime = $(this)[0].parentNode.parentNode.children[1].innerText
//			$("#updateBookingId").attr("value",$(this)[0].parentNode.parentNode.children[0].innerText)
//			$("#updateTime").attr("value",dateTime.substr(11,5))
//			$("#updateDate").attr("value",dateTime.substr(0,10))
//			$("#updateSize").attr("value",$(this)[0].parentNode.parentNode.children[4].innerText)
//			$("#updateAddress").attr("value",$(this)[0].parentNode.parentNode.children[2].innerText)
//			$("#updateDestination").attr("value",$(this)[0].parentNode.parentNode.children[3].innerText)
//			$("#updateCarPoolOption").attr("value",$(this)[0].parentNode.parentNode.children[5].innerText)
//		}
//		
//		else if($(this)[0].innerText == "Delete"){
//				$("#deleteBookingId").attr("value",$(this)[0].parentNode.parentNode.children[0].innerText)
//		}
//		
//	})
//	
	
	if(runOnce == false){
			runOnce = true;
			$("#userBookingsTab").attr("class","active");
			$("#allBookingsTab").removeClass("active")
			$("#allFavouritesTab").removeClass("active")

			$("#userBookings").show();
			$("#allBookings").hide();
			$("#allFavourites").hide();
		}
		
		$("#userBookingsTab").click(function(){
			
			$("#userBookingsTab").attr("class","active");
			$("#allBookingsTab").removeClass("active")
			$("#allFavouritesTab").removeClass("active")
			
			$("#userBookings").show();
			$("#allBookings").hide();
			$("#allFavourites").hide();
		})
			
		
		
		$("#allBookingsTab").click(function(){
			$("#userBookingsTab").removeClass("active")
			$("#allBookingsTab").attr("class","active");
			$("#allFavouritesTab").removeClass("active")
			
			$("#userBookings").hide();
			$("#allBookings").show();
			$("#allFavourites").hide();

		});
		
		$("#allFavouritesTab").click(function(){
			$("#userBookingsTab").removeClass("active")
			$("#allBookingsTab").removeClass("active")
			$("#allFavouritesTab").attr("class","active");
			
			$("#userBookings").hide();
			$("#allBookings").hide();
			$("#allFavourites").show();

		});

})