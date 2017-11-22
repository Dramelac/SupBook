<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post Manager</title>
    <%@ include file="include/style.jsp" %>
</head>
<body>
<%@ include file="include/header.jsp" %>
<div class="container">
    <div class="postIndex">
        <h1 class="postName large">Title</h1>

        <div class="row">
            <div class="col-md-offset-1 col-md-7">
                <c:if test="${not empty post.image}">
                    <img src="${post.image}" class="imagepost">
                </c:if>
                <c:if test="${empty post.image}">
                    <img src="<%=request.getContextPath()%>/img/no-img.png" class="imagepost">
                </c:if>
            </div>
            <div class="col-md-offset-1 col-md-3">
                <p>Posted by ${owner.username} at ${post.createAt}</p>
            </div>
        </div>

        <div class="row col-md-offset-1">
            <p>${post.content}</p>
        </div>

        <br>


        <c:if test="${isOwner}">
            <h2>You are the owner</h2>
            <a href="<%=request.getContextPath()%>/user/updatepost?id=${post.id}" class="button_style2">Edit</a> |
            <a href="<%=request.getContextPath()%>/user/removepost?id=${post.id}"
               class="button_style2">Remove</a><br>
        </c:if>


        <c:if test="${(!isOwner) and (not empty username) }">
            <form name="contact_form" method="POST">
                <p>You can contact ${owner.username} here :</p>
                <label>
                    E-mail of the owner: ${owner.email}
                </label><br><br>
                <label>
                    Content of your mail to the owner:
                </label><br>
                <textarea name="email_content"></textarea>
                <br>
                <c:if test="${success_mail}">
                    <div class="alert alert-success">
                        <strong>Success!</strong> ${message_mail}
                    </div>
                </c:if>
                <c:if test="${failed_mail}">
                    <div class="alert alert-danger">
                        <strong>Failed!</strong> ${message_mail}
                    </div>
                </c:if>
                <input type="submit" value="Send email" class="button">
            </form>
        </c:if>
    </div>
</div>
<%@ include file="include/javascript.jsp" %>
</body>
</html>
