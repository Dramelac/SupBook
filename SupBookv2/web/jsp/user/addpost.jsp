<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Post</title>
    <%@ include file="../include/style.jsp" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container">
<h1>Hello ${username}, what do you want to add?</h1>
<br>
<br>
<form action="addpost" method="POST">
    <label class="ajust_labels">
        Its description :

    </label><input type="text" name="description">
    <br><br>
    <label class="ajust_labels">
        Image url :
    </label> <input type="text" name="image">
    <br><br>
    <input type="submit" value="Add post" class="button">
</form>
</div>

<%@ include file="../include/javascript.jsp" %>
</body>
</html>