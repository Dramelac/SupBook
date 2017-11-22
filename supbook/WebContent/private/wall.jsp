<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="listActualité">
    <h1>Les dernières actualité</h1>
    <c:forEach var="p" items="${lastPost}">
        <hr>
        <div id="post">
            <div class="titreannonce">
                <p>Titre : Post ${p.id} </p>
            </div>
            <div id="divimage">
                <img src="${p.image}">
            </div>
            <div class="tablecontenu">
                <table class="descriptionproduits">
                    <tr>
                        <td class="titre">Prix:</td>
                        <td class="resultat">${p.price}</td>
                    </tr>
                    <tr>
                        <td class="titre">Categorie : </td>
                        <td class="resultat">${p.category.name}</td>
                    </tr>

                </table>
                <c:if test="${not empty p.userOwner}">
                    <div>
                        <h4>OwnerId :</h4>
                        <p>${p.userOwner.login}</p >

                    </div>
                </c:if>
                <!--<input type="button" name="details" value="details" onclick="self.location='<%=request.getContextPath()%>/detailAd?productId=${p.id}'"class="boutondetails">-->
            </div>
        </div>
    </c:forEach>
</div>
