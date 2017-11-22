<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SupBook - Index</title>
    <%@ include file="include/style.jsp" %>

</head>
<body>
<%@ include file="include/header.jsp" %>

<div class="container">
    <div class="text_index row">
        <img src="<c:url value="/img/logo.png" />" class="col-md-2 logo"/>
        <div class="col-md-offset-1 col-md-8">
            <p>Actualy they are ${userCount} users and ${postCount} ads online !</p>
        </div>
    </div>

    <div class="row">

        <div class="col-md-offset-1 col-md-9">
            <c:forEach var="a" items="${list}">

                <div class="postIndex col-md-12">
                    <a href="<%=request.getContextPath()%>/view?id=${a.id}">
                        <div class="postName">
                            ${a.name}
                        </div>
                        <div class="row col-md-offset-1 col-md-10">
                            <c:if test="${not empty a.imageUrl}">
                                <img src="${a.imageUrl}" class="imagepost">
                            </c:if>
                            <c:if test="${empty a.imageUrl}">
                                <img src="<%=request.getContextPath()%>/img/no-img.png" class="imagepost">
                            </c:if>
                        </div>
                        <div class="row col-md-12">
                            <p>Categorie : ${a.categorie} </p>
                            <p>Price : ${a.price} €</p>
                            <p>Date : ${a.publishDate} </p>
                        </div>
                        <br>
                    </a>

                </div>
            </c:forEach>
        </div>
    </div>
</div>

<%@ include file="include/javascript.jsp" %>
</body>
</html>
