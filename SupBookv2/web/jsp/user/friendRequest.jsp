<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>friend request</p>

    <form action="/friend" method="POST">
        <input type="submit" value="test">
    </form>

    <div class="container">
        <h1>Friend Request list : </h1>

        <c:forEach var="a" items="${list}">
        <div class="friendRquestIndex">

            <p>Name : ${a.owner.username} </p>

        </div>
        </c:forEach>
    </div>

</body>
</html>
