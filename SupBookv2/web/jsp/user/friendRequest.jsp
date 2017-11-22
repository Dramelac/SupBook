<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Friend Request</title>
    <%@ include file="../include/style.jsp" %>
</head>

<body>
    <%@ include file="../include/header.jsp" %>

    <div class="container">
        <h1>Friend Request list : </h1>

        <c:forEach var="a" items="${list}">
        <div class="friendRquestIndex">

            <p>Name : ${a.owner.username} </p>
            <p><a href="<%=request.getContextPath()%>/acceptfriend" class="button_style2">Accept </a></p>
            <p><a href="<%=request.getContextPath()%>/denyfriend" class="button_style2">Deny</a></p>

        </div>
        </c:forEach>
    </div>
    <%@ include file="../include/javascript.jsp" %>
</body>
</html>
