<html>
<head>
	<title>SUPbook : the online student directory</title>
	<link type="text/css" href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" href="<%= request.getContextPath() %>/css/main.css" rel="stylesheet">
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
    <script src="<%= request.getContextPath() %>/js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td valign="top">
			<h1>BackOffice SUPBook</h1>
		</td>
		<td>
			<form action="${pageContext.request.contextPath}/HomeServlet" method="post">
				<textarea rows="1" cols="50" title="SearchBar">Search FirstName, LastName </textarea>
				<button type="button">Search</button>
			</form>
		</td>
		<a href="<%= request.getContextPath() %>/user/logout">Logout</a>
	</tr>
</table>
</body>
</html>