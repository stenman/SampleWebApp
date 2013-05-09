<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="apm_content">
	<h1>Test Area</h1>
<%-- 	<form:form name="test_form" action="addCustomer.html" method="POST"> --%>
<!-- 		<table> -->
<!-- 			<tr> -->
<%-- 				<td><form:label path="id">Customer ID</form:label></td> --%>
<%-- 				<td><form:input path="id" /></td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<%-- 				<td><form:label path="firstName">First Name</form:label></td> --%>
<%-- 				<td><form:input path="firstName" /></td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<%-- 				<td><form:label path="lastName">Last Name</form:label></td> --%>
<%-- 				<td><form:input path="lastName" /></td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td colspan="2"><input type="submit" value="Add Customer" /></td> -->
<!-- 			</tr> -->
<!-- 		</table> -->
<%-- 	</form:form> --%>

		<form name="test_form" action="" method="GET">
			<div>
				<label for="textbox_transaction_id">Transaction ID</label> <input
					id="textbox_transaction_id" name="textbox_transaction_id"
					type="text" value="1001" title="Input Transaction ID"
					autofocus="autofocus" /> <input id="btn_submit_test_form"
					type="submit" value="Go" />
			</div>
		</form>
		<p>
			<b>Transaction ID:</b>
			<%=request.getParameter("textbox_transaction_id")%>
		</p>

</div>