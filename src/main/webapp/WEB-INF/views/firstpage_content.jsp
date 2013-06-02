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

<div id="firstpage_content">
	<h3>Test Area</h3>

	<a href="http://localhost:9090/sample-web-app/">RESET</a> <br> <br>

	<div id="firstpage_form">
		<form name="test_form_1" action="sayHello" method="GET">
			<div>
				<label for="lbl_name">Say Hello</label> <input id="btn_submit_test_form" type="submit" value="Go" />
			</div>
		</form>

		<form name="test_form_2" action="getCustomerCount" method="GET">
			<div>
				<label for="lbl_name">Get Customer Count</label> <input id="btn_submit_test_form" type="submit" value="Get count" />
			</div>
		</form>

		<form name="test_form_3" action="getCustomers" method="GET">
			<div>
				<label for="lbl_name">Customer ID</label> <input id="lbl_name" name="lbl_name" type="text" value="1001"
					title="Input Customer ID" /> <input id="btn_submit_test_form" type="submit" value="Get Customer" />
			</div>
		</form>

		<form:form name="test_form_4" modelAttribute="customer" action="submitForm" method="POST">
			<div>
				<table>
					<tr>
						<td>Customer ID</td>
						<td><form:input path="id" value="2000" /></td>
					</tr>
					<tr>
						<td>First Name</td>
						<td><form:input path="firstName" value="Steve" /></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><form:input path="lastName" value="Vai" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Add Customer" /></td>
					</tr>
				</table>
			</div>
		</form:form>

		<br>

		<h4>Say Hello: ${message1}</h4>
		<h4>GET Count: ${message2}</h4>
		<h4>GET Customer: ${message3}</h4>
		<h4>POST Customer: ${message4}</h4>
		<h4>Session attribute: ${message5}</h4>
		<h4>Normal attribute: ${message6}</h4>
	</div>

	<div id="grid_array"></div>
</div>