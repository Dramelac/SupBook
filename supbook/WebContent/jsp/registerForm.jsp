<html>
<head>
<title>SUPbook : the online student directory</title>
<link type="text/css" href="<%=request.getContextPath()%>/main.css"
	rel="stylesheet">
</head>
<body>
	<table>
		<tr>
			<td valign="top"><img src="../images/logo.png"
				style="padding-left: 20px; padding-right: 20px;" /></td>
			<td valign="top"><h1>BackOffice SUPBook</h1> <jsp:include
					page="/jsp/messageBar.jsp" />
				<form action="<%=request.getContextPath()%>/register" method="POST">
					<table style="width: 250; border: 1px">
						<tr>
							<td>Username</td>
							<td><input name="username" type="text" />
							</td>
						</tr>
						<tr>
							<td>Email</td>
							<td><input name="email" type="email" />
							</td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input name="password" type="password" />
							</td>
						</tr>
						<tr>
							<td>Password confirmation</td>
							<td><input name="passwordverif" type="password" />
							</td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit"></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>