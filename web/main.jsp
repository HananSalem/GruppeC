<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Central bank</title>
    </head>
    <link type="text/css" rel="stylesheet" href="CSS-main.css">
    <body>
        <h1>Central bank</h1>
        <hr/>

        <h3> Content </h3>

    <c:if test="${pageContext.request.isUserInRole('Customer')==true}">
        <li><a href="Controller?command=customer-accounts">Customer accounts</a></li>
    </c:if >

    <c:choose >
        <c:when test="${pageContext.request.remoteUser== null}">
            <li><a href="Controller?command=showlogin">Go to Login</a>
        </c:when>
        <c:otherwise>
            <li><a href="Controller?command=logout">Log out</a></li>
        </c:otherwise>
    </c:choose>


</body>
</html>
