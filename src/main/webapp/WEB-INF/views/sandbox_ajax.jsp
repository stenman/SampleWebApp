<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- TODO: Check if this is needed -->
<%-- <%@ page session="false"%> --%>
<html>

<head>
<title>AJAX Sandbox</title>

<script type="text/javascript">
	function log(text) {
		$("#log").append("<p>" + text + "</p>");
	}

	/*ALT 1 - the old fashioned way*/
	function doAjax() {
		$.ajax({
			url : "sandbox_time",
			data : ({
				name1 : "me1",
				name2 : "me2"
			}),
			success : function(data) {
				$("#time").html(data);
			}
		});
	}

	/*ALT 2 - Like alt 1, but assign handlers immediately after making the request and remember the jqxhr object for this request*/
	function doAjax2() {
		var jqxhr = $.ajax({
			url : "sandbox_time",
			data : ({
				name1 : "me3",
				name2 : "me4"
			})
		}).success(function(kalle, olle, pelle) {
			log("success" + kalle + " omg " + olle + " looool " + pelle);
		}).error(function() {
			log("error");
		}).complete(function() {
			log("complete");
		});

		// perform other work here ...

		// Set another completion function for the request above
		jqxhr.complete(function() {
			log("second complete");
		});
	}
	
	/*ALT 3 - this is the preferred way of AJAX callbacks (using Deferred)*/
	function doAjax3MakeRequest() {

		/*This is the AJAX method that we want to execute, but it can be called from anywhere in the application, see below...*/
		return $.ajax({
			url : "sandbox_time",
			data : {
				name1 : "me5",
				name2 : "me6"
			}
		});

		/*The deferred and promise objects can be used in case you want more "control" in the callback method(?)*/
		/*This method would then return the promise*/
		// 		var deferred = new $.Deferred();
		// 		var promise = deferred.promise();
		// 		var jqxhr = $.ajax({
		// 			url : "sandbox_time",
		// 			type : "GET",
		// 			data : {
		// 				name1 : "me5",
		// 				name2 : "me6"
		// 			}
		// 		});
		/*Use of the deferred object*/
		// 		jqxhr.done(function(data, status, xhr) {
		// 			if (!data) {
		// 				log("ajax ok but bad data... data: " + data + " data.data: "
		// 						+ data.data + " data.success: " + data.success);
		// 				deferred.reject(jqxhr, "error");
		// 			} else {
		// 				log("ajax ok and data ok");
		// 				deferred.resolve(data, status, xhr);
		// 			}
		// 		});
		// 		jqxhr.fail(function(jqXHR, status, error) {
		// 			log("ajax error jqXHR: " + jqXHR + " status:" + status + " error: "
		// 					+ error);
		// 			deferred.reject(jqXHR, status, error);
		// 		});
		// 		return promise;
	}

	function doAjax3() {
		var r = doAjax3MakeRequest();
		r.done(function(data) {
			$("#time").html(data);
		});
		/*Some more examples of handling of the response*/
		// 		r.done(function(data, status) {
		// 			$("#time").html(data);
		// 			log("success handler 1 (" + status);
		// 		});
		// 		r.done(function() {
		// 			log("success handler 2");
		// 		});
		// 		r.fail(function(jqXHR, status) {
		// 			log("error handler 1 (" + status + ")");
		// 		});
		// 		r.fail(function() {
		// 			log("error handler 2");
		// 		});
		// 		r.always(function() {
		// 			log("This is always called, no matter what status the response has!");
		// 		});
		// 		There is also r.then, google it for reference
		
	}


</script>

</head>

<body>

	${message}
	<br>
	<button id="demo1" onclick="doAjax()" title="Button 1">Get the time 1!</button>
	<br>
	<button id="demo2" onclick="doAjax2()" title="Button 2">Get the time 2!</button>
	<br>
	<button id="demo3" onclick="doAjax3()" title="Button 3">Get the time 3!</button>

	<div id="dime"></div>
	<div id="time"></div>
	<div id="lime"></div>
	<div id="log"></div>

</body>
</html>