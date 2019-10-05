var runOnce = false;
$(document).ready(function(){
	
	$("button").click(function(){
		console.log($(this));
		if($(this)[0].innerText == "Update"){
		var dateTime = $(this)[0].parentNode.parentNode.children[2].innerText

			$("#updateBookingId").attr("value",$(this)[0].parentNode.parentNode.children[0].innerText)
			$("#updateUsername").attr("value",$(this)[0].parentNode.parentNode.children[1].innerText)
			$("#updateTime").attr("value",dateTime.substr(11,5))
			$("#updateDate").attr("value",dateTime.substr(0,10))
			$("#updateSize").val($(this)[0].parentNode.parentNode.children[5].innerText)
			$("#updateAddress").attr("value",$(this)[0].parentNode.parentNode.children[3].innerText)
			$("#updateDestination").attr("value",$(this)[0].parentNode.parentNode.children[4].innerText)
			$("#updateCarPoolOption").val($(this)[0].parentNode.parentNode.children[6].innerText)
		}
		
		else if($(this)[0].innerText == "Delete"){
				$("#deleteBookingId").attr("value",$(this)[0].parentNode.parentNode.children[0].innerText)
		}
		
	})
	

	if(runOnce == false){
		runOnce = true;
		$("#createTab").attr("class","active");
		$("#updateTab").removeClass("active")
		
		$("#create").show();
		$("#update").hide();
	}
	
	$("#createTab").click(function(){
		
		$("#createTab").attr("class","active");
		$("#updateTab").removeClass("active")
		
		$("#create").show();
		$("#update").hide();
	})
		
	
	
	$("#updateTab").click(function(){
		$("#updateTab").attr("class","active");
		$("#createTab").removeClass("active")
		
		$("#update").show();
		$("#create").hide();
	});

	

	

})