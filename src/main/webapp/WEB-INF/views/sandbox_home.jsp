<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- TODO: Check if this is needed -->
<%-- <%@ page session="false"%> --%>
<html>

<head>
<title>Sandbox Home</title>

<!--jQuery dependencies-->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

<!-- Static files -->
<!-- 	<script type="text/javaScript" src="resources/scripts/script.js"></script> -->

<link type="text/css" rel="stylesheet"
	href="resources/css/sandbox_stylesheet.css" />



<script type="text/javascript">
	function doAjax() {
		$.ajax({
			url : 'time.html',
			data : ({
				name : "me"
			}),
			success : function(data) {
				$('#time').html(data);
			}
		});
	}
</script>


</head>

<body>

	${message}
	<button id="demo" onclick="doAjax()" title="Button">Get the
		time!</button>
	<div id="time"></div>

</body>
</html>