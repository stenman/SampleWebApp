<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring LOL - Add stuff</title>
</head>
<body>
	<h2>Customer Manager</h2>
	<form:form method="post" action="addCustomer.html">

		<table>
			<tr>
				<td><form:label path="id">Customer ID</form:label></td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="firstName">First Name</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Customer" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>