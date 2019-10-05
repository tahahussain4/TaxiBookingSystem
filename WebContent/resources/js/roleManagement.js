$(document).ready(function(){
	$("#create").hide();
	$("#remove").hide();
	
	$("#roleSelect").click(function(){	
		if($("#roleSelect").val() == "createRole"){
			$("#remove").hide();
			$("#create").show();
		}
		if($("#roleSelect").val() == "deleteRole"){
			$("#create").hide();
			$("#remove").show();
		}
	})
})