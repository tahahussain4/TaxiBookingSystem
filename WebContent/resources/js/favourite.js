$(document).ready(function(){
	$("#favouriteBooking").hide();
	$("#allFavourites").hide();
	$("#deleteFavourite").hide();
	
	$("#favouriteOptions").click(function(){	
		if($("#favouritesOptions").val() == "favouriteBooking"){
			$("#allFavourites").hide();
			$("#deleteFavourite").hide();
			$("#favouriteBooking").show();
		}
		if($("#favouritesOptions").val() == "displayAllFavourites"){
			$("#favouriteBooking").hide();
			$("#deleteFavourite").hide();
			$("#allFavourites").show();
		}
		if($("#favouritesOptions").val() == "deleteFavourite"){
			$("#favouriteBooking").hide();
			$("#allFavourites").hide();
			$("#deleteFavourite").show();
		}
	})
})