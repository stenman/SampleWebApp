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

	<%-- 		<form name="test_form" action="" method="GET"> --%>
	<!-- 			<div> -->
	<!-- 				<label for="textbox_transaction_id">Transaction ID</label> <input -->
	<!-- 					id="textbox_transaction_id" name="textbox_transaction_id" -->
	<!-- 					type="text" value="1001" title="Input Transaction ID" -->
	<!-- 					autofocus="autofocus" /> <input id="btn_submit_test_form" -->
	<!-- 					type="submit" value="Go" /> -->
	<!-- 			</div> -->
	<%-- 		</form> --%>
	<!-- 		<p> -->
	<!-- 			<b>Transaction ID:</b> -->
	<%-- 			<%=request.getParameter("textbox_transaction_id")%> --%>
	<!-- 		</p> -->


	<!-- TODO: REMOVE THIS! TESTING THE CONTROLLER -->

	<a href="http://localhost:9090/sample-web-app/">RESET</a>
	<br><br><br>
	
	<form name="test_form_1" action="customer1" method="GET">
		<div>
			<label for="lbl_name">Say Hello</label> <input
				id="btn_submit_test_form" type="submit" value="Go" />
		</div>
	</form>

	<form name="test_form_2" action="customer2" method="GET">
		<div>
			<label for="lbl_name">Transaction ID</label> 
			<input id="lbl_name" name="lbl_name" type="text" value="1001" title="Input Transaction ID" /> 
			<input id="btn_submit_test_form" type="submit" value="Go" />
		</div>
	</form>

	<br>


	<h2>Say Hello: ${message1}</h2>
	<h2>Customer: ${message2}</h2>


	<!-- TODO: REMOVE THIS! TESTING THE CONTROLLER -->


</div>