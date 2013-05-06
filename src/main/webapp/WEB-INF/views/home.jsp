<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>

<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javaScript" src="../../scripts/script.js"></script>
<link type="text/css" rel="stylesheet" href="css/stylesheet.css" />
<title>Home</title>
</head>

<body>
	<div id="header">
		<div id="header_div_1">
			<p>Hello Sample Webapp!</p>
		</div>
		<div id="header_div_2">
			<p>The time on the server is ${serverTime}</p>
		</div>
	</div>
	<div class="test_area">
		<h1>Test Area</h1>
		<form name="test_form" action="" method="GET">
			<div>
				<label for="textbox_customer_id">Customer ID</label> <input
					id="textbox_customer_id" name="textbox_customer_id"
					type="text" value="1001" title="Input Customer ID"
					autofocus="autofocus" /> <input id="btn_submit_test_form"
					type="submit" value="Go" />
			</div>
		</form>
		<p>
			<b>Customer ID:</b>
			<%=request.getParameter("textbox_customer_id")%>
		</p>
	</div>
</body>
</html>