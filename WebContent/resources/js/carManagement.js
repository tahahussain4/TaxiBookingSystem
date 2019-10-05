$(document).ready(function(){
	$("#create").hide();
	$("#remove").hide();
	
	$("#carSelect").click(function(){	
		if($("#carSelect").val() == "createCar"){
			$("#remove").hide();
			$("#create").show();
		}
		if($("#carSelect").val() == "deleteCar"){
			$("#create").hide();
			$("#remove").show();
		}
	})
})