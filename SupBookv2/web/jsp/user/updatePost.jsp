<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Post</title>
    <%@ include file="../include/style.jsp" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container">
<h1>Editing product : </h1>
<br>
<br>
<form action="updatepost" method="POST">
    <input type="hidden" name="id" value="${post.id}">
    <label class="ajust_labels">
        Its  content :

    </label> <input type="text" name=" content" value="${post.content}">
    <br><br>
    <label class="ajust_labels">
        Image url :

    </label> <input type="text" name="image" value="${post.image}">
    <br><br>
    <input type="submit" value="Update post" class="button">
</form>
</div>

<%@ include file="../include/javascript.jsp" %>
</body>
</html>