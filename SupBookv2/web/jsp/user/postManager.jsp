<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post Manager</title>
    <%@ include file="../include/style.jsp" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container">
    <h1>Hello ${username}, this is your post.</h1>


    <c:forEach var="a" items="${list}">
        <div class="postIndex">
            <div class="postName">${a.name}</div>
            <br>
            <p>${a.description}</p><br>
            <a href="<%=request.getContextPath()%>/view?id=${a.id}" class="button_style2">View</a> |
            <a href="<%=request.getContextPath()%>/user/updatepost?id=${a.id}" class="button_style2">Edit</a> |
            <a href="<%=request.getContextPath()%>/user/removepost?id=${a.id}" class="button_style2">Remove</a><br>
        </div>
    </c:forEach>

</div>
<%@ include file="../include/javascript.jsp" %>
</body>
</html>
