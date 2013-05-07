<div id="apm_content">
	<h1>Test Area</h1>
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