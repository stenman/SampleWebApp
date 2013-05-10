<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- TODO: Check if this is needed -->
<%-- <%@ page session="false"%> --%>
<html>

<head>
<title>Sample Web App Home</title>

<!--jQuery dependencies-->
<!-- 	<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script> -->

<!-- Static files -->
<!-- 	<script type="text/javaScript" src="resources/scripts/script.js"></script> -->

<link type="text/css" rel="stylesheet"	href="resources/css/stylesheet.css" />
</head>

<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="left_menu.jsp" />
	<jsp:include page="apm_content.jsp" />
</body>
</html>