$(document).ready(function(){
	$("#create").hide();
	$("#remove").hide();
	$("#update").hide();
	
	$("#userSelect").click(function(){	
		if($("#userSelect").val() == "createUser"){
			$("#remove").hide();
			$("#update").hide();
			$("#create").show();
		}
		if($("#userSelect").val() == "updateUser"){
			$("#remove").hide();
			$("#create").hide();
			$("#update").show();
		}
		if($("#userSelect").val() == "deleteUser"){
			$("#create").hide();
			$("#update").hide();
			$("#remove").show();
		}
	})
})