<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<head>
	<!--jQuery dependencies-->
	<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/themes/base/jquery-ui.css" />
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/jquery-ui.min.js"></script>
	
	<!--ParamQuery Grid files-->
	<link rel="stylesheet" href="resources/css/pqgrid_css/pqgrid.min.css" />
	<script type="text/javascript" src="resources/scripts/pqgrid_js/pqgrid.min.js" /></script>
	
	<!--ParamQuery Grid Office theme-->
	<link rel="stylesheet" href="resources/css/pqgrid_themes/office/pqgrid.css" />
	
	<!-- ParamQuery Grid Tables -->
	<script type="text/javascript" src="resources/scripts/testing_pqgrid.js" /></script>
</head>

<div id="apm_content">
	<h3>Test Area</h3>

	<a href="http://localhost:9090/sample-web-app/">RESET</a> <br> <br>

	<div id="apm_form">
		<form name="test_form_1" action="customer1" method="GET">
			<div>
				<label for="lbl_name">Say Hello</label> <input
					id="btn_submit_test_form" type="submit" value="Go" />
			</div>
		</form>

		<form name="test_form_2" action="customer2" method="GET">
			<div>
				<label for="lbl_name">Transaction ID</label> <input id="lbl_name"
					name="lbl_name" type="text" value="1001"
					title="Input Transaction ID" /> <input id="btn_submit_test_form"
					type="submit" value="Go" />
			</div>
		</form>

		<form:form name="test_form_3" modelAttribute="customer"
			action="customer3" method="POST">
			<div>
				<table>
					<tr>
						<td>Customer ID</td>
						<td><form:input path="id" /></td>
					</tr>
					<tr>
						<td>First Name</td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Add Customer" /></td>
					</tr>
				</table>
			</div>
		</form:form>

		<br>

		<h4>Say Hello: ${message1}</h4>
		<h4>GET Customer: ${message2}</h4>
		<h4>POST Customer: ${message3}</h4>
	</div>
	
	<div id="grid_array"></div>
</div>