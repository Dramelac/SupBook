<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>SUPbook : the online student directory</title>
	<link type="text/css" href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet">
</head>
<body>
	<table>
		<tr>
			<td valign="top"><img src="../images/logo.png"
				style="padding-left: 20px; padding-right: 20px;" /></td>
			<td valign="top"><h1>BackOffice SUPBook</h1>
                <c:if test="${not empty message}">
                    <div class="alert alert-danger" role="alert">
                        ${message}
                    </div>
                </c:if>
				<form action="<%=request.getContextPath()%>/register" method="POST">
					<table style="width: 250; border: 1px">
						<tr>
							<td>Username</td>
							<td><input name="username" type="text" required/>
							</td>
						</tr>
						<tr>
							<td>Email</td>
							<td><input name="email" type="email" required/>
							</td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input name="password" type="password" required/>
							</td>
						</tr>
						<tr>
							<td>Password confirmation</td>
							<td><input name="passwordverif" type="password" required/>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit"></td>
						</tr>
					</table>
				</form>
				<a href="<%=request.getContextPath()%>/login">Login</a>
			</td>
		</tr>
	</table>
</body>
</html>