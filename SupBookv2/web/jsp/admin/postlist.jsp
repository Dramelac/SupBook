<%--
  Created by IntelliJ IDEA.
  User: doria
  Date: 09/02/2017
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post Manager</title>
    <%@ include file="../include/style.jsp" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container">
    <h1>Posts list : </h1>

    <c:forEach var="a" items="${postList}">
    <div class="postIndex">
        <p>Name : ${a.name} </p>
        <p>Price : ${a.price} €</p>
        <p>Date : ${a.publishDate} </p>
        <c:if test="${not empty a.imageUrl}">
            <img src="${a.imageUrl}" class="imagepost">
        </c:if>
        <br>

        <a href="<%=request.getContextPath()%>/admin/removepost?id=${a.id}" class="button_style2">Remove</a>

        <a href="<%=request.getContextPath()%>/admin/updatepost?id=${a.id}" class="button_style2">Update</a>

    </div>
    </c:forEach>
    <div>
        <%@ include file="../include/javascript.jsp" %>
</body>
</html>
