/**
 * 
 */

var register = function() {
	var name = $("#name").val();
	var email = $("#email").val();
	var college = $("#college").val();
	var stream = $("#stream").val();

	if (!name || !email) {
		failed("PLease enter name and email");
		return;
	}

	$("#register_button").hide();
	$("#register_button_dummy").show();
	$("#registrationsuccess").hide();
	$("#registrationerror").hide();

	var settings = {
		"url" : "/api/registrations",
		"method" : "POST",
		"timeout" : 0,
		"headers" : {
			"Authorization" : "",
			"Content-Type" : "application/json"
		},
		"data" : JSON.stringify({
			"studentName" : name,
			"email" : email,
			"college" : college,
			"stream" : stream
		}),
		success : function(data, status, xhr) {
			success();
		},
		error : function(xhr, status, error) {
			failed("Registration Failed, please try with valid details and avoid duplicate Emails.")
			return;
		},
		complete : function() {
			$("#register_button").show();
			$("#register_button_dummy").hide();
		}
	};

	function success() {
		$("#registrationsuccess").show();
		$("#registrationerror").hide();

		$("#name").val("");
		$("#email").val("");
		$("#college").val("");
		$("#stream").val("");
		$("#mobile").val("");
	}

	function failed(message) {
		$("#registrationsuccess").hide();
		$("#registrationerror").show();
		$("#registrationerror").html(message);
	}

	$.ajax(settings)

}
