<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="apm_content">
	<h1>Test Area</h1>

	<a href="http://localhost:9090/sample-web-app/">RESET</a> <br> <br>
	<br>

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

	<form:form name="test_form_3" modelAttribute="customer" action="customer3" method="POST">
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

	<h2>Say Hello: ${message1}</h2>
	<h2>GET Customer: ${message2}</h2>
	<h2>POST Customer: ${message3}</h2>


</div>