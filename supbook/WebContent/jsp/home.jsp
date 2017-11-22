<html>
<head>
<title>SUPbook : the online student directory</title>
<link type="text/css" href="<%= request.getContextPath() %>/main.css" rel="stylesheet">
</head>
<body>
	<table>
		<tr>
			<td valign="top"><jsp:include page="/jsp/menu.jsp" /></td>
			<td valign="top">
			<h1>BackOffice SUPBook</h1>
		</td>
		<td>
			<form action="${pageContext.request.contextPath}/HomeServlet" method="post">
				<textarea rows="1" cols="50" title="SearchBar">Search FirstName, LastName </textarea>
				<button type="button">Search</button>
			</form>
		</td>
	</tr>
</table>
</body>
</html>